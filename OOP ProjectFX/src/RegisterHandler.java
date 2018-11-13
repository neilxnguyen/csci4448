import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class RegisterHandler {
    public static void display() {
        Stage window = new Stage();
        window.setTitle("Register New User");

        Label label1 = new Label();
        label1.setText("Please enter customer information");

        int usersSize = Users.users.size() - 3 + 1;
        System.out.println(usersSize);

        TextField number = new TextField();
        number.setPromptText("Enter Number as 1234567890");

        TextField firstName = new TextField();
        firstName.setPromptText("Enter Customer First Name");

        TextField lastName = new TextField();
        lastName.setPromptText("Enter Customer Last Name");

        Button okButton = new Button("OK");
        okButton.setOnAction(e -> {
            User newUser = new User(usersSize, 0, number.getText());
            Users.users.add(newUser);
            System.out.println(Users.users);
            window.close();
        });

        VBox vLayout = new VBox(10);
        vLayout.getChildren().addAll(label1, number, firstName, lastName, okButton);
        vLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vLayout, 300, 250);
        window.setScene(scene);
        window.show();

    }
}
