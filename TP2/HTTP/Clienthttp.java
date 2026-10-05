import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Clienthttp {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage : java Clienthttp <nom_d_hote>");
            return;
        }

        String host = args[0];
        int port = 80;

        try {
            Socket socket = new Socket(host, port);

            BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            StringBuilder request = new StringBuilder();
            request.append("GET / HTTP/1.1\r\n");
            request.append("Host: ").append(host).append("\r\n");
            request.append("User-Agent: Mozilla/5.0\r\n");
            request.append("Connection: close\r\n");
            request.append("\r\n"); 

            bufOut.write(request.toString());
            bufOut.flush();

            String line = bufIn.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufIn.readLine();
            }

            bufIn.close();
            bufOut.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}