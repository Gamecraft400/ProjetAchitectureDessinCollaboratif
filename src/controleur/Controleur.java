package controleur;

import java.awt.Color;

import java.util.List;

import ihm.FrameAccueil;
import metier.Metier;
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

    public void ajouterOutil(String outil, Color coul) 
    {
        this.metier.ajouterOutil(outil, coul);
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
}
