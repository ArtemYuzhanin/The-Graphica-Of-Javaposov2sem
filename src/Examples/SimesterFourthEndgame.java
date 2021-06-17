package Examples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class SimesterFourthEndgame extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ПОСЛЕДНИЙ БОЙ");
        //сцена создаётся на основе парента
        Parent ui = createInterface();
        Scene scene = new Scene(ui,700,500 );

        scene.getStylesheets().add("Examples/stili.css");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private Parent createInterface() {
        HBox manePain = new HBox();
        VBox Stroopcanvas = new VBox();
        Button Stroopadd = new Button("Добавить");
        Label nabel1 = new Label("Красный");
        nabel1.setStyle("-fx-text-fill: blue");
        Label nabel2 = new Label("Коричневый");
        nabel2.setStyle("-fx-text-fill: orange");
        Label nabel3 = new Label("Жёлтый");
        nabel3.setStyle("-fx-text-fill: red");

        Rectangle rect1 = new Rectangle(60,20);
        rect1.getStyleClass().add("boxes");
        rect1.setStyle("-fx-fill: green");


        Label nabel4 = new Label("Бирюзовый");
        nabel4.setStyle("-fx-text-fill: black");
        Label nabel5 = new Label("Зелёный");
        nabel5.setStyle("-fx-text-fill: yellow");

        Rectangle rect2 = new Rectangle(60,20);
        rect2.getStyleClass().add("boxes");
        rect2.setStyle("-fx-fill: skyblue");

        nabel1.getStyleClass().add("fouls");
        nabel2.getStyleClass().add("fouls");
        nabel3.getStyleClass().add("fouls");
        nabel4.getStyleClass().add("fouls");
        nabel5.getStyleClass().add("fouls");


        Stroopcanvas.getStyleClass().add("Strooppanel");

        Stroopadd.setPrefWidth(120);
        Stroopadd.setMinWidth(120);
        Stroopadd.setPrefHeight(50);
        Stroopadd.setMinHeight(50);
        Stroopadd.setStyle("-fx-font-size: 20px");

        manePain.setHgrow(Stroopcanvas, Priority.ALWAYS);
        manePain.getChildren().addAll(Stroopcanvas,Stroopadd);
        manePain.setAlignment(Pos.TOP_RIGHT);

        Stroopcanvas.setAlignment(Pos.CENTER);
        Stroopcanvas.getChildren().addAll(nabel1,nabel2,nabel3,rect1,nabel4,nabel5,rect2);

        Random decider = new Random();
        ArrayList<Node> nodes = new ArrayList<Node>();
        String[] names = {"Красный","Оранжевый","Жёлтый","Зелёный","Голубой","Синий","Фиолетовый","Чёрный","Коричневый"};
        String[] insides = {"red","orange","yellow","green","skyblue","blue","violet","black","brown"};

        Stroopadd.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            System.out.println(nodes.size());
            nodes.clear();
            if (decider.nextBoolean()) {
                Stroopcanvas.getChildren().add(new Label(names[decider.nextInt(8)]));
                addAllDescendents(Stroopcanvas,nodes);
                (nodes.get(nodes.size() - 1)).getStyleClass().add("fouls");
                (nodes.get(nodes.size() - 1)).setStyle("-fx-text-fill:"+insides[decider.nextInt(8)]);
            } else {
                Stroopcanvas.getChildren().add(new Rectangle(60,20));
                addAllDescendents(Stroopcanvas,nodes);
                (nodes.get(nodes.size() - 1)).getStyleClass().add("boxes");
                (nodes.get(nodes.size() - 1)).setStyle("-fx-fill:"+insides[decider.nextInt(8)]);
            }

            if (nodes.size() > 13) {
                Stroopcanvas.getChildren().remove(nodes.get(0));
                nodes.remove(0);
            }

        });
        return manePain;
    }

    private static void addAllDescendents(Parent parent, ArrayList<Node> nodes) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            nodes.add(node);
            if (node instanceof Parent)
                addAllDescendents((Parent)node, nodes);
        }
    }
}
