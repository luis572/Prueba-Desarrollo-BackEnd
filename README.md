
# Prueba-Desarrollo-BackEnd

## Prerrequisitos
Se debe tener instalados los siguientes programas en nuestro sistema operativo: 

- Maven 
- Git
- Java
- Docker

## Empezando
se debe de clonar el proyecto, para esto utilizaremos el comando git clone. ubíquese la carpeta a guardar el proyecto y escriba el siguiente comando en la terminal:
 
### git clone https://github.com/luis572/Prueba-Desarrollo-BackEnd
   
## Instalacion 
- Ejecutar el comando mvn package
- Ejecutando pruebas: mvn test 
## Servicios: 
### Cliente[R]: 
-	POST */cliente/register* : Se encarga de registrar a un cliente en la base de datos. 
-	*POST /cliente/login*:  Se encarga de autenticar a un cliente, generara un token de acceso a los servicios. 
### Venta [RC]: 
Token de acceso necesario para estos servicios.
- *POST /api/venta/* : Se encargara de registrar una venta en la base de datos.
- GET */api/venta/idventa/{idventa}* : Consultara una venta segun su id.
- GET */api/venta/detalles/{idventa}* : Lista de detalles de una venta, Consulta RXJava.
### Producto[G]:
- POST */producto* : Se encargara de registrar un producto en la base de datos.
- PUT */producto* : Actualizar un producto.
- GET */producto/idproducto/{idproducto}* : Consulta un producto por id.
- DELETE */producto/idproducto/{idproducto}*: Eliminar un producto por id.

##  Corriendo Pruebas: 
### Pruebas manuales: 

### Pruebas unitarias: 


## Mejoras Seguridad y optimización: 
- Manejar un rol para administrador, para que este sea el único encargado de crear, actualizar y eliminar los productos. 

- Cifrar la contraseña del cliente y administrador. Esto fue implementado, se cifra la contraseña antes de guardar el cliente en la base de datos.  

- No permitir que un cliente pueda consultar las ventas de los demás clientes. Simplemente las realizadas por el. 

- No guardar directamente los objetos como llegan en la base de datos. Crear instancias de los objetos y realizar los sets necesarios. Esto evitara una inyección  de código a futuro.  

- Para optimizar el carrito de compras implementaría una base de datos no relacional para aumentar el rendimiento al momento de realizar consultas y para que sea mas practica la administración de misma. 

- Desplegaría la aplicación en la nube, tales como los servicios Ec2 de Amazon o las maquinas virtuales de Azure, implementando balanceadores de carga.  esto con el propósito de que en casos de un pico de actividad se pueda realizar un escalamiento horizontal o vertical según sea el caso. 
