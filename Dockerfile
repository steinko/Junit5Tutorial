FROM openjdk:12
COPY build/libs/Junit5Tutorial.jar ./
ENTRYPOINT ["java"]
CMD ["-jar", "/Junit5Tutorial.jar"]
EXPOSE 8080