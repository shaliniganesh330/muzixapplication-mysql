FROM openjdk:11
WORKDIR usr/src
ENV MYSQL_DATABASE=db2
ENV MYSQL_USER=root_app
ENV MYSQL_PASSWORD=root123
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/db2
ADD ./home/user/Documents/muzixapplication-mysql/target /home/user/Documents/muzixapplication-mysql/target
EXPOSE 8080
ENTRYPOINT ["java","-jar","muzixapplication-0.0.1-SNAPSHOT.jar"]
