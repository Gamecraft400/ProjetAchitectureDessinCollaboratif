package ihm;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.Controleur;
import metier.Outil;

public class PanelDessin extends JPanel implements MouseListener
{
    Controleur ctrl;

    private FrameDessin frameDessin;
    private List<Outil> outils;

    private int x;
    private int y;
    private int width;
    private int height;
    private String texte="";

    private boolean isCercle = false;
    private boolean isRectangle = false;
    private boolean isLigne = false;
    private boolean isTexte = false;
    private boolean isFill = false;

    public PanelDessin(Controleur ctrl, FrameDessin frameDessin)
    {
        this.ctrl = ctrl;
        this.frameDessin = frameDessin;
        this.outils = this.ctrl.getOutils();
        this.addMouseListener(this);
    }

    /**
     * Le bouton selectionné est un cercle
     * @param isCercle true si le bouton est un cercle
     */
    public void cercle(boolean isCercle)
    {
        this.isCercle = isCercle;
        this.isRectangle = false;
        this.isLigne = false;
        this.isTexte = false;
        this.texte = "";
    }

    /**
     * Le bouton selectionné est un rectangle
     * @param isRectangle true si le bouton est un rectangle
     */
    public void rectangle(boolean isRectangle)
    {
        this.isRectangle = isRectangle;
        this.isCercle = false;
        this.isLigne = false;
        this.isTexte = false;
        this.texte = "";
    }

    /**
     * Le bouton selectionné est une ligne
     * @param isLigne true si le bouton est une ligne
     */
    public void ligne(boolean isLigne)
    {
        this.isLigne = isLigne;
        this.isCercle = false;
        this.isRectangle = false;
        this.isTexte = false;
        this.texte = "";
    }

    /**
     * Le bouton selectionné est un texte
     * @param isTexte true si le bouton est un texte
     */
    public void texte(boolean isTexte)
    {
        this.isTexte = isTexte;
        this.isCercle = false;
        this.isRectangle = false;
        this.isLigne = false;
    }

    /**
     * La forme est remplie 
     * @param isFill true si la forme edoit être remplie
     */
    public void remplir(boolean isFill) 
    {
        this.isFill = isFill;
    }

    public void paint(Graphics g)
    {
        super.paint(g);
        this.dessinerForme();
    }

    /**
     * Dessine les formes
     */
    public void paintComponent(Graphics g)
    {
        Graphics g = this.getGraphics();

        for( Outil outil : this.ctrl.getAlOutilsServeur() )
        {
            g.setColor(this.ctrl.getCouleur());

            String nom = outil.getOutil();
            int x = outil.getPosX();
            int y = outil.getPosY();
            int width = outil.getLargeur();
            int height = outil.getHauteur();

            if(nom.equals("Cercle"))
            {

                if(isFill)
                {
                    g.fillOval(x, y, width, height);
                }
                else
                {
                    g.drawOval(x, y, width, height);
                }
            }
            else if(nom.equals("Rectangle"))
            {
                if(isFill)
                {
                    g.fillRect(x, y, width, height);
                }
                else
                {
                    g.drawRect(x, y, width, height);
                }
            }
            else if(nom.equals("Ligne"))
            {
                g.drawLine(x, y, width, height);
            }
            else if(nom.equals("Texte"))
            {
                g.drawString(texte, x, y);
            }
        }


    }
    
    @Override
    /**
     * Récupère les coordonnées de la souris lorsqu'on reste appuyé
     */
    public void mousePressed(MouseEvent e) 
    {
        this.x = e.getX();
        this.y = e.getY();
        this.width = 0;
        this.height = 0;

        if(isTexte)
        {
            String prompt = "Please add text to display";
            String input = JOptionPane.showInputDialog(this, prompt);
            this.texte = input;
            this.ctrl.ajouterOutil("Texte", this.texte, this.ctrl.getCouleur(), this.x, this.y, this.width, this.height);
            this.repaint();
        }
    }

    @Override
    /**
     * Récupère les coordonnées de la souris lorsqu'on relache le clic pour dessiner la forme
     */
    public void mouseReleased(MouseEvent e) 
    {
        if(this.isCercle || isRectangle)
        {
            if(this.x < e.getX() && this.y < e.getY())
            {
                this.width = e.getX() - this.x;
                this.height = e.getY() - this.y;
            }
            else if (this.x > e.getX() && this.y > e.getY())
            {
                this.width = this.x - e.getX();
                this.height = this.y - e.getY();
                this.x = e.getX();
                this.y = e.getY();
            }
            else if (this.x > e.getX() && this.y < e.getY())
            {
                this.width = this.x - e.getX();
                this.height = e.getY() - this.y;
                this.x = e.getX();
            }
            else if (this.x < e.getX() && this.y > e.getY())
            {
                this.width = e.getX() - this.x;
                this.height = this.y - e.getY();
                this.y = e.getY();
            }

            if(isCercle)
            {
                this.ctrl.ajouterOutil("Cercle", this.ctrl.getCouleur(), this.x, this.y, this.width, this.height);
            }
            else if(isRectangle)
            {
                this.ctrl.ajouterOutil("Rectangle", this.ctrl.getCouleur(), this.x, this.y, this.width, this.height);
            }
        }
        else if(isLigne)
        {
            this.width = e.getX();
            this.height = e.getY();
            this.ctrl.ajouterOutil("Ligne", this.ctrl.getCouleur(), this.x, this.y, this.width, this.height);
        }
        this.ctrl.ajouterOutil("Cercle", this.ctrl.getCouleur(), this.x, this.y, this.width, this.height);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {     
    }

    public void majIHM() {
        this.dessinerForme();
    }
}
