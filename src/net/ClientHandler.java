package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable 
{

    private Socket clientSocket;
    private Serveur server;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket clientSocket, Serveur server) 
    {
        this.clientSocket = clientSocket;
        this.server = server;

        try {

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            System.out.println("Erreur lors de la création du clientHandler : " + e.getMessage());
        }
    }

    @Override
    public void run() 
    {
        try {

            String inputLine;

            while ((inputLine = in.readLine()) != null) 
            {
                // Lire les messages envoyés par le client
                System.out.println("Message reçu de " + clientSocket + " : " + inputLine);
                // Envoyer le message à tous les autres clients connectés
                server.broadcast(inputLine);
            }
            // Le client s'est déconnecté
            server.removeClient(this);
            in.close();
            out.close();
            clientSocket.close();


        } catch (IOException e) {
            System.out.println("Erreur lors de la communication avec le client " + clientSocket + " : " + e.getMessage());
            server.removeClient(this);
        }
    }

    public void sendMessage(String message) 
    {
        out.println(message);
    }

    public Socket getClientSocket() 
    {
        return this.clientSocket;
    }
}