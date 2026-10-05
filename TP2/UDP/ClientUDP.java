package UDP;

import java.net.*;

public class ClientUDP {
    public static void main(String[] args) {
        String s = "hello World";
        try {
            InetAddress addr = InetAddress.getLocalHost();
            System.out.println("adresse=" + addr.getHostName());
            
            byte[] data = s.getBytes();
            DatagramPacket packet = new DatagramPacket(data, data.length, addr, 1234);
            DatagramSocket sock = new DatagramSocket();
            sock.send(packet);
            System.out.println("Message envoyé au serveur...");

            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            sock.receive(responsePacket); 
            
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Réponsedu serveur : " + response);
            
            sock.close();
        } 
        catch (Exception ex) {
            System.out.println(" erreur ! ");
            ex.printStackTrace();
        }
    }
}