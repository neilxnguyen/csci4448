import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class CustomerWindow {
    public static User customer;

    public void login(User customer) {
        this.customer = customer;
    }

    public void display() {
        System.out.println("Showing Customer Window for Customer " + customer.getId());
        Stage window = new Stage();
        window.setTitle("Customer Window");

        Label label1 = new Label();
        label1.setText("Welcome Valued Customer");

        Button logOutButton = new Button("Log out");
        logOutButton.setOnAction(e -> {
            window.close();
            LogInHandler.display();

        });


        VBox vLayout = new VBox(10);
        vLayout.getChildren().addAll(label1, logOutButton);
        vLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vLayout, 300, 250);
        window.setScene(scene);
        window.show();
    }
}
