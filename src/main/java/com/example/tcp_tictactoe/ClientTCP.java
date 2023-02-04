package com.example.tcp_tictactoe;

import javafx.fxml.Initializable;
import javafx.scene.Scene;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientTCP {

    private Socket socket;
    private DataInputStream dataIn;
    private DataOutputStream dataOut;


    public  ClientTCP(Socket socket){

        try{

            this.socket = socket;

            InputStream in = socket.getInputStream();
            this.dataIn = new DataInputStream(in);

            OutputStream out = socket.getOutputStream();
            this.dataOut = new DataOutputStream(out);


        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR CONECTANDO AL SERVIDOR");
            CloseAll(socket, dataOut, dataIn);
        }

    }

    public void reciveMove(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                while(socket.isConnected()){
                    try{
                        // Primero recibimos el movimiento del oponente.
                        int row = dataIn.readInt();
                        int col = dataIn.readInt();
                        int[] move = {row, col};
                        System.out.println("Movimiento recibido: "+move.toString());

                        // Actualizamos la GUI con el método del controlador que nos lo permite.
                        Controller_Client_TicTacToe.ActualizarMovimiento(row, col);

                    }catch (IOException e){
                        e.printStackTrace();
                        System.out.println("ERROR RECIBIENDO EL MOVIMIENTO");
                        CloseAll(socket, dataOut, dataIn);
                        break;
                    }
                }

            }
        }).start();

    }

    public void sendMove(int row, int col){
        try{
            dataOut.writeInt(row);
            dataOut.writeInt(col);
            System.out.println("Enviando movimiento al jugador 1. Movimiento: "+row+" "+col);
            dataOut.flush();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR AL ENVIAR EL MOVIMIENTO.");
            CloseAll(socket,dataOut,dataIn);
        }
    }


    public void CloseAll(Socket socket, DataOutputStream dataOut, DataInputStream dataIn){

        try{
            if(socket != null){
                socket.close();
            }
            if(dataOut != null){
                dataOut.close();
            }
            if(dataIn != null){
                dataIn.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR CERRANDO LOS SOCKET/DATA_STREAMS");
        }

    }



}
