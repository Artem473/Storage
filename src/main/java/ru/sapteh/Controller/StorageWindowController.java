package ru.sapteh.Controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Dao.Dao;
import ru.sapteh.daoimpl.Radio_Elementsdaoimpl;
import ru.sapteh.model.Radio_Elements;

import java.io.IOException;


public class StorageWindowController {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Dao<Radio_Elements,Integer> radio_elementsdaoimpl= new Radio_Elementsdaoimpl(factory);

    @FXML
    private TableView<Radio_Elements> tableViewRadio_Elements;

    @FXML
    private TableColumn<Radio_Elements, Integer> idColumn;

    @FXML
    private TableColumn<Radio_Elements, String> nameColumn;

    @FXML
    private TableColumn<Radio_Elements, String> descriptionColumn;

    @FXML
    private TableColumn<Radio_Elements, String> manufacturerColumn;

    @FXML
    private TableColumn<Radio_Elements,Integer > quantityColumn;

    @FXML
    private TableColumn<Radio_Elements, Double> costColumn;

    private final ObservableList<Radio_Elements> observableList = FXCollections.observableArrayList();

    public void createButton(javafx.event.ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/View/CreateWindow.fxml"));
        stage.setTitle("CreateWindow");
        stage.setScene(new Scene(root));
        stage.show();
    }


    @FXML
    void initialize() {
        initTableView();
    }

    private void initTableView(){
        idColumn.setCellValueFactory(c->new SimpleObjectProperty<>(c.getValue().getId()));
        nameColumn.setCellValueFactory(c->new SimpleObjectProperty<>(c.getValue().getName()));
        descriptionColumn.setCellValueFactory(c->new SimpleObjectProperty<>(c.getValue().getDescription()));
        manufacturerColumn.setCellValueFactory(c->new SimpleObjectProperty<>(c.getValue().getManufacturer()));
        quantityColumn.setCellValueFactory(c->new SimpleObjectProperty<>(c.getValue().getQuantity()));
        costColumn.setCellValueFactory(c->new SimpleObjectProperty<>(c.getValue().getCost()));
        tableViewRadio_Elements.setItems(observableList);
        observableList.addAll(radio_elementsdaoimpl.findByAll());
    }
}

