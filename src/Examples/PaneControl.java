package Examples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class PaneControl extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Пример с панельками и управлением");
        //сцена создаётся на основе парента
        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui,640,480 ));

        primaryStage.show();
    }

    private Parent createInterface() {
        GridPane mainPain = new GridPane();
        VBox vbone = new VBox();
        VBox vbtwo = new VBox();
        HBox hb = new HBox();
        BorderPane bp = new BorderPane();

        mainPain.add(vbone,0,0);
        mainPain.add(vbtwo,0,1);
        mainPain.add(hb,1,0);
        mainPain.add(bp,1,1);

        mainPain.setStyle("-fx-font-size: 3em");

        //Зададим цвет панелям
        //ПРЯМ КАК В CSS только нужен префикс -fx-
        vbone.setStyle("-fx-background-color: red");
        // Background как и в CSS может задаваться не только цветом но и картинкой, текстурой и тд
        vbtwo.setBackground(new Background(new BackgroundFill(
                Color.GREEN, // Color extends Paint
                new CornerRadii(0), //border radius
                null // это старый добрый padding
        )));

        hb.setStyle("-fx-background-color: blue");
        bp.setStyle("-fx-background-color: yellow");

        //пока наполнения и размеров не было, объекты очень маленькие - не видно нифига

        vbone.getChildren()
                .add(new Button("первая кнопочка"));
        vbone.getChildren().addAll(
                new Button("Вторая кнопка"),
                new Button("!!!"),
                new Label("МЕЕТКАА С ТЕЕКСОТ")
        );

        //Теперь vbtwo

        final Button smallButton = new Button("!!!");
        vbtwo.getChildren().addAll(
                new ColorPicker(),
                smallButton,
                new Label("МЕЕТКАА С ТЕЕКСОТ")
        );

        //Теперь...

        hb.getChildren().addAll(
                new Button("Кн 1"),
                new Label("малiнько"),
                new Button("КНОПОЧКА")
        );

        // Добавим ограничения по элементам
        //Пускай она растягивает два стобца

        ColumnConstraints clone = new ColumnConstraints(); //Можно указать сразу, а можно и не можно
        clone.setPercentWidth(50);
        ColumnConstraints cltwo = new ColumnConstraints();
        cltwo.setPercentWidth(50);

        mainPain.getColumnConstraints().addAll(clone,cltwo);

        RowConstraints rowone = new RowConstraints();
        RowConstraints rowtwo = new RowConstraints();

        rowtwo.setVgrow(Priority.ALWAYS);

        mainPain.getRowConstraints().addAll(rowone,rowtwo);

        vbtwo.setAlignment(Pos.BOTTOM_RIGHT);

        //Способ универсальный устанавливать ограничения на элемент

        VBox.setVgrow(smallButton,Priority.ALWAYS);
        smallButton.setMaxWidth(Double.MAX_VALUE);

        final Button bottom = new Button("снизу");
        final Button left = new Button("слева");
        final Button right = new Button("справа");
        final Button top = new Button("сверху");
        final Button center = new Button("в центре");

        BorderPane.setAlignment(bottom, Pos.CENTER);
        bp.setBottom(bottom);
        bp.setLeft(left);
        bp.setRight(right);
        bp.setTop(top);
        bp.setCenter(center);

        for (Button b: List.of(bottom,left,right,top,center)) {
            b.setMaxWidth(Double.MAX_VALUE);
            b.setMaxHeight(Double.MAX_VALUE);
        }



        return mainPain; // возвращаем наш GridPane (ui из команды start)
    }
}
