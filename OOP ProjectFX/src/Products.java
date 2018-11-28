import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Products {
    public static List<Product> products;


    public static void initializeProducts() throws ClassNotFoundException, IOException {
        products = new ArrayList<>();
        boolean fileExists = new File("products.tmp").isFile();
        if(fileExists) {
            System.out.println("Product list file found, loading into memory...");
            Products.read();
        }
        else {
            System.out.println("Products list file not found, rebuilding...");
            Products.createDefaultProducts();
            Products.save();
            System.out.println("Default Products list created and saved.");
        }
    }

    public static void save() throws IOException {
        FileOutputStream fos = new FileOutputStream("products.tmp");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(products);
        oos.close();
        System.out.println("Products saved.");
    }

    public static void read() throws ClassNotFoundException, IOException {
        FileInputStream fis = new FileInputStream("products.tmp");
        ObjectInputStream ois = new ObjectInputStream(fis);
        products = (List<Product>) ois.readObject();
        ois.close();
    }

    public static void createDefaultProducts() {
        products = new ArrayList<Product>();

        Product peanuts = new Product("1", "Peanuts", 3.00);
        Product bread = new Product("2", "Bread", 1.00);
        Product eggs = new Product("3", "Eggs", 2.00);
        Product milk = new Product( "4", "Milk", 1.50);

        products.add(peanuts);
        products.add(bread);
        products.add(eggs);
        products.add(milk);


    }

    public static Product selectProduct(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }


}
