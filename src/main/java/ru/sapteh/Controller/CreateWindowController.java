package ru.sapteh.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Dao.Dao;
import ru.sapteh.daoimpl.Radio_Elementsdaoimpl;
import ru.sapteh.model.Radio_Elements;


public class CreateWindowController {

    ObservableList<Radio_Elements> radioElements = FXCollections.observableArrayList();
    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField manufacturerTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TextField quantityTextField;

    @FXML
    private TextField costTextField;
    @FXML
    private Label label;

    SessionFactory factory = new Configuration().configure().buildSessionFactory();

    @FXML
    void okButton (ActionEvent event) {
        Radio_Elements radio_elements = new Radio_Elements(Integer.parseInt(idTextField.getText()),
                nameTextField.getText(),
                manufacturerTextField.getText(),
                descriptionTextField.getText(),
                Integer.parseInt(quantityTextField.getText()),
                Integer.parseInt(costTextField.getText()));

        if (radio_elements !=null){
            label.setText("Данные были успешно добавлены");
        }else{
            label.setText("Данные были не добавлены ");
        }

        Dao<Radio_Elements,Integer> radio_elementsIntegerDao = new Radio_Elementsdaoimpl(factory);
        radio_elementsIntegerDao.create(radio_elements);
    }
}






