FROM openjdk:21-jdk

#creation d'un repertoire
RUN mkdir /usr/local/mon_api

COPY api-0.0.1-SNAPSHOT.jar /usr/local/mon_api/api-0.0.1-SNAPSHOT.jar

EXPOSE 9000

# creation d'un variable d'environnement JAVA_HOME
ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk
ENV PATH="$JAVA_HOME/bin:$PATH"

#creation d'un label indiquant le responsable de ce dockerfile
LABEL email=evan.aljundi@devops-afpa.fr

# designation du repertoire de travail
WORKDIR /usr/local/mon_api

ENTRYPOINT ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]