package net;

import java.awt.Color;
import java.awt.List;
import metier.Metier;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Runnable
{
    private Socket socket;
    private Metier metier;

    private PrintWriter out;
    private BufferedReader in;

    private String pseudo;
    
    public Client(String pseudo, Metier metier)
    {

        this.ctrl = ctrl;
        this.pseudo = pseudo;
        this.metier = metier;
    }
    
    public boolean connect(String hostname, int port) 
    {
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

                
<<<<<<< HEAD
                    if (message.startsWith("FORME")) {
    
    public void sendMessage(String message) 
    {
        out.println(pseudo + ":" + message);
    }
    
    public void run()
    {
        try {

            String inputLine;

            while ((inputLine = in.readLine()) != null)
            {
                // Lire les messages envoyés par le clientHandler

                //envoie du message au Metier.
                this.metier.traiterDonnees(inputLine);
            }

        } catch (IOException e) {
            System.out.println("Erreur lors de la réception d'un message : " + e.getMessage());
        }
    }
    
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
=======
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
>>>>>>> parent of 0618213 (ouin)
                }
            
               
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("==========client");
                //break;   
            }                         
    }

}
