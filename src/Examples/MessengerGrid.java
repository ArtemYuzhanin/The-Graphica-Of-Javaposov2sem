package Examples;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

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
        VBox back = new VBox();

        GridPane mane = new GridPane();
        back.getChildren().add(mane);
        back.setPrefSize(980,500);
        TextArea chat = new TextArea();
        TextField comment = new TextField();
        Button send = new Button("ОТПРАВИТЬ");
        ListView<String> people = new ListView<>();
        Label lbl = new Label();

        mane.add(chat,0,0,11,7);
        mane.add(comment,0,7,9,3);
        mane.add(send,9,7,2,3);
        mane.add(people, 11,1,3,9);
        mane.add(lbl,11,0,3,1);

        //back.setVgrow(Priority.ALWAYS);
       //mane.setMaxWidth(Double.MAX_VALUE);

        //AnchorPane.setLeftAnchor(mane, 0.0);
        //AnchorPane.setRightAnchor(mane, 0.0);
        back.setFillWidth(true);



        return back;
    }
}
