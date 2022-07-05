Buenas noches, hago la entrega del tp.

Aca se encuentra la parte del back, no pude desplegarla en heroku. Por otra parte, aca esta el
[LINK AL FRONT](https://github.com/RodrigoOlmedo/FrontLink)

Desde el front (Desplegando con ngServe y entrando por [este link](http://localhost:4200/login)) se pueden ver todos los productos disponibles, entrar a ver el detalle de los mismos, agregar el producto al carrito, abrir el carrito, establecer las cantidades y realizar la compra. 
Una vez hecha la compra, los items se borran del carrito. En caso de no haber stock no va a ser posible sumarlos al carrito(por pantalla). Falta poder eliminar los items del carrito.

Es posible ver que se realizo la orden de compra en esta [direccion](http://localhost:8080/ordenesDeCompra).
No llegue a implementar las promociones. (cupones, descuentos y medio de pago)

Desde el postman es posible modificar los productos

Es posible cerrar e iniciar sesion desde el navbar.

- USUARIOS | CONTRASEÑAS para el login

comp | comp para entrar como comprador

vend | vend para entrar como vendedor


- ACLARACION: Las variables de entorno se configuran desde la IDE, sin embargo, no logre que haciendo eso me reconozca la initData... de ser asi, configurar en el application.properties

- Otros links utiles con postman:

Creacion de producto:

post a: http://localhost:8080/productos body: {"vendedor":"http://localhost:8080/vendedores/2", "nombre":"iphone","descripcion":"un iphone","precio":"300000.00f","image":"https://www.macstation.com.ar/img/productos/small/1675-1111.jpg","stock":"0","stockMinimo":"2"}

Modificacion de producto (idem borrar):

put a: http://localhost:8080/productos/ (7-11) 

(Se ve reflejado en el front)

Si bien a traves de las UI estan limitadas las acciones, no estan implementadas las excepciones.
