package controleur;

import java.awt.Color;

import java.util.List;

import ihm.FrameAccueil;
import metier.Metier;
import metier.Outil;
import net.Client;

public class Controleur 
{
    private FrameAccueil frameAccueil;
    private Metier metier;

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

    public void ajouterClient(Client client) 
    {
        this.metier.ajouterClient(client);
    }

    public List<Client> getAlClients() 
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
}
