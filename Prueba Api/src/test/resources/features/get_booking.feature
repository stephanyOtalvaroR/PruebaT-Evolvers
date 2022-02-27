#language: es
Característica: El usuario da a obtener los datos
  de una reserva especifica

  Escenario: El usuario da a obtener los datos de una reserva especifica
    Dado  que Establece el url base del api
      | https://restful-booker.herokuapp.com |
    Cuando el usuario busca una reserva con el id "1"
    Entonces el usuario valida la respuesta del servicio "200"

