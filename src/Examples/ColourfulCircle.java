package Examples;

import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ColourfulCircle extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ВЕРСИЯ БЕЗ СЕТКИ");
        //сцена создаётся на основе парента
        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui,1200,500 ));

        primaryStage.show();
    }

    public Parent createInterface() {
        BorderPane manePain = new BorderPane();
        manePain.setStyle("-fx-background-color: red;-fx-font-size: 2em;");
        Pane right = new Pane();
        //right.setPrefWidth(Double.MAX_VALUE);
        right.prefWidthProperty().bind(manePain.widthProperty());
        //right.setStyle("-fx-background-color: yellow;");
        //AnchorPane canvass = new AnchorPane();
        //right.getChildren().add(canvass);


        VBox left = new VBox();
        Label sliderr = new Label("Радиус");
        Slider slider = new Slider(0,Math.min(right.getWidth()/2,right.getHeight()/2),100);


        Label circlecol = new Label("Цвет круга");
        ColorPicker circleColorPicker = new ColorPicker(Color.rgb(130, 100, 0));
        Label backcol = new Label("Цвет фона");
        ColorPicker backColorPicker = new ColorPicker(Color.rgb(30,120,50));
        left.getChildren().addAll(sliderr,slider, circlecol, circleColorPicker, backcol, backColorPicker);

        right.setBackground(new Background(new BackgroundFill(
                backColorPicker.getValue(), // Color extends Paint
                new CornerRadii(0), //border radius
                null // это старый добрый padding
        )));

        Circle circle = new Circle();
        right.getChildren().add(circle);
        System.out.println(right.getWidth());
        //circle.setCenterX(right.getWidth()/2);
        //circle.setCenterY(right.getHeight()/2);
        circle.setRadius(100);
        circle.setFill(circleColorPicker.getValue());

        // Middlepoint X source and target node
        NumberBinding middleX = right.layoutXProperty().divide(2)
                .add(circle.centerXProperty().divide(2).add(right.widthProperty().divide(2)));

        // Middlepoint Y source and target node
        NumberBinding middleY = right.layoutYProperty().divide(2)
                .add(circle.centerYProperty().divide(2).add(right.heightProperty().divide(2)));


        //manePain.getChildren().addAll(left,right);
        manePain.setLeft(left);
        manePain.setRight(right);

        left.setPrefWidth(300);
        left.setStyle("-fx-background-color: white");



        return manePain;
    }

}
