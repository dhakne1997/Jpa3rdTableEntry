FROM openjdk:17
ADD target/JpaTableShift-0.0.1-SNAPSHOT.jar JpaTableShift-0.0.1-SNAPSHOT.jar
EXPOSE 9007
ENTRYPOINT ["java","-jar","JpaTableShift-0.0.1-SNAPSHOT.jar"]