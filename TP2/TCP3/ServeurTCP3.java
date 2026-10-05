package TCP3;

import java.io.*;
import java.net.*;

public class ServeurTCP3 {
    public static void main(String[] args) {
        try {
            ServerSocket socketserver = new ServerSocket(2016);
            System.out.println("serveur en attente");
            Socket socket = socketserver.accept();
            System.out.println("Connexion d'un client");
            DataInputStream dIn = new DataInputStream(socket.getInputStream());
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            String message = dIn.readUTF();
            System.out.println("Message: " + message);
            dOut.writeUTF(new StringBuilder(message).reverse().toString());

            dOut.close();
            dIn.close();
            socket.close();
            socketserver.close();
        }
        catch (Exception ex) {
            System.out.println("Erreur !");
            ex.printStackTrace();
        }
    }
}