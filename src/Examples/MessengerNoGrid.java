package Examples;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        SimpleDateFormat messagetime = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        HBox manePain = new HBox();
        manePain.setStyle("-fx-background-color: red");
        manePain.setPrefSize(980,500);
        VBox left = new VBox();
        left.setStyle("-fx-background-color: yellow");

        HBox chatwrap = new HBox();
        chatwrap.setStyle("-fx-background-color: green");
        TextArea chat = new TextArea();
        //TextFlow chat = new TextFlow();
        chat.setWrapText(true);
        chat.setEditable(false);
        chat.setMinHeight(350);
        chatwrap.getChildren().add(chat);
        HBox.setHgrow(chat, Priority.ALWAYS);
        chat.setMaxWidth(Double.MAX_VALUE);

        BorderPane down = new BorderPane();
        down.setStyle("-fx-background-color: blue");
        TextField comment = new TextField();
        comment.setAlignment(Pos.TOP_LEFT);
        comment.setPromptText("Введите сообщение");
        Button send = new Button("ОТПРАВИТЬ");
        down.setLeft(comment);
        comment.setPrefWidth(560);
        comment.setPrefHeight(150);
        comment.setMinHeight(150);
        down.setRight(send);
        send.setPrefWidth(140);
        send.setPrefHeight(150);
        send.setMinHeight(150);
        chat.setStyle("-fx-highlight-fill: #ADFF2F; -fx-highlight-text-fill: #B22222; -fx-font-size: 14px;");
        send.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            Date date = new Date();
            chat.setText(chat.getText()+ "LadyBabyPrincess_1930 ("+ messagetime.format(date) +")\n");
            chat.setText(chat.getText()+ comment.getText()+"\n\n");
            comment.setText("");
            comment.requestFocus();
        });



        VBox right = new VBox();
        ObservableList<String> langs = FXCollections.observableArrayList("Павел(Ремонт)","Ульяна Фёдоровна","Галя","Агенство по недвижимости","Юрка","Щикунов","'Единая страна'","Ева (Косметолог)","Сестрёнка","Олег Павлович","Водонабор","Пекарня 'Абелх Аклуб'","Аня","ДеньгиБыстроРу","Езда на лошадях","Николай Д.","Имя Фамилия","Елена Струкская");
        ListView<String> people = new ListView<>(langs);
        people.setStyle("-fx-control-inner-background: #f5d0f1;-fx-control-inner-background-alt: #f5c4f0;");
        HBox lblwrap = new HBox();
        Label lbl = new Label("Контакты:");

        manePain.getChildren().addAll(left,right);

        left.setPrefWidth(700);


        left.getChildren().addAll(chatwrap,down);
        chatwrap.setPrefHeight(350);
        down.setPrefHeight(150);

        right.getChildren().addAll(lblwrap,people);
        people.setPrefSize(280,450);
        lblwrap.getChildren().add(lbl);
        lblwrap.setPrefSize(280,50);
        lblwrap.setStyle("-fx-background-color: #b52aa7");
        lbl.setStyle("-fx-font-size: 3em;-fx-text-fill: white;");

        return manePain;
    }
}
