import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class CustomerWindow {
    public static User customer;

    public void login(User customer) {
        this.customer = customer;
    }

    public void display() {
        System.out.println("Showing Customer Window for Customer " + customer.getId());
        Stage window = new Stage();
        window.setTitle("Customer Window");

        Label label1 = new Label();
        label1.setText("Welcome Valued Customer");

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

        Button checkout = new Button("Check Out");
        checkout.setOnAction(e -> {

        });




        Button logOutButton = new Button("Log out");
        logOutButton.setOnAction(e -> {
            System.out.println("Logged out, going back to Log In");
            window.close();
            LogInHandler.display();

        });


        VBox vLayout = new VBox(10);
        vLayout.getChildren().addAll(label1, productDetails, addProductID, viewShoppingCart, checkout, logOutButton);
        vLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vLayout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
