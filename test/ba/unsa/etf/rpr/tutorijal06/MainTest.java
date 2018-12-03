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
}