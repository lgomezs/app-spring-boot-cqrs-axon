FROM openjdk:11-jre-slim
LABEL maintainer="Luis MIguel Gomez Saavedra <lgomesaa@everis.com>"

WORKDIR /opt/
ADD  target/*-app-*.jar /opt/app.jar

EXPOSE 8080
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -XshowSettings:vm\
                -Dspring.profiles.active=$PROFILE \
                -jar app.jar"]