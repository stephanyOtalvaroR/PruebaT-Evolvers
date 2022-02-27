package demoblaze.models;

import java.util.ArrayList;
import java.util.List;

public class ProductName {

    public List<String> getName() {
        return name;
    }

    public ProductName() {
        this.name = new ArrayList<>();
        name.add("Samsung galaxy s6");
        name.add("Iphone 6 32gb");
        name.add("Sony vaio i5");
        name.add("MacBook air");
        name.add("Apple monitor 24");
        name.add("ASUS Full HD");

    }

    private List<String> name;

}
