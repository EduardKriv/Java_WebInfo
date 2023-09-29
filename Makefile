docker-start: docker-build docker-up
docker-restart: docker-down docker-up
docker-rebuild: docker-down rmi docker-build docker-up
docker-stop: docker-down rmi

docker-down:
	docker-compose down --remove-orphans

docker-build:
	docker-compose build

docker-up:
	docker-compose up -d

rmi:
	docker images -a | grep "java_webinfo.*" | awk '{print $3}' | xargs docker rmi

start: build run

build:
	./mvnw clean compile package

run:
	./mvnw spring-boot:run