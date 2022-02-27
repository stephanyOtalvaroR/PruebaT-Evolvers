package tevolvers.demoblaze.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/product_store.feature",
        glue="tevolvers.demoblaze.stepdefinitions",
        snippets = SnippetType.CAMELCASE)

public class ProductStore {
}