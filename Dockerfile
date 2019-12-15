FROM java:8

ENV PROJECT_ARTIFACTID="search" PROJECT_VERSION="0.0.1-SNAPSHOT"

COPY target/$PROJECT_ARTIFACTID-$PROJECT_VERSION.jar /search.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "search.jar"]