package Lesson6.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Network {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8189;
    private Socket socket;
    private DataInputStream socketInput;
    private DataOutputStream socketOutput;

    private final String host;
    private final int port;

    public Network(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public Network() {
        this(SERVER_HOST, SERVER_PORT);
    }
    public boolean connect() {
        try {
            socket = new Socket(host, port);
            socketInput = new DataInputStream(socket.getInputStream());
            socketOutput = new DataOutputStream(socket.getOutputStream());
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to establish connection");
            return false;
        }
        public void sendMessage(){

        }
    }
}
