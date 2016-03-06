node('test-agent') {
    git url: 'https://github.com/damnhandy/Handy-URI-Templates.git'
    sh "./mvnw clean install"
}
