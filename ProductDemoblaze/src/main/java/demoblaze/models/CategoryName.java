package demoblaze.models;

import java.util.ArrayList;
import java.util.List;

public class CategoryName {

   private List<String> category;

    public List<String> getCategory() {
        return category;
    }

    public CategoryName() {
        this.category = new ArrayList<>();
        category.add("Phones");
        category.add("Laptops");
        category.add("Monitors");
    }
}
