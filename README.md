# tipti-kardex-api
API REST desarrollada en Spring Boot con base de datos H2 para manejo de Inventario

Se configuro la API con autentificacion basica (Basic Auth) Http, cuyo usuario autorizado: admin y contraseña password se encuentra configurado en la clase com.tipti.kardex.api.SecurityConfiguration

Existen varios ENDPOINTS para administrar las entidades, estos fueron generados automaticamente gracias a Spring Rest Repositories, métodos disponibles GET, POST, PUT, DELETE:
- Ciudad: 
    http://localhost:8080/api/ciudades
- Producto:
    http://localhost:8080/api/productos
- Tienda:
    http://localhost:8080/api/tiendas

En cambio debido a la clave compuesta que maneja la entidad StockEntienda, se creo un Controller propio para exponer esta funcionalidad en la API StockEntienda:
Ejemplos:
- Listar todos: GET: http://localhost:8080/api/stockentienda/
- Para obtener un registro: GET http://localhost:8080/api/stockentienda/prod/1/tienda/1/sku/001-052365
- Para borrar un registro:  DELETE http://localhost:8080/api/stockentienda/prod/1/tienda/1/sku/001-052365
- Para crear un registro: POST http://localhost:8080/api/stockentienda/nuevo

Body JSON:
{"producto":        {"id":1,"nombre":"Mouse","presentacion":null,"marca":null,"fabricante":null,"foto":null,"ventaAlGranel":10.99,"descripcion":null,"nivelAzucar":null,"nivelSal":null,"nivelGrasa":null,"estado":null},"tienda":{"id":1,"ciudad":{"id":1,"nombre":"Quito"},"nombre":"Sucursal 1","logo":null},"categoria":{"id":1,"nombre":"Equipos de computación","icono":"","descripcion":""},"pvp":11.99,"margenGanancia":3.00,"precioCompra":7.99,"tieneIva":null,"estado":null,"sku":"001-054375"}

- Para editar un registro: PUT http://localhost:8080/api/stockentienda/prod/1/tienda/1/sku/001-052365

Body JSON:
{"producto":{"id":1,"nombre":"Mouse","presentacion":null,"marca":"Genius","fabricante":"Genius","foto":"foto1.jpg","ventaAlGranel":10.99,"descripcion":null,"nivelAzucar":0.0,"nivelSal":0.0,"nivelGrasa":0.0,"estado":true},"tienda":{"id":1,"ciudad":{"id":1,"nombre":"Quito"},"nombre":"Sucursal 1","logo":"logo.jpg"},"categoria":{"id":1,"nombre":"Equipos de computación","icono":"","descripcion":"Equipos"},"pvp":11.99,"margenGanancia":3.00,"precioCompra":7.99,"tieneIva":true,"estado":true,"sku":"001-054375"}

## Heroku Deploy
Para facilitar las pruebas se ha procedido hacer un deploy automático desde este repositorio en **GitHub** hacia la plataforma **Heroku**, se puede acceder a la API a través del siguiente link:
 - https://tipti-kardex-api.herokuapp.com/api/
