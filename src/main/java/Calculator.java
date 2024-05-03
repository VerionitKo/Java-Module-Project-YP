import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Calculator {

    private List<String> items = new ArrayList<>();
    private final int humanCount;
    private double totalPrice;

    public Calculator(int humanCount) {
        this.humanCount = humanCount;
        totalPrice = 0;
    }

    public void addDish(String dish, Double price) {
        this.items.add(dish);
        totalPrice += price;
    }

    public List<String> getItems() {
        return items;
    }

    public double getPriceForPerson() {
        return totalPrice / humanCount;
    }
}
