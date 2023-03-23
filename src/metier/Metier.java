package metier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import net.Client;

public class Metier 
{
    private List<Outil> alOutils;
    private List<Client> alClient;
    private Color couleur;

    //singleton
    private static Metier instance = null;

    public static Metier getInstance()
    {
        if(Metier.instance == null)
            Metier.instance = new Metier();

        return Metier.instance;
    }

    private Metier()
    {
        this.alOutils = new ArrayList<Outil>();
        this.alClient = new ArrayList<Client>();
    }

    public void ajouterOutil(Outil outil)
    {
        this.alOutils.add(outil);
    }

    public void ajouterClient(Client client)
    {
        this.alClient.add(client);
    }

    public List<Outil> getOutils()
    {
        return this.alOutils;
    }

    public List<Client> getAlClients()
    {
        return this.alClient;
    }

    public void ajouterOutil(String outil, Color coul) 
    {
        this.alOutils.add(new Outil(outil, coul));
        System.out.println(this.alOutils);
    }

    public void setCouleur(Color color)
    {
        this.couleur = color;
    }

    public Color getCouleur()
    {
        return this.couleur;
    }

}
