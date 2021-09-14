FROM openjdk:11
VOLUME /tmp
EXPOSE 8081
ADD ./build/DEMO-FC-0.0.1-SNAPSHOT.jar fc-booking.jar
ENTRYPOINT ["java","-jar","/fc-booking.jar"]