# total-recipe-service

## Requirements
- Java
- Docker

## How To Run:
1 Get Mongo Docker container running:
  * Linux/Mac
```bash
sudo docker run --name mongocontainer -p 27017:27017 mongo
```

  * Windows

```bash
docker run --name mongocontainer -p 27017:27017 mongo
```

2 Get Spring Boot running(project root folder):
  * Linux/Mac/Windows with gradle installed
```bash
    gradle bootRun
```
  * Linux/Mac without gradle installed
```bash
    ./gradlew bootRun
```
  * Windows without gradle installed
```bash
    gradlew.bat bootRun    
```
3 *Optional* Run load script to insert initial data
  - Linux/Mac
```bash
./loadData.sh
```
  - Windows
```bash
loadData.bat
```
4 Go to [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


