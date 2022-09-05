package com.example.innovateflyingbird.views;

import com.example.innovateflyingbird.dao.UserDAO;
import com.example.innovateflyingbird.ranking.Player;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class rankingController implements Initializable{






        @FXML
    private TableView<Player> rankingList;

    @FXML
    private TableColumn<Player, String> scoreCol;

    @FXML
    private TableColumn<Player, String> userNameCol;

    String[] userName = new String[1024];
    String[] score = new String[1024];

    @FXML
    void refresh(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
UserDAO userDAO=new UserDAO();
userDAO.getInfo_rank("userName",userName);
userDAO.getInfo_rank("highestScore",score);
        ObservableList<Player>data= FXCollections.observableArrayList();

int i=0;
while(userName[i]!=null&&score[i]!=null){
    data.add(new Player(userName[i],score[i]));
    i++;

}
 userNameCol.setCellValueFactory(cellData->cellData.getValue().userNameProperty());
        scoreCol.setCellValueFactory(cellData->cellData.getValue().scoreProperty());
rankingList.setItems(data);
rankingList.getItems().addAll();
System.out.println("数据已存入");


    }
}


