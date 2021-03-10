# Operacion fuego quasar

Operacion fuego quasar

Como jefe de comunicaciones rebelde, tu misión es crear un programa en Golang que retorne la fuente y contenido del mensaje de auxilio. Para esto, cuentas con tres satélites que te permitirán triangular la posición, ¡pero cuidado! el mensaje puede no llegar completo a cada satélite debido al campo de asteroides frente a la nave.

Posición de los satélites actualmente en servicio
- Kenobi: [-500, -200]
- Skywalker: [100, -100]
- Sato: [500, 100]

 [mas informacion](https://github.com/YohannaToro/quasar-operation/files/6112994/Operacion.Fuego.de.Quasar.1.pdf)
> #### Tecnologias
>
> - Framework - Spring boot
> - Java 1.8
> - Maven
> - MongoD
> - AWS
>  

## Arquitectura
![Captura55](https://user-images.githubusercontent.com/37119524/110572533-99dc6e80-8127-11eb-85a1-69a510f88a46.png)

#Despliegue en AWS
![Captura55](https://user-images.githubusercontent.com/37119524/110573173-ccd33200-8128-11eb-9633-86263d3350cd.png)

Para el despliegue en aws 
-Se crea un bucket s3 para tener el objeto jar del api
-se creo una instancia EC2 en esta se creo la base de datos y se ejecuta el jar de la aplicacion

http://ec2-52-23-226-80.compute-1.amazonaws.com:8080/



[Download Postman Collection](https://github.com/YohannaToro/quasar-operation/files/6113013/quasar-operation.postman_collection.json.zip)


