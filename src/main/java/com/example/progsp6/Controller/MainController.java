package com.example.progsp6.Controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import com.example.progsp6.Client;
import com.example.progsp6.Main;
import com.example.progsp6.Model.DateUtil;
import com.example.progsp6.Model.Document;
import com.example.progsp6.Model.Request;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private AnchorPane anchorPane1;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private ButtonBar buttonBar;

    @FXML
    private Label categoryLabel;

    @FXML
    private Button changeButton;

    @FXML
    private TableColumn<Document, String> columnName;

    @FXML
    private TableColumn<Document, Integer> columnNumber;

    @FXML
    private Label dateLabel;

    @FXML
    private Button deleteButton;

    @FXML
    private GridPane gridPane;

    @FXML
    private Label labelInfo;

    @FXML
    private Label nameLabel;

    @FXML
    private Label numberLabel;

    @FXML
    private SplitPane splitPane;

    @FXML
    private Label statusLabel;

    @FXML
    private TableView<Document> tableView;

    @FXML
    private Label typeLabel;

    private Main main = new Main();
    private Client client = new Client();
    Request request = new Request();
    ArrayList<Document> documentsArray = new ArrayList<>();
    ObservableList<Document> documents;


    public MainController() {
    }

    @FXML
    void initialize() {
        columnName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        columnNumber.setCellValueFactory(cellData -> cellData.getValue().numberOfDocProperty().asObject());
        showDocDetails(null);
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showDocDetails(newValue));
    }

    public void buildTable() throws SQLException {
        request.setRequest("get");
        request.setDocuments(documentsArray);
        documentsArray = client.getData(request);
        documents = FXCollections.observableArrayList(documentsArray);
        tableView.setItems(documents);
    }

    public void updateTable() throws SQLException {
        documents.clear();
        buildTable();
    }


    private void showDocDetails(Document document) {
        if (document != null) {
            nameLabel.setText(document.getName());
            numberLabel.setText(Integer.toString(document.getNumberOfDoc()));
            categoryLabel.setText(document.getCategory());
            typeLabel.setText(document.getType());
            statusLabel.setText(document.getStatus());
            dateLabel.setText(DateUtil.format(document.getDate()));
        } else {
            nameLabel.setText("");
            numberLabel.setText("");
            categoryLabel.setText("");
            typeLabel.setText("");
            statusLabel.setText("");
            dateLabel.setText("");
        }
    }

    @FXML
    void deleteDocument(ActionEvent event) throws SQLException {
        ArrayList<Document> documents = new ArrayList<>();
        Document document = tableView.getSelectionModel().getSelectedItem();
        int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаление");
            alert.setHeaderText("Удаление аккаунта");
            alert.setContentText("Вы действительно хотите удалить аккаунт?");
            Optional<ButtonType> res = alert.showAndWait();
            if (res.get() == ButtonType.OK) {
                documents.add(document);
                request.setRequest("delete");
                request.setDocuments(documents);
                client.getData(request);
                updateTable();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Не выбрана строка для удаления!");
            alert.setHeaderText("Предупреждение!");
            alert.setContentText("Выберите, пожалуйста, строку в таблице");
            alert.showAndWait();
        }
    }

    @FXML
    private void addDocument() throws SQLException {
        ArrayList<Document> documents = new ArrayList<>();
        Document document = new Document();
        boolean okClicked = main.showDocAddDialog(document);
        if (okClicked) {
            documents.add(document);
            request.setRequest("add");
            request.setDocuments(documents);
            client.getData(request);
            updateTable();
        }
    }

    @FXML
    private void editDocument() throws SQLException {
        ArrayList<Document> documents = new ArrayList<>();
        Document selectedDoc = tableView.getSelectionModel().getSelectedItem();
        if (selectedDoc != null) {
            boolean okClicked = main.showDocEditDialog(selectedDoc);
            if (okClicked) {
                documents.add(selectedDoc);
                request.setRequest("edit");
                request.setDocuments(documents);
                client.getData(request);
                updateTable();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Нет выбранной записи");
            alert.setHeaderText("Не выбрана запись");
            alert.setContentText("Выберите запись в таблице для редактирования");
            alert.showAndWait();
        }
    }

}


