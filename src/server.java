import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) {
        /*
            try-with-resources block because ServerSocket implements AutoCloseable
            it would make sure it closes properly. And for this reason we have put all the resources in try-with-resources
        */
        try (ServerSocket serverSocket = new ServerSocket(9806)) {
            /*
                ServerSocket accept methods returns an Socket connected to the client
            */
            try (Socket socket = serverSocket.accept()) {
                /*
                    Socket getInputStream of bit(s) so we Want to put it in a InputStreamReader
                    InputStreamReader gives Char value of that bit(s)
                    BufferedReader Can then store them into a string
                */
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    /*
                        We output the input of the string sent by the Socket into the console
                     */
                    System.out.println(bufferedReader.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}