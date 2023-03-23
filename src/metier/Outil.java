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


	public static Outil creerOutil(String outil, String libelle, Color couleur, int posX, int posY, int largeur, int hauteur)
	{
		boolean contient = false;
		for(int cpt = 0; cpt < Outil.OUTIL_DIPONIBLE.length;cpt++)
			if(Outil.OUTIL_DIPONIBLE[cpt] == outil)
				contient = true;

		if(!contient)
			return null;

		return new Outil(outil, libelle, couleur, posX, posY, largeur, hauteur);
	}

	public static Outil creerOutil(String outil, Color couleur, int posX, int posY, int largeur, int hauteur)
	{
		return creerOutil(outil, "", couleur, posX, posY, largeur, hauteur);
	}

	private Outil(String outil, String libelle, Color couleur , int posX, int posY, int largeur, int hauteur)
	{
		this.outil = outil;
		this.libelle = libelle;
		this.couleur = couleur;
		this.posX = posX;
		this.posY = posY;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}	

	private Outil(String outil, Color couleur, int posX, int posY, int largeur, int hauteur)
	{
		this(outil, "", couleur, posX, posY, largeur, hauteur);
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

	public String getLibelle(){return this.libelle; }
	public String getOutil	(){return this.outil;	}
	public Color getCouleur(){return this.couleur; }

	public int getPosX		(){return this.posX;	}
	public int getPosY		(){return this.posY;	}
	public int getLargeur	(){return this.largeur;	}
	public int getHauteur	(){return this.hauteur;	}

	public String toString()
	{
		return "Outil selectionne" + this.outil + "de couleur" + this.couleur + "( "+ this.posX + " , " + this.posY + " )";
	}

}