package demoblaze.questions;

import demoblaze.userinterface.AddCart;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidateCart implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(AddCart.TOTAL).viewedBy(actor).asString();
    }

    public static ValidateCart order(){
        return new ValidateCart();
    }
}
