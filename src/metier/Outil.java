package metier;

import java.awt.Color;

public class Outil
{
	private final static String[] OUTIL_DIPONIBLE     = {"Cercle","Rectangle","Ligne","Texte","Remplir"};
	private final static Color[] COULEURS_DISPONIBLE = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.BLACK,Color.WHITE};

	private String outil;
	private String libelle;
	private Color couleur;

	private int posX;
	private int posY;

	private int largeur;
	private int hauteur;

	public Outil(String outil, String libelle, Color couleur)
	{
		this.outil = outil;
		this.libelle = libelle;
		this.couleur = couleur;
	}	

	public Outil(String outil, Color couleur)
	{
		this(outil, "", couleur);
	}

	public boolean setCouleur(Color couleur)
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
	public Color getCouleur(){return this.couleur; }

	public int getPosX		(){return this.posX;	}
	public int getPosY		(){return this.posY;	}
	public int getLargeur	(){return this.largeur;	}
	public int getHauteur	(){return this.hauteur;	}

	public String toString()
	{
		return "Outil selectionne " + this.outil + " de couleur " + this.couleur + " ( "+ this.posX + " , " + this.posY + " )";
	}

}