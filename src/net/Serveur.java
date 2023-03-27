package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import controleur.Controleur;
import metier.Outil;

public class Serveur extends Thread 
{
    private final int PORT = 1234;
    private ServerSocket serverSocket;
    private List<Outil> listeOutils = new ArrayList<>();
    private ArrayList<PrintWriter> clients = new ArrayList<>();
    private ArrayList<ClientHandler> alClients = new ArrayList<>();
    private Controleur ctrl;

    public Serveur(Controleur ctrl, List<Outil> list) 
    {
        try {

        this.ctrl = ctrl;
        this.listeOutils =  list;
        serverSocket = new ServerSocket(PORT);
        System.out.println("Serveur démarré sur le port " + PORT);

        this.alClients = new ArrayList<ClientHandler>();
            
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

                //envoyer aux clients connectés
                for (PrintWriter client : clients) 
                {
                    client.println("NOUVELLE_CONNEXION " + clientSocket.toString());
                    client.flush();
                }

                // Création d'un nouveau clientHandler pour gérer la connexion avec le client
                ClientHandler clientHandler = new ClientHandler(clientSocket, this.listeOutils, this.alClients);
                this.ctrl.ajoutClient(clientHandler);
                this.alClients.add(clientHandler);
                // Ajout du clientHandler à la liste des threads à exécuter
                new Thread(clientHandler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void envoyerOutil(String outil) {
        // Envoi de l'outil à tous les clients connectés
        for(ClientHandler client : this.ctrl.getAlClients()) {
            client.envoyerOutil(outil);
        }
    }

    public void ajouterOutil(Outil outil) {
        // Ajout de l'outil à la liste des outils
        listeOutils.add(outil);
        this.envoyerOutil(outil.toString());
    }

    public List<Outil> getListeOutils() {
        return listeOutils;
    }

    public void ajouterClient(PrintWriter client) {
        // Ajout du client à la liste des clients connectés
        clients.add(client);
    }

}


