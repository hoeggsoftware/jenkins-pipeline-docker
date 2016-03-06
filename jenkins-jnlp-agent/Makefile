

build:
	docker build -t damnhandy/jenkins-slave .

run:
	docker run -v /var/run/docker.sock:/var/run/docker.sock -v $(which docker):/bin/docker damnhandy/jenkins-slave -url http://192.168.99.100:8080/
