package edu.unam.expedientesapp.controller;

import edu.unam.expedientesapp.models.Persona;
import edu.unam.expedientesapp.service.ServiceCrud;
import edu.unam.expedientesapp.service.impl.PersonasServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

@Controller
public class MainFormController implements Initializable {
    @FXML
    private Button addPersonaBtnAgregar;

    @FXML
    private Button addPersonaBtnUpdate;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaApellido;

    @FXML
    private Button addPersonaColPersonaDelete;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaDni;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaEmail;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaId;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaNombre;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaTelefono;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaTipo;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaTipoDni;

    @FXML
    private AnchorPane addPersonasForm;

    @FXML
    private TableView<Persona> addPersonasTableView;

    @FXML
    private Button btnAddAccion;

    @FXML
    private Button btnAddExpediente;

    @FXML
    private Button btnAddOrdenDelDia;

    @FXML
    private Button btnAddPersona;

    @FXML
    private Button btnAddReunion;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnMiembros;

    @FXML
    private AnchorPane greetUser;

    @FXML
    private TableColumn<Persona, String> addPersonaColPersonaBday;

    @Autowired
    private ServiceCrud<Persona> personasCrud;

    private Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

    public MainFormController() {}

    public ObservableList<Persona> addPersonaGetData() {
        ObservableList<Persona> listData = FXCollections.observableArrayList();

        try {

            listData.addAll(personasCrud.listar());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listData;
    }

    private ObservableList<Persona> addPersonaListData;

    public void addStudentDisplayData() {
        addPersonaListData = addPersonaGetData();
        addPersonaColPersonaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        addPersonaColPersonaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        addPersonaColPersonaApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        addPersonaColPersonaTipoDni.setCellValueFactory(new PropertyValueFactory<>("tipoDoc"));
        addPersonaColPersonaDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        addPersonaColPersonaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        addPersonaColPersonaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        addPersonaColPersonaTipo.setCellValueFactory(new PropertyValueFactory<>("tipoDePersona"));
        addPersonaColPersonaBday.setCellValueFactory(new PropertyValueFactory<>("bday"));


        addPersonasTableView.setItems(addPersonaListData);
    }

    public void addPersonaBtn() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/edu.unam.expedientesapp/CrearPersonas.fxml")));

            Stage stage = new Stage();
            stage.setScene(new Scene(root));

            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addStudentDisplayData();
    }


}
