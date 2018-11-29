import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class CustomerWindow {
    public static User customer;
    public static Momento momento;

    public void login(User customer) {
        this.customer = customer;
    }

    public static void display() {
//        momento = new Momento(customer.shoppingCart);
        System.out.println("Showing Customer Window for Customer " + customer.getId());
        Stage window = new Stage();
        window.setTitle("Customer Window");

        Label label1 = new Label();
        label1.setText("Welcome Valued Customer");

        Button editCustomerInfo = new Button("Edit Profile");
        editCustomerInfo.setOnAction(e -> {
            //CODE FOR CHANGING USER INFO
        });

        Button productDetails = new Button("Product Look-up");
        productDetails.setOnAction(e -> {
            ProductDetails.display();
        });

        Button addProductID = new Button("Add item to cart using product ID");
        addProductID.setOnAction(e -> {
            AddCart.display(customer);
        });

        Button viewShoppingCart = new Button("View Shopping Cart");
        viewShoppingCart.setOnAction(e -> {
            try {
                ViewCart.display(customer);
            }
            catch (NullPointerException ex) {
                System.out.println("Shopping Cart is Empty");
            }
        });

        Button saveShoppingCart = new Button("Save Shopping Cart");
        saveShoppingCart.setOnAction(e -> {
            System.out.println(momento.savedCart);
            momento = customer.saveCartToMomento();
            System.out.println(momento.getSavedCart());
        });

        Button loadSavedShoppingCart = new Button("Load Saved Shopping Cart");
        loadSavedShoppingCart.setOnAction(e -> {
            System.out.println(momento.savedCart);
            customer.getSavedCartFromMomento(momento);
        });

        Button checkout = new Button("Check Out");
        checkout.setOnAction(e -> {
            //CODE TO CHECK OUT, CLEAR SHOPPING CART
        });




        Button logOutButton = new Button("Log out");
        logOutButton.setOnAction(e -> {
            System.out.println("Logged out, going back to Log In");
            window.close();
            LogInHandler.display();

        });


        VBox vLayout = new VBox(10);
        vLayout.getChildren().addAll(label1, editCustomerInfo, productDetails, addProductID, viewShoppingCart, saveShoppingCart, loadSavedShoppingCart, checkout, logOutButton);
        vLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vLayout);
        window.setScene(scene);
        window.show();
    }
}
