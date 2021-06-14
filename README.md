## Examen Junio Programación 2021


### ¿Porque DAO?
El patrón DAO se utiliza para separar las operaciones o la API de acceso 
a datos de bajo nivel de los servicios de alto nivel.


### IMAGEN EN DOCKERHUB:
https://hub.docker.com/r/charlos16v/quarkusapp

### CREAR IMAGEN, SUBIRLA A DOCKERHUB Y EJECUTARLA
#### JAR
```bash
./mvnw clean package -DskipTests=true

docker build -f src/main/docker/Dockerfile.jvm -t charlos16v/quarkusapp .

docker push charlos16v/quarkusapp

docker run -d --name {contenedor} -p 8080:8080 charlos16v/quarkusapp
```
#### NATIVA (H2 database compiled into a native-image is only functional as a client)
```bash
./mvnw package -Pnative -Dquarkus.native.container-build=true -Dquarkus.container-image.build=true

docker push charlos16v/quarkusappnative

docker run -d --name {contenedor} -p 8080:8080 charlos16v/quarkusappnative
```

```bash
            ___
	. -^    `--,
       /# =========`-_
      /# (--===___====\
     /#   .- --.  . --.|
    /##   |  * ) (   * ),
    |###  \    /\ \    /|
    |###   ----  \  --- |
    |####      ___)    #|
     \####            ##|
      \### ----------  /
       \###           (
        '\###         |
          \##         |
           \###.    .)
            '======/
       
       SHOW ME WHAT YOU'VE GOT! 
```
