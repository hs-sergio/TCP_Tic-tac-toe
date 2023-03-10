package com.example.tcp_tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainServer extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("GUI_Server_TicTacToe.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("GUI_Server_TicTacToe.fxml"));
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Player 1: Tic Tac Toe!");
        primaryStage.setScene(new Scene(root, 800, 650));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}