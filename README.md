# Bases de datos 2 2022 - Trabajo de Promoción

## Seeding de MongoDB y PostgreSQL desde archivo csv

Para esto, se deberá copiar el archivo `US_Accidents_Dec19.csv` en `./bbdd2PromocionApp/main/resources` antes de buildear la imagen del service app, es decir previo a ejecutar por primera vez:

Puede lanzarse un job de seeding con una solicitud POST a los endpoints:

/seed/mongodb/testModel

/seed/mongodb/accident

/seed/postgresql/testModel

```bash
docker-compose up
```

## API

/accidentsNear  
Returns the accidents within a certain area.  
Parameters:

longitude: a longitude (for example, '-84.058723')  
latitude: a latitude (for example, '39.865147')  
radius: a radius (in km)  


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