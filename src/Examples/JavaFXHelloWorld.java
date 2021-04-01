
package Examples;


        import javafx.application.Application;
        import javafx.scene.control.Button;
        import javafx.stage.Stage;
        import javafx.scene.*;



public class JavaFXHelloWorld extends Application {

    @Override
    public void start(Stage mainstage) throws Exception {
        mainstage.setTitle("HollaAmigos From JavaFX");

        Parent button = initInterface();
        mainstage.setScene(new Scene(button, 640, 480));

        mainstage.show();
    }

    private Button initInterface(){
        Button pressMe = new Button("Нажми на меня");
        pressMe.setOnAction(event -> System.out.println("~БУУ~"));
        return pressMe;
    }
}