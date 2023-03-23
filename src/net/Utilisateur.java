package net;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Utilisateur
{
    private String  pseudo;
    private Socket  socket;

    private boolean estConnecte;
    private boolean estAdmin;

    public Utilisateur(String pseudo, boolean estConnecte, boolean estAdmin)
    {
        this.pseudo         = pseudo;
        this.estConnecte    = estConnecte;
        this.estAdmin       = estAdmin;

        try
        {
            this.socket = new Socket(InetAddress.getLocalHost(), 5000); 

            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            out.println("Bonjour je suis " + this.pseudo);  

            socket.close();
        }
        catch(UnknownHostException e) {e.printStackTrace();}
        catch(Exception e) {e.printStackTrace();}
    }

    public boolean getEstConnecte() { return this.estConnecte; }
    public boolean getEstAdmin   () { return this.estAdmin;    }
    public String getPseudo      () { return this.pseudo;      }

    public void setEstConnecte(boolean estConnecte)
    {
        this.estConnecte = estConnecte;
    }

    public String toString()
    {
        return "Utilisateur : " + this.pseudo + " est connecte : " + this.estConnecte + " est admin : " + this.estAdmin;
    }


}