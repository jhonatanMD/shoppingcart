FROM openjdk:11.0.9
VOLUME /tmp
EXPOSE 8089
ADD "./target/ws-0.0.1-SNAPSHOT.jar" "app-shopping-cart.jar"
ENTRYPOINT ["java","-jar","app-shopping-cart.jar"]