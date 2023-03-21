
public class Outil
{
	private static String[] OUTIL_DIPONIBLE = {"Cercle","Rectangle","Ligne","Texte","Remplir"};
	private static String[] COULEURS_DISPONIBLE = {"Red","Bleu","Green","Yellow","Black","White"};


	private String outil;
	private String libelle;
	private String couleur;


	public Outil(String outil, String libelle, String couleur)
	{
		this.outil = outil;
		this.libelle = libelle;
		this.couleur = couleur;
	}

	public Outil(String outil, String libelle)
	{
		this(outil, libelle, "Black");
	}

	public Outil(String outil)
	{
		this(outil, "" , "Black");
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

	public String getLibelle(){return this.libelle;}

	public String getOutil(){return this.outil;}

	public String getCouleur(){return this.couleur;}
	
	public String toString()
	{
		return "Outil selectionne" + this.outil + "de couleurs" + this.couleur;
	}

}