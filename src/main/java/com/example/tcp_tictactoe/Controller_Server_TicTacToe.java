package com.example.tcp_tictactoe;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.URL;
import java.security.cert.PolicyNode;
import java.util.ResourceBundle;

public class Controller_Server_TicTacToe implements Initializable {
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
    private static GridPane Tablero;

    @FXML
    private static Pane pane;



    boolean turno;
    static String[][] tablero = new String[3][3];

    private static Button btn = new Button();


    private ServerTCP server;

    private int rowRecibidos;
    private int colRecibidos;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Iniciar la conexion

        ServerSocket serverSocket = null;



            try {
                server = new ServerTCP(new ServerSocket(5000));
                System.out.println("Servidor creado");

            } catch (IOException e) {
                System.out.println("Error creando el servidor");
                e.printStackTrace();

            }




        btn00.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn00.setText("X");
                server.sendMove(0, 0);
                btn00.setDisable(true);

                tablero[0][0] = btn00.getText();
//                changeTurn();
                checkWin();


            }
        });

        btn10.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn10.setText("X");
                server.sendMove(0, 1);
                btn10.setDisable(true);

                tablero[0][1] = btn10.getText();
                checkWin();


            }
        });

        btn20.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn20.setText("X");
                server.sendMove(0, 2);
                btn20.setDisable(true);

                tablero[0][2] = btn20.getText();
                checkWin();


            }
        });

        btn01.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                btn01.setText("X");
                server.sendMove(1, 0);
                btn01.setDisable(true);

                tablero[1][0] = btn01.getText();
                checkWin();


            }
        });

        btn11.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                btn11.setText("X");
                server.sendMove(1, 1);
                btn11.setDisable(true);

                tablero[1][1] = btn11.getText();
                checkWin();


            }
        });

        btn21.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                btn21.setText("X");
                server.sendMove(1, 2);
                btn21.setDisable(true);

                tablero[1][2] = btn21.getText();
                checkWin();


            }
        });

        btn02.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                btn02.setText("X");
                server.sendMove(2, 0);
                btn02.setDisable(true);

                tablero[2][0] = btn02.getText();
                checkWin();

            }
        });

        btn12.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                btn12.setText("X");
                server.sendMove(2, 1);
                btn12.setDisable(true);

                tablero[2][1] = btn12.getText();
                checkWin();


            }
        });

        btn22.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                btn22.setText("X");
                server.sendMove(2, 2);
                btn22.setDisable(true);
                tablero[2][2] = btn22.getText();
                checkWin();
            }
        });


        // Recibimos el movimiento del oponente
        server.reciveMove(rowRecibidos, colRecibidos);


    }

//        server.reciveMove(int row, int col);

    public static void ActualizarMovimiento(int row, int col) {


        int[] move = {row, col};
        // Actualizamos el tablero con la información
        tablero[row][col] = "0";
        System.out.println(row);
        System.out.println(col);
        int pos = row + col;

        Button btn = (Button) Tablero.lookup("#btn00");
        System.out.println(btn.getId());

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("WERIWEIORWIOERIOW");





//                btnActu.setText("ASDASD");

                // Actualizar el tablero del servidor con el movimiento recibido
                // Aqui entra
                // Cargamos el tablero
//                FXMLLoader fxmlLoader = new FXMLLoader();
//                try {
//                    fxmlLoader.load((getClass().getResource("GUI_Server_TicTacToe.fxml")));
//                    Parent root = fxmlLoader.load();
//                    Tablero = (GridPane) root.lookup("#Tablero");
////                    btn = (Button) = null;
////                    btn.setId("#btn"+pos);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                for (Node node : Tablero.getChildren()) {
//                    System.out.println("holaola");    // Aqui  entra
//
//                    if (node instanceof Button) {
//                        btn.setId("#btn" + pos);
//                        btn.setText("aweba");
//                        System.out.println("Entra siquiera aqui?");
////                        btn = (Button) Tablero.lookup("#btn" + pos);
////                        System.out.println(btn);
////                        btn.setText("aweba");
////                        System.out.println("Entra siquiera aqui?");
//
////                        if(row == Tablero.getRowIndex(node) && col == Tablero.getColumnIndex(node)){
////                            Button btnMod = (Button)node;
////                            btnMod.setText("X");
////                            btnMod.setDisable(true);
////                        }
//
//                    }
//                }


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

    private void changeTurn() {
        if (turno) {
            statusLabel.setText("Turno de las X");
        } else {
            statusLabel.setText("Turno de las O");
        }
        turno = !turno;
    }


}
