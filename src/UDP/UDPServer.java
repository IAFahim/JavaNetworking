package UDP;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket(9806);
        byte[] bytes=new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(datagramPacket);
        String str=new String(datagramPacket.getData(),0, datagramPacket.getLength());
        System.out.println(str);
    }
}