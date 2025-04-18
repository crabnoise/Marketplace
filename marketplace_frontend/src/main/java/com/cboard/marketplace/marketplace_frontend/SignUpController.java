package com.cboard.marketplace.marketplace_frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;

import java.io.IOException;

public class SignUpController {
    private Button signUpButton;

    @FXML
    public void signUpButtonClicked(javafx.event.ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SignUpController.class.getResource("mainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        MainPageController mainPageController = fxmlLoader.getController();
        mainPageController.populate(actionEvent);
        stage.setScene(scene);

        stage.show();

    }


}
