package net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import ihm.PanelDessin;
import metier.Outil;

public class ClientHandler implements Runnable {
    private Socket socket;

    private BufferedReader in = null;
    private PrintWriter out = null;
    private List<Outil> listeOutils;
    private ArrayList<ClientHandler> alClients;

    public ClientHandler(Socket clientSocket, List<Outil> listeOutils, ArrayList<ClientHandler> alClients) {
        
        this.socket = clientSocket;
        this.listeOutils = listeOutils;
        this.alClients = alClients;

        try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(), true);
		} catch (IOException e) {}

        System.out.println("ClientHandler créé");
    }

    public void run() {

        try {

            this.alClients.add(this);
            
            
            while (true)
            {
                String outil = in.readLine();
                
                if (outil == null) 
                {
                    break;
                }

                if (outil.startsWith("FORME")) {
                    this.envoyerOutil(outil);
                }
            }

            


        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    public synchronized void envoyerOutil(String outil) 
    {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("~~~~Handler  " + outil);
            out.println(outil);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("====handler envoyer");
        }        
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
