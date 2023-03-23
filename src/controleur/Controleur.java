package controleur;

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
}
