import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class AdminConsole{
    public static User admin;

    public void login(User admin){
        this.admin = admin;
    }


    public static void display() {
        System.out.println("Showing Admin Console");
        Stage window = new Stage();
        window.setTitle("Admin Console");

        Label label1 = new Label();
        label1.setText("Welcome to the Admin Console");

        Button registerButton = new Button("Register new customer");
        registerButton.setOnAction(e -> {
            RegisterHandler.display();
        });

        Button saveUsers = new Button("Save User Database");
        saveUsers.setOnAction(e -> {
            System.out.println("Saves users to users.tmp");
            try {
                Users.save();
            } catch (IOException i) {
                i.printStackTrace();
                System.out.println("Something went horribly wrong, could not save");
            }
        });

        VBox vLayout = new VBox(10);
        vLayout.getChildren().addAll(label1, registerButton, saveUsers);
        vLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vLayout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
