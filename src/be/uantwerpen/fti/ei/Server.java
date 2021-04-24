package be.uantwerpen.fti.ei;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {
        int port = 5000; //we always use port 5000

        try (ServerSocket serverSocket = new ServerSocket(port)) { //Here we open a new port where clients can connect to
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept(); //The client gets accepted on that socket
                System.out.println("New client connected: CONNECTION SUCCESSFUL!");

                new ServerThread(socket).start(); //for multithreading we need to make a thread per client

            }
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();

        }
    }
}