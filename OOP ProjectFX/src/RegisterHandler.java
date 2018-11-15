import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class RegisterHandler {
    public static void display(User user) {
        Stage window = new Stage();
        window.setTitle("Register New User");

        Label label1 = new Label();
        label1.setText("Please enter customer information");

        int usersSize = Users.users.size() - 3 + 1;
        System.out.println(usersSize);

        Label label2 = new Label();
        label2.setText("Enter phone number");

        TextField number = new TextField();
        number.setPromptText("Enter Number as 1234567890");

        Label label3 = new Label();
        label3.setText("First Name");

        TextField firstName = new TextField();
        firstName.setPromptText("Enter Customer First Name");

        Label label4 = new Label();
        label4.setText("Last Name");

        TextField lastName = new TextField();
        lastName.setPromptText("Enter Customer Last Name");

        Button customerRegisterButton = new Button("Register new customer");
        customerRegisterButton.setOnAction(e -> {
            User newUser = new User(usersSize, 0, number.getText());
            Users.users.add(newUser);
            System.out.println(Users.users);
            window.close();
        });

        VBox vLayout = new VBox(10);
        vLayout.setAlignment(Pos.CENTER);
//        vLayout.getChildren().addAll(label1, label2, number, label3, firstName, label4, lastName, customerRegisterButton);
        Scene scene = null;
        if(user != null) {
            scene = new Scene(vLayout, 400, 400);
            System.out.println("Welcome Admin");
            Button registerAdminButton = new Button("Register new admin.");
            registerAdminButton.setOnAction(e -> {
                User newAdmin = new User(usersSize, 1, number.getText());
                Users.users.add(newAdmin);
                System.out.println(Users.users);
                window.close();
            });

            vLayout.getChildren().addAll(label1, label2, number, label3, firstName, label4, lastName, customerRegisterButton, registerAdminButton);
        }
        else {
            scene = new Scene(vLayout, 400, 300);
            vLayout.getChildren().addAll(label1, label2, number, label3, firstName, label4, lastName, customerRegisterButton);
        }

        window.setScene(scene);
        window.show();

    }
}
