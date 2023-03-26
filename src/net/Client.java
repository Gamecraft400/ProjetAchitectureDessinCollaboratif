package net;

import java.awt.Color;
import java.awt.List;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import controleur.Controleur;
import ihm.FrameDessin;
import ihm.PanelDessin;
import metier.Outil;

public class Client implements Runnable 
{
    private Socket socket;
    private ArrayList<Outil> aOutils;
    private FrameDessin frameDessin;

    private String pseudo;

    private Controleur ctrl;


    public Client(Controleur ctrl, String pseudo, String ip, int port, ArrayList<Outil> arrayList) 
    {

        this.ctrl = ctrl;
        this.pseudo = pseudo;
        this.aOutils = arrayList;
        this.frameDessin = new FrameDessin(this.ctrl, aOutils);

        try {
            socket = new Socket(ip, port);
            new Thread(this).start();
            System.out.println("Connexion établie " +  ip);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("==== Client créé");
    }



    public synchronized void run() 
    {
        //BufferedReader in = null;
        

       
            //in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //out = new PrintWriter(socket.getOutputStream(), true);

            // Boucle d'écoute des messages du serveur
        
        
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String message = in.readLine();

                
                if (message.startsWith("FORME")) {


                    String[] infosOutil = message.split(";");

                    for (String s : infosOutil) {
                        System.out.println(s);
                    }

                    Outil outil = new Outil(infosOutil[1], infosOutil[2],
                                            new Color(Integer.parseInt(infosOutil[3])), 
                                            Integer.parseInt(infosOutil[4]), 
                                            Integer.parseInt(infosOutil[5]), 
                                            Integer.parseInt(infosOutil[6]), 
                                            Integer.parseInt(infosOutil[7]));
                    
                    
                    this.frameDessin.ajouterOutil(outil);
                    this.aOutils.add(outil);
                }
            
               
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("==========client");
                //break;
            }
                



                //si le message est FIN_LISTE_OUTILS, on lit la liste des outils et on les ajoute à la liste des outils
               /*if (message.equals("FIN_LISTE_OUTILS")) 
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
                } */
                //si le message est NOUVEL_OUTIL, on ajoute l'outil à la liste des outils
                /*else if (message.startsWith("NOUVEL_OUTIL")) 
                {
                    // Traitement du nouvel outil envoyé par le serveur
                    String[] infosOutil = message.substring(12).split(",");
                    Outil outil = new Outil(infosOutil[0], infosOutil[1], 
                                            new Color(Integer.parseInt(infosOutil[2])), 
                                            Integer.parseInt(infosOutil[3]), 
                                            Integer.parseInt(infosOutil[4]), 
                                            Integer.parseInt(infosOutil[5]), 
                                            Integer.parseInt(infosOutil[6]));
                    frameDessin.ajouterOutil(outil);*/
            
    }

    public void maj() 
    {
        frameDessin.maj();
    }
}
