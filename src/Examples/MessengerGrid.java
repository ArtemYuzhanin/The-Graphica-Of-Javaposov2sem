package Examples;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessengerGrid extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ВЕРСИЯ С СЕТКОЙ");
        //сцена создаётся на основе парента
        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui,980,500 ));

        primaryStage.show();
    }

    private Parent createInterface() {
        SimpleDateFormat messagetime = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");

        GridPane manePain = new GridPane();

        HBox chatwrap = new HBox();
        TextArea chat = new TextArea();
        //TextFlow chat = new TextFlow();
        chat.setWrapText(true);
        chat.setEditable(false);

        HBox commentwrap = new HBox();
        TextField comment = new TextField();
        comment.setAlignment(Pos.TOP_LEFT);
        comment.setPromptText("Введите сообщение");

        HBox sendwrap = new HBox();
        Button send = new Button("ОТПРАВИТЬ");
        chat.setStyle("-fx-highlight-fill: #ADFF2F; -fx-highlight-text-fill: #B22222; -fx-font-size: 14px;");
        send.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            Date date = new Date();
            chat.setText(chat.getText()+ "Xx_TrueGamer2001_xX ("+ messagetime.format(date) +")\n");
            chat.setText(chat.getText()+ comment.getText()+"\n\n");
            comment.setText("");
            comment.requestFocus();
        });

        VBox peoplewrap = new VBox();
        ObservableList<String> langs = FXCollections.observableArrayList("Санёк", "Ефим Владимирович", "Катя", "Ролики и Велосипеды", "Енисей","Тётя Лида", "Ножи Под Заказ","Оксана Михайловна","Егор","Папа","ОАО 'Корнеплод'","Сосед Ваня","Лена","Армэн (Арбузы)","Никита","Имя Фамилия","Елисей");
        ListView<String> people = new ListView<>(langs);
        people.setStyle("-fx-control-inner-background: #94f4ff;-fx-control-inner-background-alt: #85d8ff;");
        //people.setStyle("-fx-control-inner-background-alt: derive(-fx-control-inner-background, 50%);");

        HBox lblwrap = new HBox();
        Label lbl = new Label("Контакты:");

        for (int i = 0; i < 10; i++) {
            RowConstraints row = new RowConstraints(50);
            manePain.getRowConstraints().add(row);
        }

        for (int i = 0; i < 14; i++) {
            ColumnConstraints column = new ColumnConstraints(70);
            manePain.getColumnConstraints().add(column);
        }

        manePain.add(chatwrap,0,0,10,7);
        manePain.add(commentwrap,0,7,8,3);
        manePain.add(sendwrap,8,7,2,3);
        manePain.add(peoplewrap, 10,1,4,9);
        manePain.add(lblwrap,10,0,4,1);

        chatwrap.setStyle("-fx-background-color: red");
        commentwrap.setStyle("-fx-background-color: blue");
        sendwrap.setStyle("-fx-background-color: green");
        peoplewrap.setStyle("-fx-background-color: yellow");
        lblwrap.setStyle("-fx-background-color: #1f2f7d");

        chatwrap.getChildren().add(chat);
        HBox.setHgrow(chat,Priority.ALWAYS);
        chat.setMaxWidth(Double.MAX_VALUE);

        peoplewrap.getChildren().add(people);
        VBox.setVgrow(people,Priority.ALWAYS);
        people.setMaxHeight(Double.MAX_VALUE);

        commentwrap.getChildren().add(comment);
        HBox.setHgrow(comment,Priority.ALWAYS);
        comment.setMaxWidth(Double.MAX_VALUE);
        comment.setMaxHeight(Double.MAX_VALUE);

        sendwrap.getChildren().add(send);
        HBox.setHgrow(send,Priority.ALWAYS);
        send.setMaxWidth(Double.MAX_VALUE);
        send.setMaxHeight(Double.MAX_VALUE);

        lblwrap.getChildren().add(lbl);
        lbl.setStyle("-fx-font-size: 3em;-fx-text-fill: white;");


        return manePain;
    }
}
