package com.JeffDev.UserInterface;

import com.JeffDev.model.Currency;
import com.JeffDev.model.Koers;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

public class TransferController {

    @FXML
    private Button selectTextFile;
    @FXML
    private ComboBox transferCurrency;
    @FXML
    private TextField koersInput;
    @FXML
    private Label koersText;
    @FXML
    private Label fileText;
    @FXML
    private Label fileSelected;


    private Koers transformer = Koers.getKoers();
    ObservableList<Currency> currencies = FXCollections.observableArrayList(transformer.getCurrencies());

    private File transformFile;


    public void initialize() {
        fileSelected.setVisible(false);
        fileText.setVisible(false);

        koersInput.setVisible(false);
        koersText.setVisible(false);

        currencies.add(new Currency("Anders"));
        transferCurrency.setItems(currencies);

        koersInput.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*(\\.\\d*)?")) {
                    koersInput.setText(oldValue);
                }
            }
        });
    }

    private boolean validateFile(File file) {
        if (file != null) {
            return true;
        }
        return false;
    }

    private boolean validateKoers() {
        if (Objects.equals(transferCurrency.getSelectionModel().getSelectedItem().toString(), "Anders") && koersInput.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Melding");
            alert.setHeaderText(null);
            alert.setContentText("Vul een koerswaarde in");
            alert.showAndWait();
        }

        if (Objects.equals(transferCurrency.getSelectionModel().getSelectedItem().toString(), "Anders") && !koersInput.getText().isEmpty()){
            currencies.get(transferCurrency.getSelectionModel().getSelectedIndex()).setPrice(Double.parseDouble(koersInput.getText()));
            return true;
        } else if (transferCurrency.getSelectionModel().getSelectedItem() != null && !Objects.equals(transferCurrency.getSelectionModel().getSelectedItem().toString(), "Anders")) {
            return true;
        }
        return false;
    }

    public void transform(ActionEvent event) throws IOException {
        if (validateFile(transformFile) && validateKoers()) {
            System.out.println("Transform data to " + transferCurrency.getSelectionModel().getSelectedItem());

            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            fileChooser.getExtensionFilters().add(extFilter);


            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            File directoryPath = fileChooser.showSaveDialog(stage);
            List<String> alleTxt = Files.readAllLines(transformFile.toPath());

            BufferedWriter writer = Files.newBufferedWriter(directoryPath.toPath());
            if (Objects.equals(transferCurrency.getSelectionModel().getSelectedItem().toString(), "Anders") && !koersInput.getText().isEmpty()) {
                currencies.get(transferCurrency.getSelectionModel() .getSelectedIndex()).setPrice(Double.parseDouble(koersInput.getText()));
            }
            for (String regel : alleTxt) {

                if (regel.contains(":")) {
                    String[] strings = regel.split(":");
                    double dollars = Double.parseDouble(strings[1]);

                    double price = dollars / currencies.get(transferCurrency.getSelectionModel().getSelectedIndex()).getPrice();
                    DecimalFormat f = new DecimalFormat("#0.00");
                    String newPrice = f.format(price).replace(",",".");

                    writer.append(strings[0]).append(" : ").append(newPrice).append("\n");
                    writer.flush();


                } else {
                    throw new IllegalArgumentException("String " + regel + " does not contain :");
                }
            }
            writer.close();
            System.out.println("transformation done");
        }
    }

    public void selectTextFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);

        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        transformFile = fileChooser.showOpenDialog(stage);

        if (validateFile(transformFile)) {
            fileSelected.setVisible(true);
            fileText.setVisible(true);
            fileText.setText(transformFile.getName());

        } else {
            fileSelected.setVisible(false);
            fileText.setVisible(false);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Melding");
            alert.setHeaderText(null);
            alert.setContentText("Bestand niet geselecteerd");
            alert.showAndWait();
        }

    }


    public void checkSelection(ActionEvent event) {
        if (Objects.equals(transferCurrency.getValue().toString(), "Anders")) {
            koersInput.setVisible(true);
            koersText.setVisible(true);
        } else {
            koersInput.setVisible(false);
            koersText.setVisible(false);
        }
    }
}