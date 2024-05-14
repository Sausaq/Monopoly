package org.example.javaprojectmonopoly;
import java.io.*;
import java.net.*;
import javafx.application.Platform;
public class GameClient {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ipAddress, int port) throws IOException {
        socket = new Socket(ipAddress, port);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void send(String data) {
        out.println(data);
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        socket.close();
    }

    public String receive() throws IOException {
        return in.readLine();
    }
}
