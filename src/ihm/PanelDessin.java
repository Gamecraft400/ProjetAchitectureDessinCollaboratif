package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import controleur.Controleur;

public class PanelDessin extends JPanel implements MouseListener, KeyListener
{
    Controleur ctrl;
    private int x;
    private int y;
    private int width;
    private int height;
    private String texte="";

    private boolean isCercle = false;
    private boolean isRectangle = false;
    private boolean isLigne = false;
    private boolean isTexte = false;

    public PanelDessin(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.addMouseListener(this);
        this.addKeyListener(this);
    }

    public void cercle(boolean isCercle)
    {
        this.isCercle = isCercle;
        this.isRectangle = false;
        this.isLigne = false;
        this.isTexte = false;
        this.texte = "";
    }

    public void rectangle(boolean isRectangle)
    {
        this.isRectangle = isRectangle;
        this.isCercle = false;
        this.isLigne = false;
        this.isTexte = false;
        this.texte = "";
    }

    public void ligne(boolean isLigne)
    {
        this.isLigne = isLigne;
        this.isCercle = false;
        this.isRectangle = false;
        this.isTexte = false;
        this.texte = "";
    }

    public void texte(boolean isTexte)
    {
        this.isTexte = isTexte;
        this.isCercle = false;
        this.isRectangle = false;
        this.isLigne = false;
    }

    public void dessinerForme()
    {
        Graphics g = this.getGraphics();
        g.setColor(this.ctrl.getCouleur());

        if(this.isCercle)
        {
            this.ctrl.ajouterOutil("Cercle", this.ctrl.getCouleur());
            g.drawOval(this.x, this.y, this.width, this.height);
        }
        else if(this.isRectangle)
        {
            this.ctrl.ajouterOutil("Rectangle", this.ctrl.getCouleur());
            g.drawRect(this.x, this.y, this.width, this.height);
        }
        else if(this.isLigne)
        {
            this.ctrl.ajouterOutil("Ligne", this.ctrl.getCouleur());
            g.drawLine(this.x, this.y, this.width, this.height);
        }
        else if(this.isTexte)
        {
            this.ctrl.ajouterOutil("Texte", this.ctrl.getCouleur());
            g.drawString(this.texte, this.x, this.y);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        
        this.x = e.getX();
        this.y = e.getY();
        this.width = 0;
        this.height = 0;

        if(isTexte)
        {
            this.x = e.getX();
            this.y = e.getY();
        }
    }

    @Override
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
        }
        else if(isLigne)
        {
            this.width = e.getX();
            this.height = e.getY();
        }

        this.dessinerForme();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) 
    {
        if(isTexte)
        {
            if(e.getKeyChar() == KeyEvent.VK_ENTER)
            {
                this.dessinerForme();
                System.out.println(this.texte);
            }
            else
            {
                this.texte += e.getKeyChar();
                System.out.println(e.getKeyChar());
                this.dessinerForme();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
