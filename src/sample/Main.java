package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.resources.connect.db.Database;

public class Main extends Application {

    public static Database DB = new Database();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(("resources/views/welcome.fxml")));

        primaryStage.setTitle("BUS: Bibliotheek uitleen systeem");
        primaryStage.getIcons().add(new Image("sample/resources/images/favicon.jpg"));
        Scene primary = (new Scene(root, 555, 444));
        primary.getStylesheets().add(getClass().getClassLoader().getResource("sample/resources/css/base.css").toExternalForm());
        primaryStage.setScene(primary);
        primaryStage.setResizable(false);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
