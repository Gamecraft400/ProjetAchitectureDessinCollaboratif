package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import metier.Outil;

public class Serveur extends Thread 
{
    private final int PORT = 1234;
    private ServerSocket serverSocket;
    private ArrayList<Outil> listeOutils = new ArrayList<>();
    private ArrayList<PrintWriter> clients = new ArrayList<>();

    public Serveur() 
    {
        try {

            serverSocket = new ServerSocket(PORT);
        System.out.println("Serveur démarré sur le port " + PORT);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    public void run() 
    {
        try {

            while (true) 
            {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouvelle connexion entrante : " + clientSocket);

                // Création d'un nouveau clientHandler pour gérer la connexion avec le client
                ClientHandler clientHandler = new ClientHandler(clientSocket, listeOutils, clients);

                // Ajout du clientHandler à la liste des threads à exécuter
                new Thread(clientHandler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void envoyerOutil(Outil outil) {
        // Envoi de l'outil à tous les clients connectés
        for (PrintWriter client : clients) 
        {
            client.println("NOUVEL_OUTIL " + outil.toString());
        }
    }

    public void ajouterClient(PrintWriter client) {
        // Ajout du client à la liste des clients connectés
        clients.add(client);
    }
}


