import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
//        TEST REGION
        Products.initializeProducts();
//        Products.createDefaultProducts();
//        System.out.println(Products.products);
//        END TEST REGION


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
        button.setDefaultButton(true);
        button.setOnAction(e -> {
            window.close();
//            ProductView.display();
//            System.out.println(Users.users);
            LogInHandler.display();

        });

        StackPane layout = new StackPane();
        layout.getChildren().addAll(button);
        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

//    Things still left to do:
    /*Create check-out handler
    * Products will go down in stock when someone checks
    * Products
    * Admins can add new product
    * Admins can remove product
    * */
}
