import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class ProductDetailsSecondary {
    public static void display(Product product) {
        DecimalFormat df  = new DecimalFormat("0.00");
        Stage window = new Stage();
        window.setTitle("Product " + product.getId());

        Label name = new Label("Name: " + product.getName());
        Label id = new Label("ID: " + product.getId());
        String priceString = df.format(product.getPrice());
//        String priceString = Double.toString(product.getPrice());
        Label price = new Label("Price: $" + priceString);
        Label description = new Label("Description: " + product.getDescription());
        Label stock = new Label("Stock: " + Integer.toString(product.getStock()));
        String discountString = Double.toString(product.getDiscount());
        Label discount = new Label("Discount: " + discountString + "%");
        String discountedPriceString = df.format(product.getDiscountedPrice());
        Label finalPrice = new Label("Final Price: " + discountedPriceString);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {
            window.close();
        });
        closeButton.setDefaultButton(true);

        VBox vLayout = new VBox(10);
        vLayout.getChildren().addAll(name, id, description, stock, price, discount, finalPrice);
        vLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vLayout);
        window.setScene(scene);
        window.show();


    }
}
