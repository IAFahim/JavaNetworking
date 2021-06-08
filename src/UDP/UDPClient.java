package UDP;

import javax.sound.sampled.Port;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPClient {
    private int PORT, packageSize;
    private InetAddress IPADDRESS;
    private DatagramSocket datagramSocket;

    public boolean connect(String connectionString) {
        byte[] buffer = connectionString.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, IPADDRESS, PORT);
        return send(datagramPacket);
    }

    public boolean send(DatagramPacket datagramPacket) {
        try {
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public UDPClient(String ipAddress, int port, int packageSize) throws UnknownHostException {
        this.IPADDRESS = InetAddress.getByName(ipAddress);
        this.PORT = port;
        this.packageSize = packageSize;
        try {
            datagramSocket = new DatagramSocket();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}