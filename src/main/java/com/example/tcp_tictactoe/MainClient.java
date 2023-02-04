package com.example.tcp_tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClient extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("GUI_Client_TicTacToe.fxml"));
        primaryStage.setTitle("Player 2: Tic Tac Toe!");
        primaryStage.setScene(new Scene(root, 800, 650));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}