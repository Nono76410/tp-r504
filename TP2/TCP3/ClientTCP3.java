package TCP3;

import java.io.*;
import java.net.*;

public class ClientTCP3 {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.out.println("Erreur : Veuillez donner une chaîne en argument (ex: java ClientTCP3 coucou)");
                return;
            }

            Socket socket = new Socket("localhost", 2016);
            
            // 1. Envoyer le message via la ligne de commande
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
            dOut.writeUTF(args[0]);
            
            // 2. Attendre et lire la réponse du serveur (la chaîne inversée)
            DataInputStream dIn = new DataInputStream(socket.getInputStream());
            String response = dIn.readUTF();
            System.out.println("Réponse reçue du serveur : " + response);
            
            // Fermeture
            dIn.close();
            dOut.close();
            socket.close();
        } 
        catch (Exception ex) {
            System.out.println("Erreur !");
            ex.printStackTrace();
        }
    }
}