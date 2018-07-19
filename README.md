# Build 

Project
```
./gradlew clean build
```

Docker
```
docker build --no-cache -t micrometer-demo -f Dockerfile .
```

# Deploy Local

Docker Swarm
```
docker swarm init
docker stack deploy -c docker-compose.yaml demo
```
