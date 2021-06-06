import java.io.*;
import java.net.Socket;

public class client {

    public static void main(String[] args) {
        /*
            try-with-resources block because Socket implements AutoCloseable
            it would make sure it closes properly. And for this reason we have put all the resources in try-with-resources
        */
        try (Socket socket = new Socket("localhost", 9806)) {
            /*
                Socket getInputStream of bit(s) so we Want to put it in a InputStreamReader
                InputStreamReader gives Char value of that bit(s)
                BufferedReader Can then store them into a string
             */
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
                /*
                    PrintWriter is similar to BufferedReader as it can take s a Stream(of bit(s))
                    and writes on that stream and flush it, by closing, this makes sure the action is done to the resources
                 */
                try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream())) {
                    printWriter.println(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}