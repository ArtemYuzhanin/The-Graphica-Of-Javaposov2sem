package Examples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimesterFourthEndgame extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ВЕРСИЯ БЕЗ СЕТКИ");
        //сцена создаётся на основе парента
        Parent ui = createInterface();
        Scene scene = new Scene(ui,700,500 );

        scene.getStylesheets().add("stili.css");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private Parent createInterface() {
        HBox manePain = new HBox();
        VBox Stroopcanvas = new VBox();
        Button Stroopadd = new Button("Добавить");

        Stroopcanvas.setStyle("-fx-background-color: white");

        manePain.setHgrow(Stroopcanvas, Priority.ALWAYS);
        manePain.getChildren().addAll(Stroopcanvas,Stroopadd);

        manePain.setAlignment(Pos.TOP_RIGHT);
        return manePain;
    }
}
