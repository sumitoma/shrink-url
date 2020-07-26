FROM openjdk:14-alpine
COPY target/shrink-ln-*.jar shrink-ln.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "shrink-ln.jar"]