FROM adoptopenjdk/openjdk16:jre-16.0.1_9
RUN mkdir /opt/app
COPY target/cliente.jar /opt/app
EXPOSE 8080
CMD ["java", "-jar","-Dspring.profiles.active=prd" ,"/opt/app/cliente.jar"]