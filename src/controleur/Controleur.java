package controleur;

import java.awt.Color;

import java.util.List;

import ihm.FrameAccueil;
import metier.Metier;
import metier.Outil;
import net.Client;
import net.ClientHandler;
import net.Serveur;

public class Controleur 
{
    private FrameAccueil frameAccueil;
    private Metier metier;
    private Serveur serveur;

    public Controleur()
    {
        this.frameAccueil = new FrameAccueil(this);
        this.metier = Metier.getInstance();
    }

    public static void main(String[] args) 
    {
        new Controleur();
    }

    public void ajouterOutil(String outil, Color coul, int x, int y, int width, int height) 
    {
        this.metier.ajouterOutil(outil, coul, x, y, width, height);
    }

    public List<ClientHandler> getAlClients() 
    {
        return this.metier.getAlClients();
    }

    public void setCouleur(Color color) 
    {
        this.metier.setCouleur(color);
    }

    public Color getCouleur() 
    {
        return this.metier.getCouleur();
    }

    public List<Outil>getOutils() 
    {
        return this.metier.getOutils();
    }

    public void ajouterOutil(String string, String texte, Color couleur, int x, int y, int width, int height) 
    {
        this.metier.ajouterOutil(string, texte, couleur, x, y, width, height);
    }

    public synchronized void envoyerOutil(String string) 
    {
        this.metier.envoyerOutil(string);
    }

    public void ajoutClient(ClientHandler clientHandler) 
    {
        this.metier.ajoutClient(clientHandler);
    }

    public void ajouterOutil(Outil outil) 
    {
        this.metier.ajouterOutil(outil);
    }
}
