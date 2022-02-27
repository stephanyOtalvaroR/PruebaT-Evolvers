package demoblaze.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class AddCart {

    public static final  Target PRODUCT = Target.the("product").
            locatedBy("//*/a [text()='{0}']");
    public static final  Target CATEGORIES = Target.the("categories").
            locatedBy("//*/a [text()='{0}']");
    public  static  final  Target ADDCART = Target.the("Add to cart").
            locatedBy("//a[@class=\"btn btn-success btn-lg\"]");
    public  static  final  Target HOME = Target.the("").
            locatedBy("(//*/a[@class=\"nav-link\"])[1]");
    public  static  final  Target CART = Target.the("Cart")
            .located(By.id("cartur"));
    public  static  final  Target TOTAL = Target.the("Total")
            .located(By.id("totalp"));

}
