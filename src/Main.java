import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);
    Shop myShop = new Shop();

    String[] options = {
            "1. Add Product",
            "2. List Products",
            "3. Calculate total inventory",
            "4. Search product by name",
            "17. Exit",
    };

    public static void main(String[] args){
        Main main = new Main();
        main.menu();
    }

    public int welcome(){
        System.out.println("Welcome to my MiniShop");
        for(String option : this.options){
            System.out.println(option);
        }
        System.out.println("Select an option: ");
        return sc.nextInt();
    }

    public void menu(){
        int option;
        do {
            option = welcome();
            switch (option){
                case 1 -> addProduct();
                case 2 -> listProducts();
                case 3 -> calculateTotalInventary();
                case 4 -> findProductByName();
                case 17 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option!");
            }
        } while(option != 17);
    }

    public void addProduct(){
        sc.nextLine();

        System.out.println("Write the product's name:");
        String name = sc.nextLine();

        System.out.println("Set the product's price:");
        int price = sc.nextInt();

        System.out.println("Set the product's stock:");
        int stock = sc.nextInt();

        Product newProduct = new Product(name, price, stock);
        myShop.addProduct(newProduct);

        System.out.println("--------------------------");
        System.out.println("Added product:");
        System.out.println("name: " + newProduct.getName());
        System.out.println("price: " + newProduct.getPrice());
        System.out.println("stock: " + newProduct.getStock());
        System.out.println("--------------------------");
    }

    public void listProducts(){
        if (myShop.getProducts().isEmpty()){
            System.out.println("--------------------------");
            System.out.println("There's no products yet");
            System.out.println("--------------------------");
        } else {
            System.out.println("--------------------------");
            System.out.println("These are your products: ");
            for(Product p : myShop.getProducts()){
                System.out.printf("%s $%d stock: %d%n", p.getName(), p.getPrice(), p.getStock());
            }
            System.out.println("--------------------------");
        }
    }

    public void calculateTotalInventary(){
        System.out.println("--------------------------");
        System.out.println("Total = $" + myShop.calculateInventary());
        System.out.println("--------------------------");
    }

    public void findProductByName(){
        sc.nextLine();
        System.out.println("--------------------------");
        System.out.println("Write the name of the product you want:");
        String name = sc.nextLine();
        Product productFound = myShop.findProductByName(name);
        System.out.printf("%s $%d stock: %d%n", productFound.getName(), productFound.getPrice(), productFound.getStock());
        System.out.println("--------------------------");
    }
}
