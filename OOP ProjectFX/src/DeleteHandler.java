import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class DeleteHandler {
    public static void display() {
        Stage window = new Stage();
        window.setTitle("Delete Handler");

        Label label1 = new Label();
        label1.setText("Type in User ID number to remove");

        TextField idField = new TextField();
        idField.setPromptText("ID");

        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            if(idField.getText() != null) {
                Users.removeUser(idField.getText());
            }
        });

        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> {
            window.close();
        });

        VBox vLayout = new VBox(10);
        vLayout.setAlignment(Pos.CENTER);
        vLayout.getChildren().addAll(label1, idField, deleteButton, closeButton);
        Scene scene = new Scene(vLayout, 400, 300);
        window.setScene(scene);
        window.show();
    }
}
