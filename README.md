1. Para realizar la autenticación esta el enpoint de /login, los datos qe se insertan para comensar son DUMMY en la clase DataLoader. por lo tanto el curl que se debe utilizar es el siguiente:

curl  -X POST \
  'localhost:8080/login' \
  --header 'Accept: */*' \
  --header 'User-Agent: Thunder Client (https://www.thunderclient.com)' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "nombre": "Alex Loza",
  "password":"12345"
}'

Este endpoint contiene validaciones extra, las cuales no permiten que el nombre o el password sean null.
####################################################################################################################

2. Una vez estando autenticado, se pueden acceder a alguno de los otros enpoints que estaban dentro de la prueba, por ejemplo:

/ordenes

curl  -X POST \
  'http://localhost:8080/ordenes' \
  --header 'Accept: */*' \
  --header 'User-Agent: Thunder Client (https://www.thunderclient.com)' \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzYSIsInN1YiI6IkFsZXggTG96YSIsImlkIjoxLCJleHAiOjE3NDA1Mzg4MzZ9.hQA-Jmv_NcgRY6UtFXfJYNVkp-kiDH7thdf6JVv90lk' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "nombreSucursal": "CDMX",
  "fecha":"2024-02-17",
  "total": 100.5,
  "productos":[
    {
      "codigo": "18156",
      "descripcion": "Esmeriladora angular",
      "precio":625.00
    },
    {
      "codigo": "17193",
      "descripcion": "Pala redonda",
      "precio":100.50
    }
  ]
}'

En este ejemplo se puede visualizar el header de autorizacion ademas. Este enpoint tambien tiene validaciones sobre los campos que deben ser obligatorios. Una respuesta correcta se ve asi:

{
  "orden_id": 1,
  "fecha": "2024-02-16",
  "total": 100.5,
  "productos": [
    {
      "producto_id": 1,
      "codigo": "18156",
      "descripcion": "Esmeriladora angular",
      "precio": 625.0
    },
    {
      "producto_id": 2,
      "codigo": "17193",
      "descripcion": "Pala redonda",
      "precio": 100.5
    }
  ]
}

con el ID que se genera para esta orden. Dentro del enpoint de ordenes se encuentra metodo get, para obtener informacion sobre los pedidos:

/ordenes/{id}

En caso de no encontrar el pedido, se lanza un error 404:

{
  "mensaje": "Bad Request",
  "detalles": [
    "No se encontro el contenido solicitado, favor de validar el ID"
  ]
}

#########################################################################################################################################

3. Por ultimo se tiene un enpoint para la actualización de los productos, ya sea su nombre, su codigo o su costo:

/productos

curl  -X PUT \
  'http://localhost:8080/productos' \
  --header 'Accept: */*' \
  --header 'User-Agent: Thunder Client (https://www.thunderclient.com)' \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzYSIsInN1YiI6IkFsZXggTG96YSIsImlkIjoxLCJleHAiOjE3NDA1Mzg4MzZ9.hQA-Jmv_NcgRY6UtFXfJYNVkp-kiDH7thdf6JVv90lk' \
  --header 'Content-Type: application/json' \
  --data-raw '  {
      "producto_id": 2,
      "codigo": "17193",
      "descripcion": "Pala Redonda",
      "precio": 99.99
  }'
