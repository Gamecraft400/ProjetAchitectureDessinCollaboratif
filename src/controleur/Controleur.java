package controleur;

import java.awt.Color;

import ihm.FrameAccueil;
import metier.Metier;

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

    public void setCouleur(Color color) 
    {
        this.metier.setCouleur(color);
    }

    public Color getCouleur() 
    {
        return this.metier.getCouleur();
    }

    public void ajouterOutil(String string, String texte, Color couleur, int x, int y, int width, int height) 
    {
        this.metier.ajouterOutil(string, texte, couleur, x, y, width, height);
    }
}
