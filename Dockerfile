FROM tomcat:8.5.70-jdk8-adoptopenjdk-openj9
LABEL org.opencontainers.image.authors="behlp@objectcomputing.com"
RUN apt-get update
RUN useradd -ms /bin/bash grails

USER root
WORKDIR /home/grails

COPY --chown=root:root ./build/libs/interceptorDemo-0.*.war /usr/local/tomcat/webapps/synchr.war

EXPOSE 8080

CMD ["catalina.sh", "run"]