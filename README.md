# Bases de datos 2 2022 - Trabajo de Promoción

## Seeding de MongoDB y PostgreSQL desde archivo csv

Al iniciar el container del service app, se realiza el seeding de las dbs, mediante Jobs de [Spring Batch](https://spring.io/projects/spring-batch).
> Por el momento, solamente está implementado el seeding de MongoDB. Queda por implementar un Job que realice el seeding para PostgreSQL.

Para esto, se deberá copiar el archivo `US_Accidents_Dec19.csv` en `./bbdd2PromocionApp/main/resources` antes de buildear la imagen del service app, es decir previo a ejecutar por primera vez:

```bash
docker-compose up
```


## Start the App
We can easily start app with a single command:
```bash
docker-compose up
```

Docker will pull the PostgreSQL, MongoDB and Spring Boot images (if our machine does not have it already).

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