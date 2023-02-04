package com.example.tcp_tictactoe;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller_Client_TicTacToe implements Initializable {

    @FXML
    private Label statusLabel;

    @FXML
    private Label LabelWinner;

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

    boolean turno;
    String tablero[][] = new String[3][3];


    private ClientTCP client;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            client = new ClientTCP(new Socket("localhost", 5555));
            System.out.println("CLIENTE CONECTADO CON EL SERVIDOR");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR CONECTANDO CON EL SERVIDOR");
        }


        btn00.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn00.setText("O");
                client.sendMove(0, 0);
                btn00.setDisable(true);

                tablero[0][0] = btn00.getText();
//                changeTurn();
                checkWin();


            }
        });

        btn10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn10.setText("O");
                client.sendMove(0, 1);
                btn10.setDisable(true);

                tablero[0][1] = btn10.getText();
                checkWin();


            }
        });

        btn20.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn20.setText("O");
                client.sendMove(0, 2);
                btn20.setDisable(true);

                tablero[0][2] = btn20.getText();
                checkWin();


            }
        });

        btn01.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                btn01.setText("O");
                client.sendMove(1, 0);
                btn01.setDisable(true);

                tablero[1][0] = btn01.getText();
                checkWin();


            }
        });

        btn11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                btn11.setText("O");
                client.sendMove(1, 1);
                btn11.setDisable(true);

                tablero[1][1] = btn11.getText();
                checkWin();


            }
        });

        btn21.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                btn21.setText("O");
                client.sendMove(1, 2);
                btn21.setDisable(true);

                tablero[1][2] = btn21.getText();
                checkWin();


            }
        });

        btn02.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                btn02.setText("O");
                client.sendMove(2, 0);
                btn02.setDisable(true);

                tablero[2][0] = btn02.getText();
                checkWin();

            }
        });

        btn12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                btn12.setText("O");
                client.sendMove(2, 1);
                btn12.setDisable(true);

                tablero[2][1] = btn12.getText();
                checkWin();


            }
        });

        btn22.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                btn22.setText("O");
                client.sendMove(2, 2);
                btn22.setDisable(true);

                tablero[2][2] = btn22.getText();
                checkWin();
            }
        });

    }


    private void checkWin() {
        // Comprobar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != null && tablero[i][0].equals(tablero[i][1]) && tablero[i][0].equals(tablero[i][2])) {
                LabelWinner.setText("GANADOR " + tablero[i][0]);
                Tablero.setDisable(true);
                System.out.println("Ha ganado: " + tablero[i][0]);
            }
        }

        // Comprobar columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] != null && tablero[0][i].equals(tablero[1][i]) && tablero[0][i].equals(tablero[2][i])) {
                LabelWinner.setText("GANADOR " + tablero[0][i]);
                Tablero.setDisable(true);
                System.out.println("Ha ganado: " + tablero[0][i]);

            }
        }

        // Comprobar diagonal
        if (tablero[0][0] != null && tablero[0][0].equals(tablero[1][1]) && tablero[0][0].equals(tablero[2][2])) {
            LabelWinner.setText("GANADOR " + tablero[0][0]);
            Tablero.setDisable(true);
            System.out.println("Ha ganado: " + tablero[0][0]);

        }

        if (tablero[0][2] != null && tablero[0][2].equals(tablero[1][1]) && tablero[0][2].equals(tablero[2][0])) {
            System.out.println(tablero[0][2] + " ha ganado!");
            LabelWinner.setText("GANADOR " + tablero[0][2]);
            Tablero.setDisable(true);
            System.out.println("Ha ganado: " + tablero[0][2]);

        }

    }

    public static void ActualizarMovimiento ( int row, int col){

        int[] move = {row, col};
        System.out.println("");
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
            }
        });

    }

}