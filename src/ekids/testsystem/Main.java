package ekids.testsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("testStage.fxml"));
        primaryStage.setTitle("Тесты по языка программирования");
        primaryStage.setScene(new Scene(root, 536, 460));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
