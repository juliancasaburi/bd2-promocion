# Bases de datos 2 2022 - Trabajo de Promoción

## Start the App
We can easily start app with a single command:
```bash
docker-compose up
```

Docker will pull the MySQL, MongoDB and Spring Boot images (if our machine does not have it already).

The services can be run on the background adding the -d parameter:
```bash
docker-compose up -d
```

## Stop the App
Stopping all the running containers is also simple with a single command:
```bash
docker-compose down
```

If you need to stop and remove all containers, networks, and all images used by any service in <em>docker-compose.yml</em> file, use the command:
```bash
docker-compose down --rmi all
```