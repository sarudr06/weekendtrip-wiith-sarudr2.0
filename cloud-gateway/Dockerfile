FROM openjdk:11
EXPOSE 2020
ADD target/payment-service.jar cloud-gateway.jar 
ENTRYPOINT [ "java","-jar","/cloud-gateway.jar" ]