package metier;

import java.util.ArrayList;
import java.util.List;

public class Metier 
{
    private List<Outil> alOutils;
    private List<Utilisateur> alUtilisateurs;

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
        this.alUtilisateurs = new ArrayList<Utilisateur>();
    }

    public void ajouterOutil(Outil outil)
    {
        this.alOutils.add(outil);
    }

    public void ajouterUtilisateur(Utilisateur utilisateur)
    {
        this.alUtilisateurs.add(utilisateur);
    }

    public List<Outil> getOutils()
    {
        return this.alOutils;
    }

    public List<Utilisateur> getUtilisateurs()
    {
        return this.alUtilisateurs;
    }

    public void ajouterOutil(String outil, String coul) 
    {
        this.alOutils.add(new Outil(outil, coul));
        System.out.println(this.alOutils);
    }

}
