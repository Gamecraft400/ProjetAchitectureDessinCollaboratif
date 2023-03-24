package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import ihm.FrameDessin;
import ihm.PanelDessin;

import controleur.Controleur;

public class Serveur 
{
    private static final int PORT = 1234;

    private ServerSocket serverSocket;
    private ArrayList<ClientHandler> alClientsH = new ArrayList<>();

    private Controleur ctrl;
    private FrameDessin frameDessin;

    public Serveur(Controleur ctrl) 
    {
        this.ctrl = ctrl;

        try {

            serverSocket = new ServerSocket(PORT);
            System.out.println("Serveur demarre sur le port " + PORT);

        } catch (IOException e) {
            System.out.println("Erreur lors du démarrage du serveur : " + e.getMessage());
        }

        // Créer la fenêtre de dessin
        frameDessin = FrameDessin.getInstance(this.ctrl);
    }

    public void listenForClients() {
        while (true) {
            try {
                // Attendre qu'un client se connecte
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nouvelle connexion entrante : " + clientSocket);

                // Créer un nouveau clientHandler pour gérer la communication avec le client
                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                alClientsH.add(clientHandler);

                // Démarrer un thread pour gérer la communication avec le client
                Thread clientThread = new Thread(clientHandler);
                clientThread.start();

            } catch (IOException e) {
                System.out.println("Erreur lors de l'acceptation de la connexion : " + e.getMessage());
            }
        }
    }

    public synchronized void broadcast(String message) 
    {
        // Envoyer un message à tous les clients connectés
        for (ClientHandler cH : alClientsH) {
            cH.sendMessage(message);
        }
    }

    public synchronized void sendPanelDessin(PanelDessin panelDessin) 
    {
        // Envoyer un message à tous les clients connectés
        for (ClientHandler cH : alClientsH) {
            cH.sendPanelDessin(panelDessin);
        }
    }

    public synchronized void removeClient(ClientHandler clientHandler) 
    {
        // Supprimer le clientHandler de la liste des clients connectés
        alClientsH.remove(clientHandler);
        System.out.println("Client déconnecté : " + clientHandler.getClientSocket());
    }

    public ArrayList<ClientHandler> getAlClientsH() 
    {
        return alClientsH;
    }

    public void setFrameDessin(FrameDessin frameDessin) 
    {
        this.frameDessin = frameDessin;
    }

    

    /*public static void main(String[] args) 
    {
        Serveur server = new Serveur();
        String ip = IpRecup.getLocalIpAddress();
        System.out.println("IP : " + ip);

        server.listenForClients();

    }*/

}
