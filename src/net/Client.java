package net;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import controleur.Controleur;
import ihm.FrameDessin;
import metier.Outil;

public class Client implements Runnable 
{
    private Socket socket;
    private ArrayList<Outil> aOutils;
    private FrameDessin frameDessin;

    private String pseudo;

    private Controleur ctrl;

    public Client(Controleur ctrl, String pseudo) 
    {

        this.ctrl = ctrl;
        this.pseudo = pseudo;
        this.aOutils = new ArrayList<Outil>();
        this.frameDessin = new FrameDessin(this.ctrl, aOutils);
    }

    public void connecter(String ip, int port) 
    {
        try {
            socket = new Socket(ip, port);
            new Thread(this).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() 
    {
        BufferedReader in = null;
        PrintWriter out = null;

        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Boucle d'écoute des messages du serveur
            while (true) 
            {
                String message = in.readLine();

                if (message == null) 
                {
                    break;
                }

                //si le message est FIN_LISTE_OUTILS, on lit la liste des outils et on les ajoute à la liste des outils
                if (message.equals("FIN_LISTE_OUTILS")) 
                {
                    String listeOutils = in.readLine();

                    while (listeOutils != null) 
                    {

                        String[] infos = listeOutils.split(",");
                        Outil outil = new Outil(infos[0], infos[1], new Color(Integer.parseInt(infos[2])),
                                Integer.parseInt(infos[3]), Integer.parseInt(infos[4]), Integer.parseInt(infos[5]),
                                Integer.parseInt(infos[6]));
                                aOutils.add(outil);

                        listeOutils = in.readLine();
                    }
                } 
                //si le message est NOUVEL_OUTIL, on ajoute l'outil à la liste des outils
                else if (message.startsWith("NOUVEL_OUTIL")) 
                {
                    // Traitement du nouvel outil envoyé par le serveur
                    String[] infosOutil = message.substring(12).split(",");
                    Outil outil = new Outil(infosOutil[0], infosOutil[1], 
                                            new Color(Integer.parseInt(infosOutil[2])), 
                                            Integer.parseInt(infosOutil[3]), 
                                            Integer.parseInt(infosOutil[4]), 
                                            Integer.parseInt(infosOutil[5]), 
                                            Integer.parseInt(infosOutil[6]));
                    frameDessin.ajouterOutil(outil);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
