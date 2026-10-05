package UDP;

import java.net.*;

public class ServeurUDP {
    public static void main(String[] args) {
        try ( DatagramSocket sock = new DatagramSocket(1234) ) {
            while (true) {
                System.out.println("-Waiting Data");
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                sock.receive(packet);
                
                String str = new String(packet.getData(), 0, packet.getLength());
                System.out.println("str=" + str);
                
                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();
                
                DatagramPacket replyPacket = new DatagramPacket(
                    packet.getData(), packet.getLength(), clientAddress, clientPort
                );
                sock.send(replyPacket);
                System.out.println("-Message renvoyé au client.");
            }
        }
        catch (Exception ex) {
            System.out.println(" erreur ! ");
            ex.printStackTrace();
        }
    }
}