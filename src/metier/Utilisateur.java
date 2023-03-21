package metier;

public class Utilisateur
{
    private String  pseudo;
    private boolean estConnecte;
    private boolean estAdmin;

    public Utilisateur(String pseudo, boolean estConnecte, boolean estAdmin)
    {
        this.pseudo         = pseudo;
        this.estConnecte    = estConnecte;
        this.estAdmin       = estAdmin;
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