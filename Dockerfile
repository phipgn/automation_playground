FROM ubuntu:16.04

# Install the pre-requisite
RUN apt-get update -y
RUN apt-get install -y curl
RUN apt-get install -y p7zip \
    p7zip-full \
    unace \
    zip \
    unzip \
    bzip2 \
    wget

ARG CHROME_URL=https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
ARG JAVA_URL=https://download.java.net/java/ga/jdk11/openjdk-11_linux-x64_bin.tar.gz
ARG JAVA_HOME=/usr/share/java
ARG MAVEN_URL=https://dlcdn.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.tar.gz
ARG MAVEN_HOME="/usr/share/maven"

# Set up environment paths
ENV PATH "$PATH:$JAVA_HOME/bin"
ENV PATH "$PATH:$MAVEN_HOME/bin"

COPY . /java-selenium-demo
WORKDIR /java-selenium-demo

# Install Chrome
RUN curl -ko /tmp/chrome.deb ${CHROME_URL}
RUN apt-get install -y /tmp/chrome.deb

# Install Chrome driver
ARG DRIVER_DIR=/java-selenium-demo/drivers
RUN mkdir -p ${DRIVER_DIR}
RUN CHROME_VERSION=$(google-chrome --product-version) && \
    curl -ko ${DRIVER_DIR}/chrome_driver.zip https://chromedriver.storage.googleapis.com/${CHROME_VERSION}/chromedriver_linux64.zip && \
    unzip ${DRIVER_DIR}/chrome_driver.zip -d ${DRIVER_DIR}

# Install Java 11
RUN mkdir -p ${JAVA_HOME}
RUN curl -ko /tmp/jdk.tar.gz ${JAVA_URL}
RUN tar -xzf /tmp/jdk.tar.gz -C ${JAVA_HOME} --strip-components=1

# Install Maven
RUN mkdir -p ${MAVEN_HOME}
RUN curl -ko /tmp/apache-maven.tar.gz ${MAVEN_URL}
RUN tar -xzf /tmp/apache-maven.tar.gz -C ${MAVEN_HOME} --strip-components=1
RUN mvn clean test-compile

# Clean up downloaded files
RUN rm ${DRIVER_DIR}/chrome_driver.zip && \
    rm /tmp/chrome.deb && \
    rm /tmp/apache-maven.tar.gz && \
    rm /tmp/jdk.tar.gz

