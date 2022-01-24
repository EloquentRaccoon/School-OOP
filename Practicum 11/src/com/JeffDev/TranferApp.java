package com.JeffDev;

import java.util.ArrayList;
import java.util.List;

import com.JeffDev.model.Currency;
import com.JeffDev.model.Koers;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TranferApp extends Application {
    public static void main(String[] args) throws Exception {


        List<Currency> currencies = new ArrayList<>();
        currencies.add(new Currency("EUR", 0.871341));
        currencies.add(new Currency("GBP", 0.727717));
        currencies.add(new Currency("INR", 73.862915));
        currencies.add(new Currency("JPY", 114.270661));

        Koers koerslijst = new Koers(currencies);


        Koers.setKoers(koerslijst);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlPagina = "UserInterface/TransferApp.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPagina));
        Parent root = loader.load();

        stage.setTitle("TransferApp");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
