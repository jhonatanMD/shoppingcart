
### _Proyecto de Carrito de Compras_


## Pre-Requisitos


* Java 11 (Instalado y Configurado)
* Docker (Instalado y Configurado)

* IDE para compilar proyectos Java (Instalado y Configurado en este caso use STS)

* Maven para repositorio de dependencias (Instalado y Configurado)

## Instalación

_Copiar lo siguiente y en una terminar git ejecutar el siguiente comando_

```
git clone https://github.com/jhonatanMD/shoppingcart.git
```

_Dirigirse al IDE y importar el archivo_

_Luego ejecutar el siguiente comando en una consola cmd o git en la ruta del proyecto ejemplo C:\shoppingcart/..._

```
mvn clean install
```
_Dirigirse al IDE darle click Izquierdo -> Maven -> Update Project -> Seleccionar Proyecto -> Force Update os Snapshots... -> darle click en OK 
o si estas en cualquier otro IDE actualizar las dependecias del maven para que pueda importarse al proyecto._

## Ejecución

* Dentro del IDE buscar el main que se encuentra en la clase JavaBackEndSoaIntApplication.java darle click derecho y hacer correr programa (Run as Java Application) 

* Para configurar el archivo de salida los log ir a resources/log4j.properties (modificar variable ruta.file.log , la creacion de archivos funciona localmente)

* Para configura puerto , conexion a base de datos o usuario de token ir a resources/application.properties


## Ejecutar Docker

* En el cmd ejecutar los siguientes comandos en la ruta base del proyecto:

 ```
docker build -t "shopping-api" .

docker images (ver si se creo la imagen)

docker network create "spring-cloud"

docker run -p 8089:8089 --name "shopping-api" --network "spring-cloud" "shopping-api"
```

* Despues de Eso ir a postman y consumir la api : http://localhost:8089/api/....

## Documentacion

* Para la documentacion ir a la ruta : http://localhost:8089/v2/api-docs y copiar json
* Copiar Swagger y ir a https://editor.swagger.io/?_ga=2.234123485.2135018105.1605647247-197241662.1605412672 y pegar json
* Se podra ver los endpoint de la api y su funcionalidad
























