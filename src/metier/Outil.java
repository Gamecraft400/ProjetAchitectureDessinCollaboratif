package metier;

public class Outil
{
	private final static String[] OUTIL_DIPONIBLE     = {"Cercle","Rectangle","Ligne","Texte","Remplir"};
	private final static String[] COULEURS_DISPONIBLE = {"Red","Bleu","Green","Yellow","Black","White" };

	private String outil;
	private String libelle;
	private String couleur;

	public static Outil creerOutil(String outil, String libelle, String couleur)
	{
		boolean contient = false;
		for(int cpt = 0; cpt < Outil.OUTIL_DIPONIBLE.length;cpt++)
			if(Outil.OUTIL_DIPONIBLE[cpt] == outil)
				contient = true;

		if(!contient)
			return null;

		return new Outil(outil, libelle, couleur);
	}

	public static Outil creerOutil(String outil, String couleur)
	{
		return creerOutil(outil, "", couleur);
	}

	public Outil(String outil, String libelle, String couleur)
	{
		this.outil = outil;
		this.libelle = libelle;
		this.couleur = couleur;
	}

	public Outil(String outil, String couleur)
	{
		this(outil, "", couleur);
	}

	public boolean setCouleur(String couleur)
	{
		for(int cpt = 0; cpt < Outil.COULEURS_DISPONIBLE.length;cpt++)
			if(Outil.COULEURS_DISPONIBLE[cpt] == couleur)
			{
				this.couleur = couleur;
				return true;
			}

		return false;
	}

	public String getLibelle(){return this.libelle; }
	public String getOutil	(){return this.outil;	}
	public String getCouleur(){return this.couleur; }

	public String toString()
	{
		return "Outil selectionne" + this.outil + "de couleurs" + this.couleur;
	}

}