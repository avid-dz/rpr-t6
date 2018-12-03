package ba.unsa.etf.rpr.tutorijal06;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import org.junit.jupiter.api.Test;

@ExtendWith(ApplicationExtension.class)
class MainTest {

    @Start
    public void start (Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("sample.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void testPoljaZaIme(FxRobot robot) {
        TextField imeField = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn("#ime");
        assertAll("Test vise varijanti ispravnog i neispravnog imena",
                () -> {
                    robot.write("Dzavid");
                    assertTrue(imeField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.write(" ");
                    assertTrue(imeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    robot.write("S razmakom");
                    assertTrue(imeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    for (int i = 0; i < 11; i++) robot.type(KeyCode.BACK_SPACE);
                    assertTrue(imeField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.write("321_");
                    assertTrue(imeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (imeField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    robot.write("svemalaslova");
                    assertTrue(imeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (imeField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    assertTrue(imeField.getStyleClass().contains("invalidField"));
                }
        );
    }

    @Test
    public void testPoljaZaPrezime(FxRobot robot) {
        TextField prezimeField = robot.lookup("#prezime").queryAs(TextField.class);
        robot.clickOn("#prezime");
        assertAll("Test vise varijanti ispravnog i neispravnog prezimena",
                () -> {
                    robot.write("Brdar");
                    assertTrue(prezimeField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.write(" ");
                    assertTrue(prezimeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    robot.write("S razmakom");
                    assertTrue(prezimeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    for (int i = 0; i < 11; i++) robot.type(KeyCode.BACK_SPACE);
                    assertTrue(prezimeField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.write("321_");
                    assertTrue(prezimeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (prezimeField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    robot.write("svemalaslova");
                    assertTrue(prezimeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (prezimeField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    assertTrue(prezimeField.getStyleClass().contains("invalidField"));
                }
        );
    }

    @Test
    public void testPoljaZaBrojIndexa(FxRobot robot) {
        TextField prezimeField = robot.lookup("#brojIndexa").queryAs(TextField.class);
        robot.clickOn("#brojIndexa");
        assertAll("Test vise varijanti ispravnog i neispravnog broja indexa",
                () -> {
                    robot.write("18182");
                    assertTrue(prezimeField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.write(" ");
                    assertTrue(prezimeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    robot.write("Sa slovima");
                    assertTrue(prezimeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    for (int i = 0; i < 11; i++) robot.type(KeyCode.BACK_SPACE);
                    assertTrue(prezimeField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.write("321_");
                    assertTrue(prezimeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    robot.type(KeyCode.BACK_SPACE);
                    assertTrue(prezimeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (prezimeField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    robot.write("sveSlova");
                    assertTrue(prezimeField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (prezimeField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    assertTrue(prezimeField.getStyleClass().contains("invalidField"));
                }
        );
    }

    @Test
    public void testPoljaZaJMBG(FxRobot robot) {
        TextField jmbgField = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.clickOn("#jmbg");
        assertAll("Test vise varijanti ispravnog i neispravnog maticnog broja",
                () -> {
                    robot.write("3005998130002");
                    assertTrue(jmbgField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.write(" ");
                    assertTrue(jmbgField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    robot.type(KeyCode.BACK_SPACE);
                    robot.write("+slova");
                    assertTrue(jmbgField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    for (int i = 0; i < 6; i++) robot.type(KeyCode.BACK_SPACE);
                    assertTrue(jmbgField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.write("321_");
                    assertTrue(jmbgField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    robot.type(KeyCode.BACK_SPACE);
                    assertTrue(jmbgField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (jmbgField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    robot.write("sveSlova");
                    assertTrue(jmbgField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (jmbgField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    assertTrue(jmbgField.getStyleClass().contains("invalidField"));
                }
        );
    }

    @Test
    public void testPoljaZaAdresu(FxRobot robot) {
        TextField adresaField = robot.lookup("#kontaktAdresa").queryAs(TextField.class);
        robot.clickOn("#kontaktAdresa");
        assertAll("Test vise varijanti ispravne i neispravne kontakt adrese",
                () -> {
                    robot.write("Kromolj 64");
                    assertTrue(adresaField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.write(" ");
                    assertTrue(adresaField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.type(KeyCode.BACK_SPACE);
                    assertTrue(adresaField.getStyleClass().contains("validField"));
                },
                () -> {
                    while (adresaField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    robot.write("Zmaja od Bosne b.b.");
                    assertTrue(adresaField.getStyleClass().contains("validField"));
                },
                () -> {
                    while (adresaField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    assertTrue(adresaField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.write("643");
                    assertTrue(adresaField.getStyleClass().contains("invalidField"));
                }
        );
    }

    @Test
    public void testPoljaZaTelefon(FxRobot robot) {
        TextField telefonField = robot.lookup("#kontaktTelefon").queryAs(TextField.class);
        robot.clickOn("#kontaktTelefon");
        assertAll("Test vise varijanti ispravnog i neispravnog kontakt telefona",
                () -> {
                    robot.write("062/942-872");
                    assertTrue(telefonField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.write(" ");
                    assertTrue(telefonField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    robot.type(KeyCode.BACK_SPACE);
                    assertTrue(telefonField.getStyleClass().contains("validField"));
                },
                () -> {
                    while (telefonField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    robot.write("slova umjesto broja");
                    assertTrue(telefonField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (telefonField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    assertTrue(telefonField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.write("0622/942-872");
                    assertTrue(telefonField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (telefonField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    robot.write("062/9422-872");
                    assertTrue(telefonField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (telefonField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    robot.write("062/942-8722");
                    assertTrue(telefonField.getStyleClass().contains("validField"));
                },
                () -> {
                    robot.type(KeyCode.BACK_SPACE);
                    robot.write("_.");
                    assertTrue(telefonField.getStyleClass().contains("invalidField"));
                }
        );
    }

    @Test
    public void testPoljaZaEmail(FxRobot robot) {
        TextField eMailField = robot.lookup("#eMail").queryAs(TextField.class);
        robot.clickOn("#eMail");
        assertAll("Test vise varijanti ispravnog i neispravnog emaila",
                () -> {
                    robot.write("dbrdar1@etf.unsa.ba");
                    assertTrue(eMailField.getStyleClass().contains("validField"));
                },
                () -> {
                    while (eMailField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    robot.write("slova bez ludog a");
                    assertTrue(eMailField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (eMailField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    assertTrue(eMailField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    robot.write("0622/942-872");
                    assertTrue(eMailField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (eMailField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    robot.write("dbrdar1@etf@unsa.ba");
                    assertTrue(eMailField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (eMailField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    robot.write("dbrdar1.etf.unsa.ba");
                    assertTrue(eMailField.getStyleClass().contains("invalidField"));
                },
                () -> {
                    while (eMailField.getText().length() != 0) robot.type(KeyCode.BACK_SPACE);
                    robot.write("dbrdar1_etf@etfunsaba");
                    assertTrue(eMailField.getStyleClass().contains("invalidField"));
                }
        );
    }
}