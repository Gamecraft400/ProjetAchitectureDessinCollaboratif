package metier;

public class Outil
{
	private final static String[] OUTIL_DIPONIBLE     = {"Cercle","Rectangle","Ligne","Texte","Remplir"};
	private final static String[] COULEURS_DISPONIBLE = {"Red","Bleu","Green","Yellow","Black","White" };

	private String outil;
	private String libelle;
	private String couleur;

	private int posX;
	private int posY;

	private int largeur;
	private int hauteur;

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

	public void setPosX		(int posX)	{this.posX = posX;	}
	public void setPosY		(int posY)	{this.posY = posY;	}
	public void setLargeur	(int largeur){this.largeur = largeur;	}
	public void setHauteur	(int hauteur){this.hauteur = hauteur;	}

	public String getLibelle(){return this.libelle; }
	public String getOutil	(){return this.outil;	}
	public String getCouleur(){return this.couleur; }

	public int getPosX		(){return this.posX;	}
	public int getPosY		(){return this.posY;	}
	public int getLargeur	(){return this.largeur;	}
	public int getHauteur	(){return this.hauteur;	}

	public String toString()
	{
		return "Outil selectionne " + this.outil + " de couleur " + this.couleur + " ( "+ this.posX + " , " + this.posY + " )";
	}

}