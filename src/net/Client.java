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
                    



                    if(!this.aOutils.contains(outil)) 
                    {                        
                        this.frameDessin.ajouterOutil(outil);
                        this.aOutils.add(outil);   
                    }

                    

                    message = in.readLine();
                }
            
               
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("==========client");
                //break;   
            }                         
    }
}
