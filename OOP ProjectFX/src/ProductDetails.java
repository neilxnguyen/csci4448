import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductDetails {
    public static void display() {
        Stage window  = new Stage();
        window.setTitle("Product Details");

        Label label1 = new Label("Enter Product ID");

        TextField productIdField = new TextField();
        productIdField.setPromptText("Product ID");

        Button okButton = new Button("OK");
        okButton.setOnAction(e -> {
            System.out.println(productIdField.getText());
            Product currentProduct = Products.selectProduct(productIdField.getText());
//            System.out.println(currentProduct);
            if(currentProduct != null) {
                window.close();
                ProductDetailsSecondary.display(currentProduct);
            }
            else {
                System.out.println("Invalid Product ID");
                productIdField.setText("Invalid ID");
            }
        });
        okButton.setDefaultButton(true);

        VBox vLayout = new VBox(10);
        vLayout.getChildren().addAll(label1, productIdField,okButton);
        vLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vLayout);
        window.setScene(scene);
        window.show();
    }
}
