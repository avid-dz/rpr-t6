package ba.unsa.etf.rpr.tutorijal06;

import com.sun.javafx.scene.control.skin.ChoiceBoxSkin;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField ime;
    public TextField prezime;
    public TextField jmbg;
    public TextField brojIndexa;
    public Button potvrdjivanje;
    public CheckBox borackaKategorija;
    public ToggleGroup grupaIzboraStatusa;
    public RadioButton redovan;
    public RadioButton samofinansirajuci;
    public ChoiceBox godinaStudija;
    public ChoiceBox odsjek;
    public ChoiceBox ciklusStudija;
    public TextField eMail;
    public TextField kontaktAdresa;
    public TextField kontaktTelefon;
    public ComboBox mjestoRodjenja;
    public DatePicker datumRodjenja;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mjestoRodjenja.setItems(FXCollections.observableArrayList("Sarajevo", "Tuzla", "Mostar", "Brcko", "Trebinje", "Zenica", "Banja Luka"));
        mjestoRodjenja.getSelectionModel().selectFirst();
        ciklusStudija.setItems(FXCollections.observableArrayList("Bachelor", "Master", "Doktorski studij", "Strucni studij"));
        ciklusStudija.getSelectionModel().selectFirst();
        godinaStudija.setItems(FXCollections.observableArrayList("Prva", "Druga", "Treca"));
        godinaStudija.getSelectionModel().selectFirst();
        odsjek.setItems(FXCollections.observableArrayList("Elektroenergetika", "Autoamtika i elektronika", "Racunarstvo i informatika", "Telekomunikacije"));
        odsjek.getSelectionModel().selectFirst();

        ime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String o, String n) {
                if (validnoIme(n)) {
                    ime.getStyleClass().removeAll("invalidField");
                    ime.getStyleClass().add("validField");
                } else {
                    ime.getStyleClass().removeAll("validField");
                    ime.getStyleClass().add("invalidField");
                }
            }
        });
        prezime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String o, String n) {
                if (validnoPrezime(n)) {
                    prezime.getStyleClass().removeAll("invalidField");
                    prezime.getStyleClass().add("validField");
                } else {
                    prezime.getStyleClass().removeAll("validField");
                    prezime.getStyleClass().add("invalidField");
                }
            }
        });
        brojIndexa.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String o, String n) {
                if (validanIndex(n)) {
                    brojIndexa.getStyleClass().removeAll("invalidField");
                    brojIndexa.getStyleClass().add("validField");
                } else {
                    brojIndexa.getStyleClass().removeAll("validField");
                    brojIndexa.getStyleClass().add("invalidField");
                }
            }
        });
        jmbg.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String o, String n) {
                if (validanJMBG(n)) {
                    jmbg.getStyleClass().removeAll("invalidField");
                    jmbg.getStyleClass().add("validField");
                } else {
                    jmbg.getStyleClass().removeAll("validField");
                    jmbg.getStyleClass().add("invalidField");
                }
            }
        });
        jmbg.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String o, String n) {
                if (validanJMBG(n)) {
                    jmbg.getStyleClass().removeAll("invalidField");
                    jmbg.getStyleClass().add("validField");
                } else {
                    jmbg.getStyleClass().removeAll("validField");
                    jmbg.getStyleClass().add("invalidField");
                }
            }
        });
        eMail.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String o, String n) {
                if (validanEMail(n)) {
                    eMail.getStyleClass().removeAll("invalidField");
                    eMail.getStyleClass().add("validField");
                } else {
                    eMail.getStyleClass().removeAll("validField");
                    eMail.getStyleClass().add("invalidField");
                }
            }
        });
    }

    public void potvrdaUpisa(ActionEvent actionEvent) {
        System.out.println("Informacije o upisanom studentu:");
        System.out.println("Ime i prezime: " + ime.getText() + prezime.getText());
        System.out.println("Index: " + brojIndexa.getText());
        System.out.println("JMBG: " + jmbg.getText());
        System.out.println("Datum rodjenja: " + datumRodjenja.getValue());
        System.out.println("Grad rodjenja: " + mjestoRodjenja.getSelectionModel().getSelectedItem());
        System.out.println("Adresa: " + kontaktAdresa.getText());
        System.out.println("Telefon: " + kontaktTelefon.getText());
        System.out.println("email: " + eMail.getText());
        System.out.println("Odsjek: " + odsjek.getSelectionModel().getSelectedItem());
        System.out.println("Godina: " + godinaStudija.getSelectionModel().getSelectedItem());
        System.out.println("Ciklus: " + ciklusStudija.getSelectionModel().getSelectedItem());
        if (redovan.isSelected()) System.out.println("Status: redovni");
        else System.out.println("Status: redovni samofinansirajuci");
        if (borackaKategorija.isSelected()) System.out.println("Pripada borackim kategorijama.");
        else System.out.println("Ne pripada borackim kategorijama.");
    }

    private boolean validnoIme(String n) {
        if (n.trim().equals("")) return false;
        if (!(n.charAt(0) >= 65 && n.charAt(0) <= 90)) return false;
        if(n.length() > 20) return false;
        for (int i=1; i < n.length(); i++){
            if (!(n.charAt(i)>=97 && n.charAt(i)<=122)) return false;
        }
        return true;
    }
    private boolean validnoPrezime(String n) {
        if (n.trim().equals("")) return false;
        if (!(n.charAt(0) >= 65 && n.charAt(0) <= 90)) return false;
        if(n.length() > 20) return false;
        for (int i=1; i < n.length(); i++){
            if (!(n.charAt(i)>=97 && n.charAt(i)<=122)) return false;
        }
        return true;
    }
    private boolean validanIndex(String n) {
        int broj;
        try {
            broj = Integer.parseInt(n);
            if (broj < 10000 ||broj > 99999) return false;

        } catch (Exception e) { //  ako uopste ne moze u int
            return false;
        }
        return  true;
    }
    private boolean validanJMBG(String n) {
        if (n.length() != 13) return false;
        return true;
    }
    private boolean validanEMail(String n) {
        if (!n.contains("@")) return false;
        if (!n.contains(".")) return false;
        boolean imaTackePoslijeLudogA = false;
        int i = 0;
        for (i = 0; i < n.length(); i++) {
            if (n.charAt(i) != '@') continue;
            else break;
        }
        i++;
        int j = i;
        while (j < n.length()) {
            if (n.charAt(j) == '@') return false;
            j++;
        }
        while (i < n.length()) {
            if (n.charAt(i) == '.') {
                imaTackePoslijeLudogA = true;
                break;
            }
            i++;
        }
        if (!imaTackePoslijeLudogA) return false;
        if (!Character.isLetter(n.charAt(n.length() - 1))) return false;
        return true;
    }
}
