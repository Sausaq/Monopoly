package org.example.javaprojectmonopoly;
import java.io.*;
import java.net.*;
import javafx.application.Platform;

public class GameServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started. Waiting for a client...");

        clientSocket = serverSocket.accept();
        System.out.println("Client connected: " + clientSocket);

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        Thread receiveThread = new Thread(() -> {
            String inputLine;
            try {
                while ((inputLine = in.readLine()) != null) {
                    // Handle incoming data from the client
                    System.out.println("Received from client: " + inputLine);
                    // Process the data as needed
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        receiveThread.start();
    }

    public void send(String data) {
        out.println(data);
    }

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
}
