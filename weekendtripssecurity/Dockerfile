FROM openjdk:11
EXPOSE 9102
ADD target/payment-service.jar security-service.jar 
ENTRYPOINT [ "java","-jar","/security-service.jar" ]