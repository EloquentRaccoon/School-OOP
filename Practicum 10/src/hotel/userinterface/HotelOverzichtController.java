package hotel.userinterface;

import hotel.model.Boeking;
import hotel.model.Hotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;

public class HotelOverzichtController {
    @FXML private Label hotelnaamLabel;
    @FXML private ListView boekingenListView;
    @FXML private DatePicker overzichtDatePicker;

    private Hotel hotel = Hotel.getHotel();


    public void initialize() {
        hotelnaamLabel.setText("Boekingen hotel " + hotel.getNaam());
        overzichtDatePicker.setValue(LocalDate.now());
        toonBoekingen();
    }

    public void toonVorigeDag(ActionEvent actionEvent) {
        LocalDate dagEerder = overzichtDatePicker.getValue().minusDays(1);
        overzichtDatePicker.setValue(dagEerder);
    }

    public void toonVolgendeDag(ActionEvent actionEvent) {
        LocalDate dagLater = overzichtDatePicker.getValue().plusDays(1);
        overzichtDatePicker.setValue(dagLater);
    }

    public void nieuweBoeking(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HotelBoeking.fxml"));
        Parent root = loader.load();

        Stage boeking = new Stage();
        boeking.setScene(new Scene(root));
        boeking.initModality(Modality.APPLICATION_MODAL);
        boeking.showAndWait();
        initialize();
    }

    public void toonBoekingen() {
        ObservableList<String> boekingen = FXCollections.observableArrayList();
        for (int i = 0; i < hotel.getBoekingen().size(); i++ ) {
            Boeking boeking = hotel.getBoekingen().get(i);

            if (Objects.equals(boeking.getAankomstDatum(), overzichtDatePicker.getValue())){
                boekingen.add(String.format("van: %s tot: %s, Kamer: %s\nGeboekt door: %s\n", boeking.getAankomstDatum(), boeking.getVertrekDatum(), boeking.getKamer().getKamerNummer(), boeking.getBoeker().getNaam()));
            }
        }
        boekingenListView.setItems(boekingen);
    }
}