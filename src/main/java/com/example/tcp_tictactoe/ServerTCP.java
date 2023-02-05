package com.example.tcp_tictactoe;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream dataIn;
    private  DataOutputStream dataOut;

    public ServerTCP(ServerSocket serverSocket){

        try{

            this.serverSocket = serverSocket;
            this.socket = serverSocket.accept(); // Aceptamos a los clientes
            System.out.println("JUGADOR 2 CONECTADO");

            InputStream in = socket.getInputStream();
            this.dataIn = new DataInputStream(in);

            OutputStream out = socket.getOutputStream();
            this.dataOut = new DataOutputStream(out);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR CONECTANDO A CLIENTE");
            CloseAll(socket, dataOut, dataIn);
        }


    }

    public void reciveMove(int row, int col){

        new Thread(new Runnable() {
            @Override
            public void run() {

                while(socket.isConnected()){
                    try{
                        // Primero recibimos el movimiento del oponente.
                        int row = dataIn.readInt();
                        int col = dataIn.readInt();
                        System.out.println("Movimiento recibido: "+row+" "+col);

                        // Actualizamos la GUI con el método del controlador que nos lo permite.
                        Controller_Server_TicTacToe.ActualizarMovimiento(row, col);

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
            System.out.println("Enviando movimiento al jugador 2. Movimiento: "+row+" "+col);
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

            System.out.println("Cerrrando socket/dataOut/dataIn");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR CERRANDO LOS SOCKET/DATA_STREAMS");
        }

    }

}
