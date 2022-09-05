package com.example.innovateflyingbird.views;

import com.example.innovateflyingbird.gaming.GameFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class gamingViewController implements Initializable {

    @FXML
    private Button exitBtn;

    @FXML
    private ImageView gameLogo;

    @FXML
    private Button gameStartBtn;

    @FXML
    private AnchorPane mainMenu;
    @FXML
    private Label userLabel;

    @FXML
    void exitButton(ActionEvent event) {
        Stage stage=(Stage) exitBtn.getScene().getWindow();
        stage.close();

    }


    @FXML
    void gameStart(ActionEvent event) {
        GameFrame frame = new GameFrame();
        frame.setVisible(true);
    }

    @FXML
    void rankingList(ActionEvent event) {
        Stage regStage=new Stage();
        try {
            AnchorPane anchorPane= FXMLLoader.load(this.getClass().getResource("Ranking.fxml"));
            Scene scene=new Scene(anchorPane);
            regStage.setScene(scene);
            regStage.setTitle("排行榜");
            regStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userLabel.setText(loginViewController.userName);
    }
}
