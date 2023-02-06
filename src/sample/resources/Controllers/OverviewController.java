package sample.resources.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.resources.Models.ItemDetails;
import sample.resources.connect.db.Database;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class OverviewController implements Initializable {

    @FXML
    private MenuBar menuBarOverview;

    @FXML
    public TableView<ItemDetails> tableViewBooks;
    @FXML
    public TableColumn<ItemDetails, String> columnItemBooksName;
    @FXML
    public TableColumn<ItemDetails, String> columnItemBooksLang;
    @FXML
    public TableColumn<ItemDetails, Integer> columnItemBooksCountAvailable;
    @FXML
    public TableColumn<ItemDetails, Integer> columnItemBooksCountLend;
    @FXML
    private Button loadBookData;

    @FXML
    public TableView<ItemDetails> tableViewEBooks;
    @FXML
    public TableColumn<ItemDetails, String> columnItemEBooksName;
    @FXML
    public TableColumn<ItemDetails, String> columnItemEBooksLang;
    @FXML
    public TableColumn<ItemDetails, Integer> columnItemEBooksCountAvailable;
    @FXML
    public TableColumn<ItemDetails, Integer> columnItemEBooksCountLend;
    @FXML
    private Button loadEbookData;

    @FXML
    public TableView<ItemDetails> tableViewCDorDVD;
    @FXML
    public TableColumn<ItemDetails, String> columnItemCDorDVDName;
    @FXML
    public TableColumn<ItemDetails, String> columnItemCDorDVDLang;
    @FXML
    public TableColumn<ItemDetails, Integer> columnItemCDorDVDCountAvailable;
    @FXML
    public TableColumn<ItemDetails, Integer> columnItemCDorDVDCountLend;
    @FXML
    private Button loadCDorDVDData;

    @FXML
    public TableView<ItemDetails> tableViewMagazines;
    @FXML
    public TableColumn<ItemDetails, String> columnItemMagazinesName;
    @FXML
    public TableColumn<ItemDetails, String> columnItemMagazinesLang;
    @FXML
    public TableColumn<ItemDetails, Integer> columnItemMagazinesCountAvailable;
    @FXML
    public TableColumn<ItemDetails, Integer> columnItemMagazinesCountLend;
    @FXML
    private Button loadMagazinesData;

    //initialize observable list for loading data from database
    private ObservableList<ItemDetails>bookData;
    private ObservableList<ItemDetails>eBookData;
    private ObservableList<ItemDetails>dvdORcdData;
    private ObservableList<ItemDetails>MagazinesData;
    private Database dbc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dbc = new Database();
    }

    @FXML
    private void loadBookData(ActionEvent ActionEvent) {
        try {
            Connection conn = dbc.getConnection();
            bookData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM items WHERE item_sort='Boeken'");
            while (rs.next()) {

                bookData.add(new ItemDetails(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        //set cell factory to tableview
        columnItemBooksName.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        columnItemBooksLang.setCellValueFactory(new PropertyValueFactory<>("item_lang"));
        columnItemBooksCountAvailable.setCellValueFactory(new PropertyValueFactory<>("item_count_available"));
        columnItemBooksCountLend.setCellValueFactory(new PropertyValueFactory<>("item_count_lend"));

        tableViewBooks.setItems(null);
        tableViewBooks.setItems(bookData);
    }

    public void loadEBookData(ActionEvent actionEvent) {
        try {
            Connection conn = dbc.getConnection();
            eBookData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM items WHERE item_sort='E-Books'");
            while (rs.next()) {

                eBookData.add(new ItemDetails(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        //set cell factory to tableview
        columnItemEBooksName.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        columnItemEBooksLang.setCellValueFactory(new PropertyValueFactory<>("item_lang"));
        columnItemEBooksCountAvailable.setCellValueFactory(new PropertyValueFactory<>("item_count_available"));
        columnItemEBooksCountLend.setCellValueFactory(new PropertyValueFactory<>("item_count_lend"));

        tableViewEBooks.setItems(null);
        tableViewEBooks.setItems(eBookData);
    }

    public void loadCDorDVDData(ActionEvent actionEvent) {
        try {
            Connection conn = dbc.getConnection();
            dvdORcdData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM items WHERE item_sort='CD/DVD'");
            while (rs.next()) {

                dvdORcdData.add(new ItemDetails(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        //set cell factory to tableview
        columnItemCDorDVDName.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        columnItemCDorDVDLang.setCellValueFactory(new PropertyValueFactory<>("item_lang"));
        columnItemCDorDVDCountAvailable.setCellValueFactory(new PropertyValueFactory<>("item_count_available"));
        columnItemCDorDVDCountLend.setCellValueFactory(new PropertyValueFactory<>("item_count_lend"));

        tableViewCDorDVD.setItems(null);
        tableViewCDorDVD.setItems(dvdORcdData);
    }

    public void loadMagazinesData(ActionEvent actionEvent) {
        /**
         * Open a database connection inside this ActionEvent
         * Execute a query with the needed statement
         * while query is executed
         * Add data to the fields in the TableView columns with a total length of 5 rows
         */
        try {
            Connection conn = dbc.getConnection();
            MagazinesData = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM items WHERE item_sort='Tijdschriften'");
            while (rs.next()) {

                MagazinesData.add(new ItemDetails(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        }
        // set default value factory
        columnItemMagazinesName.setCellValueFactory(new PropertyValueFactory<>("item_name"));
        columnItemMagazinesLang.setCellValueFactory(new PropertyValueFactory<>("item_lang"));
        columnItemMagazinesCountAvailable.setCellValueFactory(new PropertyValueFactory<>("item_count_available"));
        columnItemMagazinesCountLend.setCellValueFactory(new PropertyValueFactory<>("item_count_lend"));

        tableViewMagazines.setItems(null);
        tableViewMagazines.setItems(MagazinesData);
    }

    public void searchItem(ActionEvent event) {
        System.out.println("Zoeken");
    }

    /**
     * Menu items
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void handleItemOverview(ActionEvent actionEvent) throws IOException {
        Parent userLogoutToLoginView = FXMLLoader.load(getClass().getResource("../views/item-overview.fxml"));
        Scene userLogoutToLoginScene = new Scene(userLogoutToLoginView);
        Stage userLogoutToLoginStage = (Stage) menuBarOverview.getScene().getWindow();
        userLogoutToLoginStage.setScene(userLogoutToLoginScene);
        userLogoutToLoginStage.show();
    }

    @FXML
    public void handleUserManagement(ActionEvent actionEvent) throws IOException {
        Parent userManagementView = FXMLLoader.load(getClass().getResource("../views/user-management.fxml"));
        Scene userManagementScene = new Scene(userManagementView);
        Stage userManagementStage = (Stage) menuBarOverview.getScene().getWindow();
        userManagementStage.setScene(userManagementScene);
        userManagementStage.show();
    }

    @FXML
    public void handleUserLogout(ActionEvent actionEvent) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("../views/login.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) menuBarOverview.getScene().getWindow();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}
