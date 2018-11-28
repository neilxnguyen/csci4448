import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.text.DecimalFormat;

public class EditProductDetailsSecondary {
    public static void display(Product product) {
        DecimalFormat df  = new DecimalFormat("0.00");
        Stage window = new Stage();
        window.setTitle("Product " + product.getId());

        // CHANGE NAME
        Label changeName = new Label("Change Product Name");
        TextField newNameField = new TextField();
        newNameField.setPromptText("Current Name: " + product.getName());
        Button nameOK = new Button("OK");
        nameOK.setOnAction(e -> {
            System.out.println(newNameField.getText());
            product.setName(newNameField.getText());
            newNameField.setPromptText("Current Name: " + product.getName());
            newNameField.clear();
        });
        HBox nameLayer = new HBox(10);
        nameLayer.getChildren().addAll(newNameField, nameOK);

        // CHANGE DESCRIPTION
        Label changeDesc = new Label("Change Product Description");
        TextField newDescField = new TextField();
        newDescField.setPromptText("Current Description: " + product.getDescription());
        Button descOK = new Button("OK");
        descOK.setOnAction(e -> {
            System.out.println(newDescField.getText());
            product.setDescription(newDescField.getText());
            newDescField.setPromptText("Current Description: " + product.getDescription());
            newDescField.clear();
        });
        HBox descLayer = new HBox(10);
        descLayer.getChildren().addAll(newDescField, descOK);

        //CHANGE STOCK
        Label changeStock = new Label("Change Product Stock");
        TextField stockField = new TextField();
        stockField.setPromptText("Current Stock: " + Integer.toString(product.getStock()));
        Button stockOK = new Button("OK");
        stockOK.setOnAction(e -> {
            try {
                int stockInt = Integer.parseInt(stockField.getText());
                product.setStock(stockInt);
                stockField.setPromptText("Current Stock: " + Integer.toString(product.getStock()));
                stockField.clear();
            }
            catch (NumberFormatException ex) {
                System.out.println("NOT AN INTEGER, PLEASE ENTER AN INTEGER");
                stockField.setText("Please enter an integer");
            }
        });
        HBox stockLayer = new HBox(10);
        stockLayer.getChildren().addAll(stockField, stockOK);

        // CHANGE PRICE
        Label changePrice = new Label("Change Product Price");
        TextField priceField = new TextField();
        priceField.setPromptText("Current Price: " + df.format(product.getPrice()));
        Button priceOK = new Button("OK");
        priceOK.setOnAction(e -> {
            try {
                double priceDouble = Double.parseDouble(priceField.getText());
                product.setPrice(priceDouble);
                priceField.setPromptText("Current Price: " + df.format(product.getPrice()));
                priceField.clear();
            }
            catch (NumberFormatException ex) {
                System.out.println("NOT A DOUBLE, PLEASE ENTER A DOUBLE");
                priceField.setText("Please enter a valid price");
            }
        });
        HBox priceLayer = new HBox(10);
        priceLayer.getChildren().addAll(priceField, priceOK);

        // CHANGE DISCOUNT
        Label changeDiscount = new Label("Change Product Discount Percentage");
        TextField discountField = new TextField();
        discountField.setPromptText("Current Discount: " + Double.toString(product.getDiscount()));
        Button discountOK = new Button("OK");
        discountOK.setOnAction(e -> {
            try {
                double discountDouble = Double.parseDouble(discountField.getText());
                product.setDiscount(discountDouble);
                discountField.setPromptText("Current Discount: " + Double.toString(product.getDiscount()));
                discountField.clear();
            }
            catch (NumberFormatException ex) {
                System.out.println("NOT A DOUBLE, PLEASE ENTER A DOUBLE");
                discountField.setText("Please enter a valid discount");
            }
        });
        HBox discountLayer = new HBox(10);
        discountLayer.getChildren().addAll(discountField, discountOK);



        VBox vLayout = new VBox(10);
        vLayout.getChildren().addAll(changeName, nameLayer, changeDesc, descLayer, changeStock, stockLayer, changePrice, priceLayer, changeDiscount, discountLayer);
        Scene scene = new Scene(vLayout);

        window.setScene(scene);
        window.show();


    }
}
