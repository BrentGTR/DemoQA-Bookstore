#Install Maven with jdk11
FROM registry.gitlab.com/investec/docker/base/maven/maven:3.6.3-jdk-11
USER root


# Chrome browser to run the tests
RUN curl http://dl-ssl.google.com/linux/linux_signing_key.pub -o /tmp/google.pub \
    && cat /tmp/google.pub | apt-key add -; rm /tmp/google.pub \
    && echo 'deb http://dl.google.com/linux/chrome/deb/ stable main' > /etc/apt/sources.list.d/google.list \
    && mkdir -p /usr/share/desktop-directories \
    && apt-get -y update && apt-get install -y google-chrome-stable


# Download and install Chromedriver
RUN CHROMEDRIVER_VERSION=`curl -sS https://chromedriver.storage.googleapis.com/LATEST_RELEASE` && \
    mkdir -p /opt/chromedriver-$CHROMEDRIVER_VERSION && \
    curl -sS -o /tmp/chromedriver_linux64.zip https://chromedriver.storage.googleapis.com/$CHROMEDRIVER_VERSION/chromedriver_linux64.zip && \
    unzip -qq /tmp/chromedriver_linux64.zip -d /opt/chromedriver-$CHROMEDRIVER_VERSION && \
    rm /tmp/chromedriver_linux64.zip && \
    chmod +x /opt/chromedriver-$CHROMEDRIVER_VERSION/chromedriver && \
    ln -fs /opt/chromedriver-$CHROMEDRIVER_VERSION/chromedriver /usr/bin/chromedriver


#COPY src /home/mvn/apps/src
#COPY settings.xml /usr/share/maven/conf/settings.xml
COPY pom.xml /home/mvn/apps/pom.xml

#USER mvn

#RUN mvn -DsuiteXmlFile=Periscope.xml test
#sample run command: mvn -DsuiteXmlFile=Regression.xml -Dgroups=CG -Denv=tst test