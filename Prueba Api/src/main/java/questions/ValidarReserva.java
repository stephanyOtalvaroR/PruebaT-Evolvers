package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarReserva implements Question<Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        int code = SerenityRest.lastResponse().statusCode();
        return code;
    }

    public static ValidarReserva ReservaValidacion() {
        return new ValidarReserva();
    }

}


