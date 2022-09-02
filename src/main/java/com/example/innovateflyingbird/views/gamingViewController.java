package com.example.innovateflyingbird.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class gamingViewController {

    @FXML
    private Button exitBtn;

    @FXML
    private ImageView gameLogo;

    @FXML
    private Button gameStartBtn;

    @FXML
    private AnchorPane mainMenu;

    @FXML
    void exitButton(ActionEvent event) {
        Stage stage=(Stage) exitBtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    void gameStart(ActionEvent event) {

    }

}
