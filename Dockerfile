# Usar una imagen base de Java 17
FROM openjdk:17-jdk-slim AS build

# Establece el directorio de trabajo en /app
WORKDIR /app

# Copia el archivo pom.xml y el archivo de configuración Maven
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Copia todos los archivos del proyecto
COPY src src

# Empaqueta la aplicación utilizando Maven
RUN ./mvnw package

# Usa una imagen base ligera de Java
FROM openjdk:17-jdk-slim

# Copia el archivo JAR construido en la etapa anterior
COPY --from=build /app/target/*.jar /app/app.jar

# Establece el comando de inicio de la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]


# Construir imagen
# docker build -t app-superhero-image:1.1 .

# Ejecutar aplicacion
# docker run -p8080:8080 --name app-superhero-container app-superhero-image:1.1

