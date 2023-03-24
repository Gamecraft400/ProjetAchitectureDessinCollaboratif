package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur 
{
    private static final int PORT = 1234;

    private ServerSocket serverSocket;

    public Serveur()
    {

        try {
            
            this.serverSocket = new ServerSocket(PORT);
            System.out.println("Serveur en ecoute sur le port " + PORT);

        
            Socket socket = this.serverSocket.accept();
            System.out.println("Nouvelle connexion");
            Thread t = new Thread(new Service(socket));
            t.start();
            


        } catch (IOException e ) {e.printStackTrace();}

    }


}
