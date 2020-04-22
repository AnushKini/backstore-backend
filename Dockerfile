FROM java:8
VOLUME /tmp
ADD target/bookstore-spring-boot-0.0.1-SNAPSHOT.jar /bookstore.jar
RUN bash -c 'touch /bookstore.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","/bookstore.jar"]