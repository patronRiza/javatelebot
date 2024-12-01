FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_javatele_bot
ENV BOT_TOKEN=8132631337:AAGXaY_rsRSQbfR05tDwVV3e8kZMLZ6ol0g
COPY ${JAR_FILE} app.jar
CMD ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]