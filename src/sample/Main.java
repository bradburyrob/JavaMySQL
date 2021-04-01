package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;
import java.util.*;
import java.util.ResourceBundle;
/**
 * This is the Main Class, the only logic we have here is the language loading option
 */

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

            Locale currentLocale = Locale.getDefault();
            Locale FrechLang = new Locale("fr_FR");

        Locale locale = Locale.getDefault();

        if (locale.toString().contains("en")) {

            ResourceBundle bundle = ResourceBundle.getBundle("sample/login", currentLocale );
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("login.fxml"), bundle);
            primaryStage.setTitle("C195_JAVA II");
            primaryStage.setScene(new Scene(root, 680, 400));
            primaryStage.show();

        } else if (locale.toString().contains("fr")) {

            ResourceBundle bundle = ResourceBundle.getBundle("sample/login_fr_FR", FrechLang );
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(getClass().getResource("login.fxml"), bundle);
            primaryStage.setTitle("C195_JAVA II");
            primaryStage.setScene(new Scene(root, 680, 400));
            primaryStage.show();
        }



    }


    public static void main(String[] args) {
        launch(args);
    }

}
