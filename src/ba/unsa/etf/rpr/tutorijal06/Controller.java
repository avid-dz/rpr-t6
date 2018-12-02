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
import java.time.LocalDate;
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
    private int danIzJMBG;
    private int mjesecIzJMBG;
    private int godinaIzJMBG;

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
        kontaktAdresa.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String o, String n) {
                if (validnaAdresa(n)) {
                    kontaktAdresa.getStyleClass().removeAll("invalidField");
                    kontaktAdresa.getStyleClass().add("validField");
                } else {
                    kontaktAdresa.getStyleClass().removeAll("validField");
                    kontaktAdresa.getStyleClass().add("invalidField");
                }
            }
        });
        kontaktTelefon.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String o, String n) {
                if (validanTelefonskiBroj(n)) {
                    kontaktTelefon.getStyleClass().removeAll("invalidField");
                    kontaktTelefon.getStyleClass().add("validField");
                } else {
                    kontaktTelefon.getStyleClass().removeAll("validField");
                    kontaktTelefon.getStyleClass().add("invalidField");
                }
            }
        });
        datumRodjenja.valueProperty().addListener((old, o, n) -> {
            if (validanDatumRodjenja(n)) {
                datumRodjenja.getStyleClass().removeAll("invalidField");
                datumRodjenja.getStyleClass().add("validField");
            } else {
                datumRodjenja.getStyleClass().removeAll("validField");
                datumRodjenja.getStyleClass().add("invalidField");
            }
        });
    }

    public void potvrdaUpisa(ActionEvent actionEvent) {
        if (validnoIme(ime.getText()) && validnoPrezime(prezime.getText()) && validanEMail(eMail.getText())
                && validanIndex(brojIndexa.getText()) && validanTelefonskiBroj(kontaktTelefon.getText())
                && validanJMBG(jmbg.getText())) {
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
        else {
            prikazProzoraZaGresku(actionEvent);
        }
    }

    private boolean validnoIme(String n) {
        if (n.trim().equals("")) return false;
        if (n.length() > 20) return false;
        if (!(n.charAt(0) >= 65 && n.charAt(0) <= 90)) return false;
        for (int i = 1; i < n.length(); i++){
            if (!(n.charAt(i) >= 97 && n.charAt(i) <= 122)) return false;
        }
        return true;
    }
    private boolean validnoPrezime(String n) {
        if (n.trim().equals("")) return false;
        if (n.length() > 20) return false;
        if (!(n.charAt(0) >= 65 && n.charAt(0) <= 90)) return false;
        for (int i = 1; i < n.length(); i++){
            if (!(n.charAt(i) >= 97 && n.charAt(i) <= 122)) return false;
        }
        return true;
    }
    private boolean validanIndex(String n) {
        int broj;
        try {
            broj = Integer.parseInt(n);
            if (broj < 10000 || broj > 99999) return false;
        } catch (Exception e) { //  ako uopste ne moze u int
            return false;
        }
        return true;
    }
    private boolean validanJMBG(String n) {
        if (n.length() != 13) return false;
        for (int i = 0; i < n.length(); i++) {
            if (!Character.isDigit(n.charAt(i))) return false;
        }
        danIzJMBG = Integer.parseInt(n.substring(0, 2));
        mjesecIzJMBG = Integer.parseInt(n.substring(2, 4));
        godinaIzJMBG = Integer.parseInt(n.substring(4, 7));
        int a = Integer.parseInt(n.substring(0, 1));
        int b = Integer.parseInt(n.substring(1, 2));
        int v = Integer.parseInt(n.substring(2, 3));
        int g = Integer.parseInt(n.substring(3, 4));
        int d = Integer.parseInt(n.substring(4, 5));
        int dj = Integer.parseInt(n.substring(5, 6));
        int e = Integer.parseInt(n.substring(6, 7));
        int zh = Integer.parseInt(n.substring(7, 8));
        int z = Integer.parseInt(n.substring(8, 9));
        int i = Integer.parseInt(n.substring(9, 10));
        int j = Integer.parseInt(n.substring(10, 11));
        int k = Integer.parseInt(n.substring(11, 12));
        int l = Integer.parseInt(n.substring(12, 13));
        if (l != 11 - ((7 * (a + e) + 6 * (b + zh) + 5 * (v + z) + 4 * (g + i) + 3 * (d + j) + 2 * (dj + k)) % 11)
                && l != 0)
            return false;
        return true;
    }
    private boolean validanEMail(String n) {
        if (n.trim().equals("")) return false;
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
    private boolean validnaAdresa(String n) {
        if (n.trim().equals("")) return true;
        if (!Character.isLetter(n.charAt(0))) return false;
        return true;
    }
    private boolean validanTelefonskiBroj(String n) {
        if (n.trim().equals("")) return true;
        int duzina = n.length();
        if (duzina != 12 && duzina != 11) return false;
        for (int i = 0; i < duzina; i++) {
            if (Character.isLetter(n.charAt(i))) return false;
        }
        try {
            if (duzina == 11) {
                Integer.parseInt(n.substring(0, 3));
                char kosaCrta = n.charAt(3);
                Integer.parseInt(n.substring(4, 7));
                char crtica = n.charAt(7);
                Integer.parseInt(n.substring(8, 11));
                if (kosaCrta != '/') return false;
                if (crtica != '-') return false;
            }
            if (duzina == 12) {
                Integer.parseInt(n.substring(0, 3));
                char kosaCrta = n.charAt(3);
                Integer.parseInt(n.substring(4, 7));
                char crtica = n.charAt(7);
                Integer.parseInt(n.substring(8, 12));
                if (kosaCrta != '/') return false;
                if (crtica != '-') return false;
            }
        } catch (Exception greska) {
            return false;
        }
        return true;
    }
    private boolean validanDatumRodjenja(LocalDate n) {
        if (n.isAfter(LocalDate.now())) return false;
        if (n.getDayOfMonth() != danIzJMBG) return false;
        if (n.getMonthValue() != mjesecIzJMBG) return false;
        if ((n.getYear() % 1000) != godinaIzJMBG) return false;
        return true;
    }

    private void prikazProzoraZaGresku(ActionEvent actionEvent){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Neispravni podaci.");
        alert.setContentText("Molimo popunite formular sa validnim podacima, a zatim kliknite \"Potvrdi\".");
        alert.show();
    }
}
