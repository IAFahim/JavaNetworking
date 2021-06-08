package UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket();
        byte[] bytes="10".getBytes();
        InetAddress inetAddress=InetAddress.getByName("103.84.253.122");
        DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length,inetAddress,9806);
        datagramSocket.send(datagramPacket);
    }
}