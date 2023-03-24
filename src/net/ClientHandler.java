package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable 
{

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket clientSocket) 
    {
        this.clientSocket = clientSocket;

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

            // Attendre que le client envoie un message
            while ((inputLine = in.readLine()) != null)
            {
                inputLine = in.readLine();
                // Envoyer le message à tous les clients connectés
                server.broadcast(inputLine);
            }

            // Le client s'est déconnecté
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