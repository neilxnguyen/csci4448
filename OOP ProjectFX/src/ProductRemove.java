import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductRemove {
    public static void display() {
        Stage window = new Stage();
        window.setTitle("Remove a Product");

        Label label1 = new Label("Please enter the ID of the product");
        TextField idField = new TextField();
        idField.setPromptText("Product ID");

        Button okButton = new Button("OK");
        okButton.setOnAction(e-> {
            System.out.println(idField.getText());
            for (Product product : Products.products) {
                if(product.getId().equals(idField.getText())) {
                    Products.products.remove(product);
                    System.out.println("Product successfully removed");
                    break;
                }
            }
        });


        VBox vLayout = new VBox(10);
        vLayout.getChildren().addAll(label1,idField,okButton);
        Scene scene = new Scene(vLayout);
        window.setScene(scene);
        window.show();
    }
}
