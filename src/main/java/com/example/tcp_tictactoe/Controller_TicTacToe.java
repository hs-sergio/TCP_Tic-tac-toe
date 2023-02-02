package com.example.tcp_tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

public class Controller_TicTacToe {
    @FXML
    private Label statusLabel;

    @FXML
    private Button btn00;
    @FXML
    private Button btn10;
    @FXML
    private Button btn20;
    @FXML
    private Button btn01;
    @FXML
    private Button btn11;
    @FXML
    private Button btn21;
    @FXML
    private Button btn02;
    @FXML
    private Button btn12;
    @FXML
    private Button btn22;

    @FXML
    private GridPane Tablero;

    boolean turno = true;
    String tablero[][] = new String[3][3];

    @FXML
    public void ClickEvent(){
        // Evento onClick que controla que botón se pulsa y controla los turnos.
        btn00.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(turno){
                    btn00.setText("X");
                }else{
                    btn00.setText("O");
                }
                btn00.setDisable(true);

                tablero[0][0] = btn00.getText();
                turno = !turno;
            }
        });

        btn10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(turno){
                    btn10.setText("X");
                }else{
                    btn10.setText("O");
                }
                btn10.setDisable(true);

                tablero[0][1] = btn10.getText();
                turno = !turno;
            }
        });

        btn20.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(turno){
                    btn20.setText("X");
                }else{
                    btn20.setText("O");
                }
                btn20.setDisable(true);

                tablero[0][2] = btn20.getText();
                turno = !turno;
            }
        });
    }


    public void checkWin(){

    }

    public void changeTurn(){
        if(turno){
            statusLabel.setText("Turno de las X");
        }else{
            statusLabel.setText("Turno de las O");
        }
    }




}
