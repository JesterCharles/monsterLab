# FROM specifies a "base image" that should be used for the image we are about to create
FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD


# Let's us include the created JAR file into the image, so it can be ran within the container
COPY ./ ./

# ADD vs COPY
# Effectively the same
# Technically, COPY is used when moving local files into the image
# ADD is used to grab external files and move them into the image

RUN mvn clean package

FROM openjdk:8-jre-alpine3.9

COPY --from=MAVEN_BUILD /monsterLab/target/monsterLab-0.0.1-SNAPSHOT.jar /monsterLab.jar

# Allows us to specify a primary command(s) that should be ran to initialize the container
# You cannot use ARGs in an ENTRYPOINT, only ENVs can be referenced
ENTRYPOINT [ "java -jar monsterLab.jar" ]