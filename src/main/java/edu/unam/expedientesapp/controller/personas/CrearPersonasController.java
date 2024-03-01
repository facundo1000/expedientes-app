package edu.unam.expedientesapp.controller.personas;

import edu.unam.expedientesapp.models.Persona;
import edu.unam.expedientesapp.service.ServiceCrud;
import edu.unam.expedientesapp.utils.TipoDeDocumento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class CrearPersonasController implements Initializable {

    @FXML
    private Button btnRegistrar;

    @FXML
    private ComboBox<String> comboBoxTipoDoc;

    @FXML
    private DatePicker datepickerFechaNac;

    @FXML
    private TextField inputApellidos;

    @FXML
    private TextField inputCorreoElectronico;

    @FXML
    private TextField inputNombres;

    @FXML
    private TextField inputNroDoc;

    @FXML
    private CheckBox chkDirector;

    @FXML
    private CheckBox chkDocente;

    @FXML
    private CheckBox chkEstudiante;

    @FXML
    private CheckBox chkMiembro;

    @FXML
    private CheckBox chkNoDocente;

    @FXML
    private TextField inputTelefono;

    @Autowired
    private ServiceCrud<Persona> personaCrud;

    public CrearPersonasController() {}

    private Alert alert = new Alert(Alert.AlertType.ERROR);


    public void addPersona() {
        if (comboBoxTipoDoc.getSelectionModel().getSelectedItem().isEmpty()
                || inputApellidos.getText().isEmpty()
                || inputCorreoElectronico.getText().isEmpty()
                || inputNombres.getText().isEmpty()
                || inputNroDoc.getText().isEmpty()) {

            alert.setContentText("Por favor complete los campos vacios");
        } else {
            personaCrud.crear(new Persona(null, inputNombres.getText(), inputApellidos.getText(),
                    inputNroDoc.getText(),
                    inputTelefono.getText(),
                    inputCorreoElectronico.getText(),
                    List.of(chkDocente.getText(), chkNoDocente.getText(), chkEstudiante.getText(), chkMiembro.getText(), chkDirector.getText()),
                    comboBoxTipoDoc.getSelectionModel().getSelectedItem(),
                    datepickerFechaNac.getValue(),
                    true,
                    false));
        }
    }

    public void cleanFields() {
        inputNombres.setText("");
        inputApellidos.setText("");
        inputCorreoElectronico.setText("");
        inputTelefono.setText("");
        inputCorreoElectronico.setText("");
        inputNroDoc.setText("");
        chkDirector.setSelected(false);
        chkDocente.setSelected(false);
        chkEstudiante.setSelected(false);
        chkMiembro.setSelected(false);
        chkNoDocente.setSelected(false);
        comboBoxTipoDoc.getSelectionModel().clearSelection();
    }


    public void tipoDniList() {

        List<String> list = new ArrayList<>();

        for (TipoDeDocumento data : TipoDeDocumento.values()) {
            list.add(data.getNombre());
        }
        ObservableList<String> ls = FXCollections.observableArrayList(list);
        comboBoxTipoDoc.setItems(ls);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tipoDniList();
    }
}
