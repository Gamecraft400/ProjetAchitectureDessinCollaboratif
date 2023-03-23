package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import controleur.Controleur;

public class PanelDessin extends JPanel implements MouseListener
{
    Controleur ctrl;
    private int x;
    private int y;
    private int width;
    private int height;

    private boolean isCercle = false;

    public PanelDessin(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.addMouseListener(this);
    }

    public void cercle()
    {
        this.isCercle = true;
    }

    public void dessinerCercle() 
    {
        this.ctrl.ajouterOutil("Cercle", Color.BLACK);
        Graphics g = this.getGraphics();
        g.drawOval(this.x, this.y, this.width, this.height);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
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
            else
            {
                this.width = this.x - e.getX();
                this.height = this.y - e.getY();
                this.x = e.getX();
                this.y = e.getY();
            }
            this.dessinerCercle();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
