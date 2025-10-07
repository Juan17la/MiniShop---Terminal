import java.util.ArrayList;
import java.util.List;

public class Shop {

    List<Product> products = new ArrayList<>();

    public Shop(){}

    public List<Product> getProducts() {
        return products;
    }

    public int calculateInventary() {
        int total = 0;
        for(Product p : products){
            total += p.getPrice() * p.getStock();
        }
        return total;
    }

    public void addProduct(Product newProduct){
        this.products.add(newProduct);
    }

    public Product findProductByName(String name) {
        for (Product p : this.products) {
            if (p.getName().equalsIgnoreCase(name)) { // ignoreCase opcional
                return p;
            }
        }
        throw new IllegalArgumentException("No product found with name: " + name);
    }
}
