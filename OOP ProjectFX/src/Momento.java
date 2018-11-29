import java.util.ArrayList;

public class Momento {
    public static ArrayList<Product> savedCart;

    Momento(ArrayList<Product> cart) {

        savedCart = cart;

    }

    public static ArrayList<Product> getSavedCart() {

        return savedCart;
    }
}
