#maven jar build
FROM maven:3.6.3-jdk-11 AS builder
WORKDIR /work
# dependencies layer
ADD pom.xml .
RUN mvn verify clean --fail-never
COPY . .
RUN mvn -v
RUN mvn clean package
#actual app image
FROM amazoncorretto:11
COPY --from=builder /work/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
