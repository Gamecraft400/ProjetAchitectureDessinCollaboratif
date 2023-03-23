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

    public void dessinerCercle() 
    {
        this.ctrl.ajouterOutil("Cercle", Color.BLACK);
        Graphics g = this.getGraphics();
        g.drawOval(this.x, this.y, this.width, this.height);
        
    }

    public void dessinerRectangle() 
    {
        this.ctrl.ajouterOutil("Rectangle", Color.BLACK);
        Graphics g = this.getGraphics();
        g.drawRect(this.x, this.y, this.width, this.height);
    }

    public void dessinerLigne() 
    {
        this.ctrl.ajouterOutil("Ligne", Color.BLACK);
        Graphics g = this.getGraphics();
        g.drawLine(this.x, this.y, this.width, this.height);
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        if(this.isCercle)
        {
            this.x = e.getX();
            this.y = e.getY();
            this.width = 0;
            this.height = 0;
        }
        else if(isRectangle)
        {
            this.x = e.getX();
            this.y = e.getY();
            this.width = 0;
            this.height = 0;
        }
        else if(isLigne)
        {
            this.x = e.getX();
            this.y = e.getY();
            this.width = 0;
            this.height = 0;
        }
        else if(isTexte)
        {
            this.x = e.getX();
            this.y = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        if(this.isCercle)
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
            this.dessinerCercle();
        }
        else if(isRectangle)
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
            this.dessinerRectangle();
        }
        else if(isLigne)
        {
            this.width = e.getX();
            this.height = e.getY();
            this.dessinerLigne();
        }
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
            this.texte += e.getKeyChar();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
