package TCP2;

import java.io.*;
import java.net.*;

public class ClientTCP2 {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.out.println("Erreur : Veuillez fournir un message en argument (ex: java ClientTCP2 coucou)");
                return;
            }

            Socket socket = new Socket("localhost", 2016);
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            
            dOut.writeUTF(args[0]);
            
            dOut.close();
            socket.close();
        } 
        catch (Exception ex) {
            System.out.println("Erreur !");
            ex.printStackTrace();
        }
    }
}