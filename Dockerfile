FROM crpi-whdz2l2sopzelm2i-vpc.cn-beijing.personal.cr.aliyuncs.com/kangvai/eclipse-temurin:21-jre-jammy

WORKDIR /app
COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
