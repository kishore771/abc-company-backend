# Step 1: Build WAR using Maven
FROM maven:3.8.5-openjdk-17-slim AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Run WAR using Tomcat
FROM tomcat:9.0-jdk17
COPY --from=build /app/target/abc-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
