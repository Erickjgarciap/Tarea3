# Tarea3

Esta tarea en realizar un microservicio que regresara un numero aleatorio consumido por otro microservicios, 
a cotinuacion se listan los proyectos involucrados de la practica 23.

  - Age-Microservice
  - Random-Microservice
  
  # Compilar el proyecto!
  
  Para compilar el proyecto es necesario tener los otros proyectos de la practica 23 ya iniciados.
  
  # Compilar el proyecto Users microservice!
  - Descargar el proyecto 23-Users-microservice en una ruta especifica, para compilarlo se realiza de la siguiente 
  manera:
  
  ```sh
$ cd /ruta/23-Users-microservice/
$ mvn clean package -DskipTests
```
- El proyecto se ejecuta asi, siempre en la misma ruta donde lo compilaste antes
```sh
$ java -jar target/23-Users-microservice-0.0.1-SNAPSHOT.jar
```
  # Compilar el proyecto Uppercase microservice!
  - Descargar el proyecto 23-Uppercase-microservice en una ruta especifica, para compilarlo se realiza de la siguiente 
  manera:
  
  ```sh
$ cd /ruta/23-Uppercase-microservice/
$ mvn clean package -DskipTests
```
- El proyecto se ejecuta asi, siempre en la misma ruta donde lo compilaste antes
```sh
$ java -jar target/23-Uppercase-microservice-0.0.1-SNAPSHOT.jar
```
 
# Compilar el proyecto random microservice!
  - Descargar el proyecto 23-Random-microservice en una ruta especifica, para para compilarlo se realiza de la siguiente 
  manera:
  
  ```sh
$ cd /ruta/23-Random-Microservice/
$ mvn clean package -DskipTests
```
- El proyecto se ejecuta asi, siempre en la misma ruta donde lo compilaste antes
```sh
$ java -jar target/23-Random-Microservice-0.0.1-SNAPSHOT.jar
```
Al final se levantara un servidor que se indicara en la terminal o en el ide, donde sea se mostrara lo siguiente:

![alt text](https://github.com/Erickjgarciap/Tarea3/blob/master/inicioradommicroservice.png)

# Compilar el proyecto Age microservice!

 - Descargar el proyecto 23-Age-Microservice en una ruta especifica, para para compilarlo se realiza de la siguiente 
  manera:
  
  ```sh
$ cd /ruta/23-Age-Microservice/
$ mvn clean package -DskipTests
```

Una vez compilado el proyecto es necesario levantar los perfiles local,ribbon-api y load-balanced-rest-template.

- Perfil local

 ```sh
$ cd /ruta/23-Age-Microservice/
$ java -jar target/23-Age-Microservice-0.0.1-SNAPSHOT.jar
```
![alt text](https://github.com/Erickjgarciap/Tarea3/blob/master/Inicioagelocal.png)

-Perfil ribbon-api

 ```sh
$ cd /ruta/23-Age-Microservice/
$ java -jar target/23-Age-Microservice-0.0.1-SNAPSHOT.jar --spring.profiles.active=ribbon-api
```
![alt text](https://github.com/Erickjgarciap/Tarea3/blob/master/ageribonapi.png)

-Perfil load-balanced-rest-template
 ```sh
$ cd /ruta/23-Age-Microservice/
$ java -jar target/23-Age-Microservice-0.0.1-SNAPSHOT.jar --spring.profiles.active=load-balanced-rest-template
```
![alt text](https://github.com/Erickjgarciap/Tarea3/blob/master/agebalanced.png)

Al final en la pantalla del Servidor de Eureka deberan verse los microservicios andando.

![alt text](https://github.com/Erickjgarciap/Tarea3/blob/master/eurekapantalla.png)



# Probando el desarrollo

- Para probar el desarrollo es importante tener todos los microservicios arriba.
- Hacerle una peticiön al microservicios de user http://localhost:9099/users-service/{nombre}

Este microservicio devolverá un nombre en mayüsculas(El que se le mando en la url de arriba) y una edad random.


Ahora observamos las respuestas de cada perfil cuando se levantö el Age-Microservice.

- Load Balanced RestTemplate

  ![alt text](https://github.com/Erickjgarciap/Tarea3/blob/master/loadbalancedresponse.png)

- Ribbon Appi

  ![alt text](https://github.com/Erickjgarciap/Tarea3/blob/master/ribbonapiresponse.png)

- Local

  ![alt text](https://github.com/Erickjgarciap/Tarea3/blob/master/localrandomage.png)

Aqui observamos la respuesta de cada perfil que se configuro en el proyecto Age-Microservice con la anotacion @Profile


# Adicional 

Como funcionaliad Adicional se tenia que componer el envio de la letra "ñ"

![alt text](https://github.com/Erickjgarciap/Tarea3/blob/master/letraene.png)


