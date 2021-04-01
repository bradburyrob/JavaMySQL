package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * The class is used to instantiate alerts from
 */


public class Alert
{

    String title;
    String message;
    static boolean answer;

    /**
     *This method is used to prompt the user with a decision. One lambda is tied to the "Yes" option and
     * another lambda is tied to the "No" option. This approach made it easier on me as I did not have to write an
     * entire function/method to the the functionality required
     */
        public  boolean display(String title, String message) {

            Stage window1 = new Stage();
            window1.initModality(Modality.APPLICATION_MODAL);
            window1.setTitle(title);
            window1.setMinWidth(250);
            Label label1 = new Label();
            label1.setText(message);

            //Creating 2 buttons
            Button yesButton = new Button("yes");
            Button noButton = new Button("no");

            yesButton.setOnAction(event -> {
                answer = true;
                window1.close();
            });
            noButton.setOnAction(event -> {
                answer = false;
                window1.close();
            });


            VBox myLayout = new VBox(10);
            myLayout.getChildren().addAll(label1, yesButton, noButton);
            myLayout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(myLayout);
            window1.setScene(scene);
            window1.showAndWait();
            return answer;

        }


            public  void wrongPassword(String title, String message)
            {
                Stage window2 = new Stage();
                window2.initModality(Modality.APPLICATION_MODAL);
                window2.setTitle(title);
                window2.setMinWidth(250);
                Label label2 = new Label();
                label2.setText(message);

                VBox wrongLogin = new VBox(10);
                wrongLogin.getChildren().addAll(label2);
                wrongLogin.setAlignment(Pos.CENTER);
                Scene wrongPass = new Scene(wrongLogin);
                window2.setScene(wrongPass);
                window2.showAndWait();
    }

    /**
     *This method uses another lambda expression, this time to confirm the closing of a given window/scene. The reasoning here was to reduce and simplify coding
     */
    public static void correctData(String title, String message)
    {
        Stage window1 = new Stage();
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setTitle(title);
        window1.setMinWidth(250);

        Label label1 = new Label();
        label1.setText(message);
        Button closeButton = new Button("OK");
        closeButton.setOnAction(event -> window1.close());

        VBox myLayout = new VBox(10);
        myLayout.getChildren().addAll(label1, closeButton);
        myLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(myLayout,400,250);
        window1.setScene(scene);
        window1.showAndWait();

    }

}
