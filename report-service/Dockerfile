FROM openjdk:11
EXPOSE 9104
ADD target/payment-service.jar report-service.jar 
ENTRYPOINT [ "java","-jar","/report-service.jar" ]