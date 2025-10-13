import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Shop shop = new Shop();
        Scanner sc = new Scanner(System.in);

        // 🛒 Agregamos algunos productos iniciales
        shop.addProduct(new Product("Laptop", 3500, 5));
        shop.addProduct(new Product("Mouse", 50, 20));
        shop.addProduct(new Product("Keyboard", 120, 10));
        shop.addProduct(new Product("Monitor", 800, 7));

        boolean running = true;

        while (running) {
            System.out.println("\n==== SHOP MENU ====");
            System.out.println("1. Ver productos");
            System.out.println("2. Ordenar productos por precio");
            System.out.println("3. Vender producto");
            System.out.println("4. Agregar nuevo producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Ver valor total del inventario");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int option = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            try {
                switch (option) {
                    case 1:
                        System.out.println("\n--- Productos actuales ---");
                        shop.printProducts(shop.getProducts());
                        break;

                    case 2:
                        System.out.print("1 = Mayor a menor | 2 = Menor a mayor: ");
                        int filtro = sc.nextInt();
                        sc.nextLine();
                        List<Product> ordered = shop.orderProductsPrice(filtro);
                        System.out.println("\n--- Productos ordenados ---");
                        shop.printProducts(ordered);
                        break;

                    case 3:
                        System.out.print("Nombre del producto a vender: ");
                        String nameSell = sc.nextLine();
                        shop.sellProduct(nameSell);
                        System.out.println("Producto vendido con éxito.");
                        break;

                    case 4:
                        System.out.print("Nombre del producto: ");
                        String name = sc.nextLine();
                        System.out.print("Precio: ");
                        int price = sc.nextInt();
                        System.out.print("Stock: ");
                        int stock = sc.nextInt();
                        sc.nextLine();
                        shop.addProduct(new Product(name, price, stock));
                        System.out.println("Producto agregado correctamente.");
                        break;

                    case 5:
                        System.out.print("Nombre del producto a eliminar: ");
                        String deleteName = sc.nextLine();
                        shop.deleteProduct(deleteName);
                        System.out.println("🗑️ Producto eliminado.");
                        break;

                    case 6:
                        System.out.println("Valor total del inventario: $" + shop.calculateInventory());
                        break;

                    case 0:
                        running = false;
                        System.out.println("Saliendo de la tienda...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
