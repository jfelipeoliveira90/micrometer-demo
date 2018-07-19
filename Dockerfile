FROM openjdk:8-jdk-alpine

LABEL author="Felipe Oliveira" \
      email="jfelipeoliveira90@gmail.com" \
      twitter="@jfelipe90"

ADD /build/distributions/micrometer-demo-boot.tar /opt/jfelipe

WORKDIR /opt/jfelipe/micrometer-demo-boot/bin/

EXPOSE 8080

ENTRYPOINT ["sh", "micrometer-demo"]