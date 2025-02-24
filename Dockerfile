FROM openjdk:21-jdk

# designation du repertoire de travail
WORKDIR /app

COPY api-0.0.1-SNAPSHOT.jar api-0.0.1-SNAPSHOT.jar

EXPOSE 9000

# creation d'un variable d'environnement JAVA_HOME
#ENV JAVA_HOME=/usr/lib/jvm/java-21-openjdk
#ENV PATH="$JAVA_HOME/bin:$PATH"

#spring_jpa_properties_hibernate_dialect=org.hibernate.dialect.MySQL8Dialect
#spring_jpa_show_sql=true
#spring_jpa_properties_hibernate_format_sql=true

#creation d'un label indiquant le responsable de ce dockerfile
LABEL email=evan.aljundi@devops-afpa.fr

ENTRYPOINT ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]