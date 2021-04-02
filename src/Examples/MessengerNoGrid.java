package Examples;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MessengerNoGrid extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ВЕРСИЯ БЕЗ СЕТКИ");
        //сцена создаётся на основе парента
        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui,980,500 ));

        primaryStage.show();
    }

    private Parent createInterface() {
        HBox main = new HBox();
        VBox left = new VBox();
        VBox right = new VBox();
        TextArea chat = new TextArea();
        HBox down = new HBox();
        TextField comment = new TextField();
        Button send = new Button("ОТПРАВИТЬ");
        Label lbl = new Label();
        ListView<String> people = new ListView<>();

        main.getChildren().addAll(left,right);
        left.getChildren().addAll(chat,down);
        down.getChildren().addAll(comment,send);
        right.getChildren().addAll(lbl,people);

        chat.setPrefWidth(780);
        chat.setPrefHeight(340);

        comment.setPrefWidth(630);
        comment.setPrefHeight(160);

        send.setPrefWidth(150);
        send.setPrefHeight(160);

        lbl.setPrefWidth(200);
        lbl.setPrefHeight(50);

        people.setPrefWidth(200);
        people.setPrefHeight(450);



        ObservableList<String> contacts = FXCollections.observableArrayList("Марио Марио", "Луиджи Марио", "Тоад", "Принцесса Пич");
        ListView<String> contactslist = new ListView<String>(contacts);

        send.setStyle("-fx-font-size: 19");
        chat.setEditable(false);

        return main;
    }
}
