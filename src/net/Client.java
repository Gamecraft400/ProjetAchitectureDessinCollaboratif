package net;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client
{
    private static final int PORT = 1234;

    private String  pseudo;
    private Socket  socket;

    public Client(String pseudo)
    {
        this.pseudo = pseudo;

        try
        {
            this.socket = new Socket(InetAddress.getLocalHost(), PORT);

            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            out.println("Bonjour je suis " + this.pseudo);  

            socket.close();
        }
        catch(UnknownHostException e) {e.printStackTrace();}
        catch(Exception e) {e.printStackTrace();}
    }

    public String getPseudo      () { return this.pseudo;      }

    public String toString()
    {
        return "Utilisateur : " + this.pseudo + " sur " + this.socket;
    }


}