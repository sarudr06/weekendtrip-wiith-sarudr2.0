FROM openjdk:11
EXPOSE 8761
ADD target/payment-service.jar service-registry.jar 
ENTRYPOINT [ "java","-jar","/service-registry.jar" ]