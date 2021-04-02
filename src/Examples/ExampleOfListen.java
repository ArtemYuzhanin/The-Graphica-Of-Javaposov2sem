package Examples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExampleOfListen extends Application {
        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("ПОСЛУШАЙ ПРИМЕР");

            Parent ui = createInterface();
            primaryStage.setScene(new Scene(ui, 640, 480));

            primaryStage.show();
        }

        private Parent createInterface() {
            VBox mane = new VBox();
            Image image = new Image("https://i.gifer.com/origin/00/00ae53a95ee7af0be395f5291d792c9a.gif");
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(600);
            imageView.setPreserveRatio(true);

            Button b = new Button("Не нажимать");
            Label lol = new Label("На нажимать");

            mane.getChildren().addAll(b,lol);
            mane.setAlignment(Pos.CENTER);
            //mane.setAlignment(imageView, Pos.CENTER);
            lol.setStyle("-fx-font-size: 20");

            //mane.setAlignment(b,Pos.CENTER_RIGHT);
            b.setPrefWidth(300);
            b.setPrefHeight(200);
            b.setTextOverrun(OverrunStyle.CLIP);

            lol.setPadding(new Insets(20, 50, 50, 50));




            //Добавляем слушателя
            b.addEventHandler(ActionEvent.ACTION, actionEvent -> {
                var fonti = b.getFont().getSize();
                System.out.println(fonti);
                if (fonti < 81) {
                    fonti = fonti + 13;
                }
                else {
                    fonti = fonti + 1;
                }

                if (fonti == 25) {
                    lol.setText("Читать не умеем?");
                }
                else if (fonti == 38) {
                    lol.setText("СКАЗАНО - НЕ НАЖИМАТЬ");
                }
                else if (fonti == 51) {
                    lol.setText("ТЫ ИДИОТ?");
                }
                else if (fonti == 64) {
                    lol.setStyle("-fx-font-size: 34");
                    lol.setText("ИДИОТ?");
                }
                else if (fonti == 77) {
                    lol.setStyle("-fx-font-size: 20");
                    lol.setText("идиот");
                }
                else if (fonti == 90) {
                    lol.setText("...");
                }
                else {
                    mane.getChildren().removeAll(b,lol);
                    mane.getChildren().add(imageView);
                }

                b.setStyle("-fx-font-size: " + fonti);
            });


            b.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
                // В информации события есть координаыты
                System.out.println("x,y = "+mouseEvent.getX() + " " + mouseEvent.getY());
                System.out.println("МЫШЬ УВЕДИ УВЕДИ ГОВОРЯТ");
            });

            //еще пример

            b.setOnAction(actionEvent ->{

            });
            //setOnAction - так можно задать для кнопки ровно один обработчик события
            //addEventHandler - способ универсальный, можно много обработчиков задать
            //а также их можно удалить через removeEventHandler


            return mane;
        }

}
