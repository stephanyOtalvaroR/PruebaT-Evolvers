package demoblaze.tasks;


import demoblaze.interactions.Wait;
import demoblaze.models.CategoryName;
import demoblaze.models.ProductName;
import demoblaze.userinterface.AddCart;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AddToCart implements Task {

    ProductName productCart = new ProductName();

    CategoryName categories = new CategoryName();

    @Override
    public <T extends Actor> void performAs(T actor) {
        int j = 0;
        for (int i = 0; i < categories.getCategory().size(); i++) {
            actor.attemptsTo(Click.on(AddCart.CATEGORIES.of(categories.getCategory().get(i))));
            for (int k = 0; k < 1; k++) {
                //agregar producto 1

                actor.attemptsTo(
                        Click.on(AddCart.PRODUCT.of(productCart.getName().get(j))),
                        Click.on(AddCart.ADDCART));
                Wait.theSeconds(3);
                BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
                actor.attemptsTo(Click.on(AddCart.HOME));

                //agregar producto 2
                actor.attemptsTo(Click.on(AddCart.CATEGORIES.of(categories.getCategory().get(i))));
                actor.attemptsTo(
                        Click.on(AddCart.PRODUCT.of(productCart.getName().get(j + 1))),
                        Click.on(AddCart.ADDCART));
                Wait.theSeconds(3);
                BrowseTheWeb.as(actor).getDriver().switchTo().alert().accept();
                actor.attemptsTo(Click.on(AddCart.HOME));

                j = j + 2;
            }
        }
        actor.attemptsTo(Click.on(AddCart.CART));

    }

    public static AddToCart AddToShopingCart() {
        return instrumented(AddToCart.class);
    }
}
