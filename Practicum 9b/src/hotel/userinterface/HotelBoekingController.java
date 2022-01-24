package hotel.userinterface;

import hotel.model.Hotel;
import hotel.model.KamerType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.time.LocalDate;

public class HotelBoekingController {
    @FXML private TextField naam;
    @FXML private TextField adres;
    @FXML private DatePicker aankomstDatum;
    @FXML private DatePicker vertrekDatum;
    @FXML private ComboBox kamerType;


    ObservableList<KamerType> kamerTypes = FXCollections.observableArrayList(Hotel.getHotel().getKamerTypen());
    private Hotel hotel = Hotel.getHotel();

    public void initialize() {
        //aankomstDatum.setValue(LocalDate.now());
        kamerType.setItems(kamerTypes);
    }

    public void voegBoekingToe() {

    }

    public void reset(){
        naam.setText("");
        adres.setText("");
        aankomstDatum.getEditor().clear();
        vertrekDatum.getEditor().clear();
        kamerType.valueProperty().set(null);
    }
}