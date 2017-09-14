# The MIT License
#
#  Copyright (c) 2015, CloudBees, Inc.
#
#  Permission is hereby granted, free of charge, to any person obtaining a copy
#  of this software and associated documentation files (the "Software"), to deal
#  in the Software without restriction, including without limitation the rights
#  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
#  copies of the Software, and to permit persons to whom the Software is
#  furnished to do so, subject to the following conditions:
#
#  The above copyright notice and this permission notice shall be included in
#  all copies or substantial portions of the Software.
#
#  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
#  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
#  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
#  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
#  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
#  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
#  THE SOFTWARE.

FROM java:8-jdk
MAINTAINER Clayton Flesher <clayton@hoegg.software>

ARG GITHUB_USER
ARG GITHUB_TOKEN
ARG JENKINS_SERVER_URL

ENV HOME /var/jenkins_home
RUN useradd -c "Jenkins user" -d $HOME -m jenkins
# Add Jenkins to the 'users' group so that it can have access to docker.
RUN usermod -G users jenkins

RUN curl --create-dirs -sSLo /usr/share/jenkins/slave.jar https://${GITHUB_USER}:${GITHUB_TOKEN}@${JENKINS_SERVER_URL}/jnlpJars/slave.jar \
  && chmod 755 /usr/share/jenkins \
  && chmod 644 /usr/share/jenkins/slave.jar

COPY jenkins-slave /usr/local/bin/jenkins-slave

WORKDIR /var/jenkins_home
USER jenkins

ENTRYPOINT ["jenkins-slave"]
