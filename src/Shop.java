import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shop {

    private List<Product> products = new ArrayList<>();

    public Shop() {}

    public List<Product> getProducts() {
        return products;
    }

    public int calculateInventory() {
        int total = 0;
        for (Product p : products) {
            total += p.getPrice() * p.getStock();
        }
        return total;
    }

    public void addProduct(Product newProduct) {
        this.products.add(newProduct);
    }

    public Product findProductByName(String name) {
        for (Product p : this.products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        throw new IllegalArgumentException("No product found with name: " + name);
    }

    public void deleteProduct(String name) {
        Product selectedProduct = this.findProductByName(name);
        this.products.remove(selectedProduct);
    }

    public void sellProduct(String name) {
        Product selectedProduct = this.findProductByName(name);
        if (selectedProduct.getStock() > 0) {
            selectedProduct.decreaseStock();
        } else {
            throw new IllegalStateException("No stock available for product: " + name);
        }
    }

    public List<Product> orderProductsPrice(int filtro) {
        List<Product> sortedProducts = new ArrayList<>(this.products);

        if (filtro == 1) {
            // Mayor a menor
            sortedProducts.sort(Comparator.comparingDouble(Product::getPrice).reversed());
        } else if (filtro == 2) {
            // Menor a mayor
            sortedProducts.sort(Comparator.comparingDouble(Product::getPrice));
        } else {
            throw new IllegalArgumentException("Not a valid option. Use 1 (desc) or 2 (asc).");
        }

        return sortedProducts;
    }

    public void printProducts(List<Product> list) {
        for (Product p : list) {
            System.out.println(p);
        }
    }
}
