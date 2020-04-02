FROM openjdk:13
FROM mysql:8
EXPOSE 8080
ADD target/ums-spring.jar ums-spring.jar
ENTRYPOINT ["java", "-jar", "/ums-spring.jar"]