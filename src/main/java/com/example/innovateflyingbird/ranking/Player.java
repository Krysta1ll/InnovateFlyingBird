package com.example.innovateflyingbird.ranking;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {
    final StringProperty userName_rank;
    final StringProperty score_rank;

    public StringProperty userNameProperty(){
        return userName_rank;
    }
    public StringProperty scoreProperty(){
        return score_rank;
    }

    public Player(String name,String score){
        this.userName_rank=new SimpleStringProperty(name);
        this.score_rank=new SimpleStringProperty(score);

    }}