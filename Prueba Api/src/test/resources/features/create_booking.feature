#language: es
Característica: El usuario crea una nueva reserva en la API

  Escenario: El usuario crea  reservas para la api
    Dado que establece el url base del api
      | https://restful-booker.herokuapp.com |
    Cuando el usuario crea las nuevas reservas para el api
      | firstname       | Stephany   |
      | lastname        | Otalvaro   |
      | totalprice      | 666        |
      | depositpaid     | true       |
      | checkin         | 2022-04-01 |
      | checkout        | 2022-04-05 |
      | additionalneeds | Breakfast  |
    Entonces el usuario valida la respuesta del servicio "200"
    Y se valida que la reserva se cree correctamente


