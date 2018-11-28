import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.xml.soap.Text;

public class ProductNew {
    public static void display() {
        Stage window = new Stage();
        window.setTitle("Add New Stage");

        Label label1 = new Label("New Product ID");
        TextField idField = new TextField();
        idField.setPromptText("Product ID");

        Label label2 = new Label("Name");
        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        Label label3 = new Label("Price");
        TextField priceField = new TextField();
        priceField.setPromptText("Price");

        Button okButton = new Button("OK");
        okButton.setOnAction(e -> {
            try {
                for (Product product: Products.products) {
                    if (product.getId().equals(idField.getText())) {
                        System.out.println("Product with that ID already exists.");
                        idField.clear();
                        return;
                    }
                }
                Product product = new Product(idField.getText(), nameField.getText(), Double.parseDouble(priceField.getText()));
                Products.products.add(product);
                System.out.println("Successfully Added New Item: " + idField.getText() + " " + nameField.getText() + " " + priceField.getText());
                idField.clear();
                nameField.clear();
                priceField.clear();
            }
            catch (NullPointerException ex) {
                System.out.println("Error");
            }
        });

        VBox vLayout = new VBox(10);
        vLayout.getChildren().addAll(label1, idField, label2, nameField, label3, priceField, okButton);

        Scene scene = new Scene(vLayout);
        window.setScene(scene);
        window.show();



    }
}
