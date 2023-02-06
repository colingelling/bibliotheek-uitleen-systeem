package sample.resources.Controllers;

import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sample.resources.connect.db.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {
    @FXML
    public TextField userField;
    @FXML
    public TextField passwordField;
    @FXML
    public Label isConnected;
    @FXML
    public Button login;
    @FXML
    public Button passwordRecovery;

    public void login(ActionEvent actionEvent) {
        Database connectionClass = new Database();
        Connection connection=connectionClass.getConnection();

        try {
            Statement statement=connection.createStatement();
            String sql = "SELECT * FROM users WHERE username = '"+userField.getText()+"' AND password = '"+passwordField.getText()+"';";
            ResultSet resultSet=statement.executeQuery(sql);

            if (resultSet.next()){
                Parent userLoginView = FXMLLoader.load(getClass().getResource(("../views/item-overview.fxml")));
                Stage userLoginStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Scene login = new Scene(userLoginView);
                userLoginStage.setTitle("BUS: Bibliotheek uitleen systeem - Item overzicht");
                userLoginStage.getIcons().add(new Image("sample/resources/images/favicon.jpg"));
                userLoginStage.setScene(login);
                userLoginStage.show();

            } else {
                isConnected.setText("Bovenstaande gegevens kloppen niet, probeer opnieuw");
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void passwordRecovery(ActionEvent event) throws IOException {
        Parent passwordRecoveryBtn = FXMLLoader.load(getClass().getResource(("../views/password-recovery.fxml")));
        Stage passwordRecoveryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene passwordRecoveryScene = new Scene(passwordRecoveryBtn);
        passwordRecoveryStage.setTitle("BUS: Bibliotheek uitleen systeem - Password recovery");
        passwordRecoveryStage.getIcons().add(new Image("sample/resources/images/favicon.jpg"));
        passwordRecoveryStage.setScene(passwordRecoveryScene);
        passwordRecoveryStage.show();
    }
}
