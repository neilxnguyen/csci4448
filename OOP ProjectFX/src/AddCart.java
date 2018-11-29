import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.util.List;
import java.util.stream.Collectors;

public class AddCart {
    public static void display(User user) {
        Stage window = new Stage();
        window.setTitle("Add Item to Cart by Product ID");

        Label label1 = new Label("Please enter the ID of the product");
        Label label2 = new Label("to be added to the cart");
        TextField productIDField = new TextField();
        productIDField.setPromptText("Product ID");

        Button okButton = new Button("OK");
        okButton.setOnAction(e -> {
            System.out.println(productIDField.getText());
            for (Product product : Products.products) {
                if (product.getId().equals(productIDField.getText())) {
                    System.out.println("Product added");
                    user.addShoppingCart(product);
                    productIDField.clear();
                }

            }
        });
        okButton.setDefaultButton(true);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {
            window.close();
        });

        VBox vLayout = new VBox(10);
        vLayout.setAlignment(Pos.CENTER);
        vLayout.getChildren().addAll(label1, label2, productIDField, okButton, closeButton);
        Scene scene = new Scene(vLayout);
        window.setScene(scene);
        window.show();
    }
}
