FROM openjdk:11
EXPOSE 9101
ADD target/payment-service.jar weekendtrip-service.jar 
ENTRYPOINT [ "java","-jar","/weekendtrip-service.jar" ]