package tevolvers.demoblaze.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import demoblaze.questions.ValidateCart;
import demoblaze.tasks.AddToCart;
import demoblaze.utils.MyDriver;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.core.IsEqual;


public class ProductStoreStepDefinitions {
    MyDriver driver;

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("stephany");
        driver = MyDriver.aChromeDriver();
    }


    @Given("^The user accesses the my store website Products$")
    public void theUserAccessesTheMyStoreWebsiteProducts() {
        OnStage.theActorInTheSpotlight().whoCan(BrowseTheWeb.with(driver.inTheWebPage("https://www.demoblaze.com/")));


    }


    @When("^add the required products to the shoping cart$")
    public void addTheRequiredProductsToTheShopingCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddToCart.AddToShopingCart());


    }

    @Then("^the user validates the shopping cart \"([^\"]*)\"$")
    public void theUserValidatesTheShoppingCart(String expectedMessage) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateCart.order(),
                IsEqual.equalTo(expectedMessage)));
    }



}
