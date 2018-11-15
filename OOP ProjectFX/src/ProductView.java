import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import java.util.List;
import java.util.stream.Collectors;

public class ProductView {
    public static void display() {
        Stage window = new Stage();
        window.setTitle("Product Handler");

        ObservableList<Product> productList =
                FXCollections.observableArrayList(Products.products);

        ObservableList<String> productListNames =
                FXCollections.observableArrayList(Products.products.stream()
                        .map(Product::getName)
                        .collect(Collectors.toList())
                );

        ListView<String> lv = new ListView<>(productListNames);
        HBox hLayout = new HBox(10);
        hLayout.getChildren().addAll(lv);
        Scene scene = new Scene(hLayout);
        window.setScene(scene);
        window.show();
    }
}
