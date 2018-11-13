import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    Stage window;
    Button button;


    public static void main(String[] args) throws IOException, ClassNotFoundException{
        Users.initializeUsers();
//        Users.createDefaultAdmins();
//        Users.createDefaultCustomers();
//        Users.save();
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Main");

        button = new Button("Click me to begin");
        button.setOnAction(e -> {
            window.close();
            System.out.println(Users.users);
            LogInHandler.display();
        });

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
