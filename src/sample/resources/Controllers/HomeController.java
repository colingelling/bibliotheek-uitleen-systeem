package sample.resources.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    Button loginBtn = new Button();
    Button welcomeBtn = new Button();

    @FXML
    void welcomeBtn(ActionEvent event) throws IOException {
        Parent welcomeBtn = FXMLLoader.load(getClass().getResource(("../views/welcome.fxml")));
        Stage welcomeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene welcomeScene = new Scene(welcomeBtn);
        welcomeStage.setTitle("BUS: Bibliotheek uitleen systeem - Welcome");
        welcomeStage.getIcons().add(new Image("sample/resources/images/favicon.jpg"));
        welcomeStage.setScene(welcomeScene);
        welcomeStage.show();
    }

    @FXML
    void loginBtn(ActionEvent event) throws IOException {
        Parent loginBtn = FXMLLoader.load(getClass().getResource(("../views/login.fxml")));
        Stage loginStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene loginScene = new Scene(loginBtn);
        loginStage.setTitle("BUS: Bibliotheek uitleen systeem - Aanmelden");
        loginStage.getIcons().add(new Image("sample/resources/images/favicon.jpg"));
        loginStage.setScene(loginScene);
        loginStage.show();
    }
}
