# FROM specifies a "base image" that should be used for the image we are about to create
FROM openjdk:8-jdk-alpine

# Allows us to provide some value at image build time using the --build-arg flag
# For instance: docker build --build-arg profile=dev
ARG profile=local

# Creates and sets an environment variable that will be present in the resulting container
ENV PROFILE=${profile}

# Let's us include the created JAR file into the image, so it can be ran within the container
COPY target/*.jar monsterLab.jar

# ADD vs COPY
# Effectively the same
# Technically, COPY is used when moving local files into the image
# ADD is used to grab external files and move them into the image

# Allows us to expose ports from the container to the host machine
# Used when we run the container
#                             host:container
# For instance: docker run -p 8080:3000
EXPOSE 8080

# Allows us to specify a primary command(s) that should be ran to initialize the container
# You cannot use ARGs in an ENTRYPOINT, only ENVs can be referenced
ENTRYPOINT [ "java -jar -Dspring.profiles.active=${PROFILE} monsterLab.jar" ]