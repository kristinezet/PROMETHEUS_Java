package main;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    Tradepoints t = new Tradepoints("1");

    HBox hbox = new HBox(20);
    ScrollPane scrollPane = new ScrollPane(hbox);
    Button add = new Button("add");
    HBox button = new HBox(add);
    AnchorPane pane = new AnchorPane(scrollPane, button);

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(pane, 400, 400));
        add.setOnAction(a -> {
            Tradepoint tr = AddTradepointWindow.addTradepoint();
            if(tr != null) {
                t.add(tr);
                hbox.getChildren().add(new TradepointPane(tr, t));
            }
        });

        for(Tradepoint tr : t.tradepoints)
            hbox.getChildren().add(new TradepointPane(tr, t));

        pane.setStyle("-fx-font-size: 15px");

        initAnchors();

        primaryStage.show();
    }

    private void initAnchors(){
        AnchorPane.setLeftAnchor(button, 0.0);
        AnchorPane.setTopAnchor(button, 0.0);
        AnchorPane.setRightAnchor(button, 0.0);
        button.setPrefSize(100, 50.0);
        button.setAlignment(Pos.CENTER);

        add.setPrefSize(100, 40);
        AnchorPane.setLeftAnchor(scrollPane, 10.0);
        AnchorPane.setTopAnchor(scrollPane, 60.0);
        AnchorPane.setRightAnchor(scrollPane, 0.0);
        AnchorPane.setBottomAnchor(scrollPane, 10.0);
    }
}