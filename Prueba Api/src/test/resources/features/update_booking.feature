#language: es
Característica: El usuario requiere actualizar una reserva

  Escenario: El usuario crea  reservas para la api
    Dado que establece el url base del api
      | https://restful-booker.herokuapp.com |
    Y obtiene el token de acceso con los datos necesarios
      | username | admin       |
      | password | password123 |
    Cuando el usuario actualiza los datos de la reserva "3"
      | firstname       | Stephany   |
      | lastname        | Otalvaro   |
      | totalprice      | 666        |
      | depositpaid     | true       |
      | checkin         | 2022-04-01 |
      | checkout        | 2022-04-05 |
      | additionalneeds | Breakfast  |
    Entonces el usuario valida la respuesta del servicio "200"
    Y se valida que la reserva se cree correctamente

