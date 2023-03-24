package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client 
{
    private Socket socket;

    private PrintWriter out;
    private BufferedReader in;

    private String pseudo;
    
    public Client(String pseudo) 
    {
        this.pseudo = pseudo;
    }
    
    public boolean connect(String hostname, int port) 
    {
        try {

            socket = new Socket(hostname, port);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            return true;

        } catch (IOException e) {
            System.out.println("Erreur lors de la connexion au serveur : " + e.getMessage());
            return false;
        }
    }
    
    public void sendMessage(String message) 
    {
        out.println(pseudo + ": " + message);
    }
    
    public String receiveMessage() 
    {
        try {

            return in.readLine();

        } catch (IOException e) {
            System.out.println("Erreur lors de la réception d'un message : " + e.getMessage());
            return null;
        }
    }
    
    public void disconnect() 
    {
        try {

            in.close();
            out.close();
            socket.close();

        } catch (IOException e) {
            System.out.println("Erreur lors de la déconnexion : " + e.getMessage());
        }
    }

    public String getPseudo() {
        return pseudo;
    }

    /*public static void main(String[] args) 
    {
        Client client = new Client("Pseudo");
        client.connect("localhost", 1234);
        
        client.sendMessage("Bonjour");
        System.out.println(client.receiveMessage());
        
        client.disconnect();
    }*/
}