import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class ViewCart {
    public static User user;

    public static void display(User user) {
        Stage window = new Stage();
        window.setTitle("View Customer Cart");
//        Product testitem = new Product("5","Test", 4.50);
//        user.addShoppingCart(testitem);

        ObservableList<String> shoppingCartItems =
                FXCollections.observableArrayList(user.shoppingCart.stream()
                        .map(Product::getName)
                        .collect(Collectors.toList())
                );

        ListView<String> lv = new ListView<>(shoppingCartItems);

        Double totalPrice = 0.00;

        for (Product product : user.shoppingCart) {
            totalPrice += product.getDiscountedPrice();
        }

        Label total = new Label("Shopping Cart Total: " + totalPrice);

        HBox listLayer = new HBox(10);
        listLayer.getChildren().addAll(lv);

        VBox vLayout = new VBox(10);
        vLayout.getChildren().addAll(listLayer, total);

        Scene scene = new Scene(vLayout);
        window.setScene(scene);
        window.show();
    }
}
