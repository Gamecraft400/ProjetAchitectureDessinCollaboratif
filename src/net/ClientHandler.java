package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import metier.Outil;

public class ClientHandler implements Runnable {
    private Socket socket;
    private ArrayList<Outil> listeOutils;
    private ArrayList<PrintWriter> clients;
    private static Serveur serveur;

    public ClientHandler(Serveur serveur, Socket socket, ArrayList<Outil> listeOutils, ArrayList<PrintWriter> clients) {
        this.socket = socket;
        this.listeOutils = listeOutils;
        this.clients = clients;
        this.serveur = serveur;
    }

    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Ajout du nouveau client à la liste des clients connectés
            clients.add(out);

            // Envoi de la liste des outils disponibles au nouveau client
            /*for (Outil outil : listeOutils) 
            {
                out.println(outil.toString());
            }*/

            //out.println("FIN_LISTE_OUTILS");

            // Boucle d'écoute des messages du client
            while (true) 
            {
                String message = in.readLine();
                if (message == null) 
                {
                    break;
                }

                if (message.startsWith("NOUVEL_OUTIL")) 
                {
                    // Envoi du nouvel outil à tous les clients connectés
                    for (PrintWriter client : clients) 
                    {
                        client.println("NOUVEL_OUTIL," + message.substring(12));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Retrait du client de la liste des clients connectés
            clients.remove(out);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void envoyerOutil(String outil) 
    {
       /* try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("~~~~Handler  " + outil);
            out.println(outil);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("====handler envoyer");
        }*/
        this.serveur.envoyerOutil(outil);
        
    }

    public synchronized void recevoirOutil() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String outil = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("====handler recevoir");
        }
    }
}
