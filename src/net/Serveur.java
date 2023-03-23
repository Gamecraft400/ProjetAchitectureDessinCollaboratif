package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur 
{
    private ServerSocket serverSocket;
    private  int port;

    public Serveur(int port)
    {
        this.port = port;

        try {
            
            this.serverSocket = new ServerSocket(this.port);
            System.out.println("Serveur en ecoute sur le port " + this.port);

            while(true)
            {
                Socket socket = this.serverSocket.accept();
                System.out.println("Nouvelle connexion");
                Thread t = new Thread(new Service(socket));
                t.start();
            }


        } catch (IOException e ) {e.printStackTrace();}

    }


}
