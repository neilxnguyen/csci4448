import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class LogInHandler {
    public static void display() {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Login Handler");
        Label label1 = new Label();
        label1.setText("This is the Login Handler");
        Label label2 = new Label();
        label2.setText("Please enter a phone or ID number.");

        Button idButton = new Button("ID Number");
        Button phoneButton = new Button("Phone Number");
        Button registerButton = new Button("Register New User");
        Button closeButton = new Button("Close");
        TextField textField = new TextField();
        textField.setPromptText("Enter your id, or phone number");
        User o = null;




        idButton.setOnAction(e -> {
            System.out.println(textField.getText());
            User currentUser = Users.loginID(textField.getText());
            if (currentUser != null) {
                System.out.println("User found");
                if(currentUser.getUserType() == 1) {
                    System.out.println("Moving to Admin Console");
                    AdminConsole adminConsole = new AdminConsole();
                    adminConsole.login(currentUser);
                    adminConsole.display();
                    window.close();
                }
                else {
                    System.out.println("Moving to Customer Window");
                    CustomerWindow customerWindow = new CustomerWindow();
                    customerWindow.login(currentUser);
                    customerWindow.display();
                    window.close();
                }
            }
            else {
                System.out.println("User not found");
            }
        });

        phoneButton.setOnAction(e -> {
            System.out.println(textField.getText());
            User currentUser = Users.loginNumber(textField.getText());
            if (currentUser != null) {
                System.out.println("User found");
                if(currentUser.getUserType() == 1) {
                    System.out.println("Moving to Admin Console");
                    AdminConsole adminConsole = new AdminConsole();
                    adminConsole.login(currentUser);
                    adminConsole.display();
                    window.close();
                }
                else {
                    System.out.println("Moving to Customer Window");
                    CustomerWindow customerWindow = new CustomerWindow();
                    customerWindow.login(currentUser);
                    customerWindow.display();
                    window.close();
                }

            }
            else {
                System.out.println("User not found");
            }
        });

        registerButton.setOnAction(e -> {
            System.out.println("Registering new user...");
            RegisterHandler.display(o);

        });

        closeButton.setOnAction(e -> {
            window.close();
        });


        VBox layout = new VBox(10);
        HBox typeLine = new HBox(10);
        typeLine.getChildren().addAll(idButton, phoneButton);
        typeLine.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(label1, label2, textField, typeLine, registerButton, closeButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.showAndWait();
    }
}
