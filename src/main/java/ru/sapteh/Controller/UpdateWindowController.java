package ru.sapteh.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.Dao.Dao;
import ru.sapteh.daoimpl.Radio_Elementsdaoimpl;
import ru.sapteh.model.Radio_Elements;

public class UpdateWindowController {

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
    void okButton(ActionEvent event) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<Radio_Elements,Integer> radio_elementsdaoimpl = new Radio_Elementsdaoimpl(factory);
        radio_elementsdaoimpl.

    }

}
