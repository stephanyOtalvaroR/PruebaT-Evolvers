package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarCreacion implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        String text = SerenityRest.lastResponse().body().asString();
        return text;
    }

    public static ValidarCreacion ValidarReservaCreacion() {
        return new ValidarCreacion();
    }

}
