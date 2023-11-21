# How to deploy the *server* part
(Linux only currently)
## Prequisites

- Make sure you have the [Docker Engine](https://docs.docker.com/engine/install/) installed as well as [Docker Compose Plugin](https://docs.docker.com/compose/install/)

- Obviously, [JRE](https://www.java.com/en/) needs to be installed to run the `.jar`


## Deployment steps

### 1. Set up PostgreSQL
1. To make sure the docker engine is running:

```sh
docker info
```

Output should be as follows:
```sh
Client:
 Version:    24.0.7
 Context:    default
 Debug Mode: false
 Plugins:
  compose: Docker Compose (Docker Inc.)
    Version:  v2.23.0
    Path:     /home/user/.docker/cli-plugins/docker-compose
```

Otherwise, run:
```sh
docker -d
```

2. Go to [`./database`](./database/) directory 
3. Run `docker compose up`

### 2. Get the server *.jar*

At this point you have 2 options:
- Pick a server version from the [_releases_](https://github.com/Qwewewewew/tlocket/releases) page 
- Use [_Gradle_](https://gradle.org/):<br>

1. Go to [`./server`](./server/) directory
2. Run the `build` task:
```sh
./gradlew build
```
3. Then run the following to launch the server jar:
```sh
java -jar tlocket-0.0.1-SNAPSHOT.jar
```
#### OR

<!-- salkja hfkzjjnchoaiuwhmfxpaiuosdhf oaiuhaoisiudhpfamo sdhaposhdf paosdhpfaoisn pfcoaiinsdhfj haspdofn aspd ofhvansdjkfchanlskdjfahsldufaoieuchaskdhfdlfjadshlfkajbsdlfkbasldifhaldkjfhl sorry i had a bit of a mental breakdown -->

1. Go to [`./server`](./server/) directory
2. Run the _`bootRun` gradle task_ to start the application:
```sh
./gradlew bootRun
```
### 3. You're done! The application should be all up and running! :)