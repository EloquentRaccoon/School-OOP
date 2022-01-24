package hotel.userinterface;

import hotel.model.Hotel;
import hotel.model.KamerType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javafx.stage.Stage;


public class HotelBoekingController {
    @FXML
    private TextField naam;
    @FXML
    private TextField adres;
    @FXML
    private DatePicker aankomstDatum;
    @FXML
    private DatePicker vertrekDatum;
    @FXML
    private ComboBox kamerType;

    private Hotel hotel = Hotel.getHotel();
    ObservableList<KamerType> kamerTypes = FXCollections.observableArrayList(hotel.getKamerTypen());


    public void initialize() {
        kamerType.setItems(kamerTypes);
    }

    public void voegBoekingToe(ActionEvent event) throws Exception {
        //check validations
        if (validateFields()) {
            //create hotel boeking
            try {
                hotel.voegBoekingToe(aankomstDatum.getValue(), vertrekDatum.getValue(), naam.getText(), adres.getText(), (KamerType) kamerType.getValue());
                //create alert to let user know boeking is succesful
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Melding");
                alert.setHeaderText(null);
                alert.setContentText("Uw boeking is gemaakt");
                alert.showAndWait();
                //exit boeking window
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                //create alert to let user know boeking is succesful
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning");
                alert.setHeaderText(null);
                alert.setContentText("Op die datum is er geen "+ ((KamerType) kamerType.getValue()).getTypeNaam() +" kamer beschrikbaar!");
                alert.showAndWait();
            }
        }
    }

    public void reset() {
        naam.setText(null);
        adres.setText(null);
        aankomstDatum.getEditor().clear();
        vertrekDatum.getEditor().clear();
        kamerType.valueProperty().set(null);
    }

    private boolean validateFields() {
        if (naam.getText().isEmpty() | adres.getText().isEmpty() |
                aankomstDatum.getEditor().getText().isEmpty() |
                vertrekDatum.getEditor().getText().isEmpty() |
                kamerType.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Vul alle velden in.");
            alert.showAndWait();
            return false;
        }
        return true;
    }
}

