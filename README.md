# Bases de datos 2 2022 - Trabajo de Promoción

## Seeding de MongoDB y PostgreSQL desde archivo csv

1. Descargar el archivo [US_Accidents_Dec19.csv](https://www.dropbox.com/sh/g4fo1woljc6j2kw/AACFN-puWJEGv6OxVuNphWGQa/199387_896000_compressed_US_Accidents_Dec19.csv.zip?file_subpath=%2FUS_Accidents_Dec19.csv)  
2. Copiar el archivo `US_Accidents_Dec19.csv` en `./bbdd2PromocionApp/main/resources` antes de buildear la imagen del service app, es decir previo a ejecutar por primera vez:

    ```bash
    docker-compose up
    ```

3. Puede lanzar uno o más jobs de seeding realizando una solicitud POST a los endpoints:

   - **Seeding de TestModel (MongoDB)**  
   `/seed/mongodb/testModel`

   - **Seeding de TestModel (PostgreSQL)**  
     `/seed/postgresql/testModel`

   - **Seeding de Accident (MongoDB)**  
     `/seed/mongodb/accident`

   - **Seeding de Accident (PostgreSQL)**  
     `/seed/postgresql/accident`

## API - Query endpoints

1. /accidentsNear 
   
    ```
    Returns the accidents within a certain area.  
    Parameters:
    
    longitude: a longitude (for example, '-84.058723')  
    latitude: a latitude (for example, '39.865147')  
    radius: a radius (in km)  
    ```

2. /averageDistance

3. /betweenDates

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
