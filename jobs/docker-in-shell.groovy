node('test-agent') {
    // Get some code from a GitHub repository
    git url: 'https://github.com/damnhandy/Handy-URI-Templates.git'
    sh 'docker run -t -u 1000:1000 --volumes-from=jenkins-data -w /var/jenkins_home/workspace/uri-templates-in-docker maven:3.3.3-jdk-8 ./mvnw package'
}
