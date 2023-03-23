package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameDessin extends JFrame
{
    private JPanel panelHaut;
    private JPanel paneldessin;

    private JButton btnCercle;
    private JButton btnRectangle;
    private JButton btnLigne;
    private JButton btnTexte;

    private JButton[] tabBtnCoul;
    
    public FrameDessin()
    {
        this.setTitle("Dessin");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(new Color(217,217,217));
        this.setLayout(new BorderLayout());

        //création du panel haut
        this.panelHaut = new JPanel();
        this.panelHaut.setBackground(new Color(217,217,217));
        this.panelHaut.setLayout(new GridLayout(1,4));

        //création des composants du panel haut
        this.btnCercle = new JButton();
        this.btnCercle.setIcon(new ImageIcon("./donnees/cercle.PNG"));
        this.btnCercle.setBorderPainted(false);
        this.btnCercle.setFocusPainted(false);
        this.btnCercle.setBackground(new Color(217,217,217));

        this.btnRectangle = new JButton();
        this.btnRectangle.setIcon(new ImageIcon("./donnees/carre.PNG"));
        this.btnRectangle.setBorderPainted(false);
        this.btnRectangle.setFocusPainted(false);
        this.btnRectangle.setBackground(new Color(217,217,217));

        this.btnLigne = new JButton();
        this.btnLigne.setIcon(new ImageIcon("./donnees/ligne.PNG"));
        this.btnLigne.setBorderPainted(false);
        this.btnLigne.setFocusPainted(false);
        this.btnLigne.setBackground(new Color(217,217,217));

        this.btnTexte = new JButton();
        this.btnTexte.setIcon(new ImageIcon("./donnees/texte.PNG"));
        this.btnTexte.setBorderPainted(false);
        this.btnTexte.setFocusPainted(false);
        this.btnTexte.setBackground(new Color(217,217,217));

        //création du panel dessin
        this.paneldessin = new JPanel();



        this.panelHaut.add(this.btnCercle);
        this.panelHaut.add(this.btnRectangle);
        this.panelHaut.add(this.btnLigne);
        this.panelHaut.add(this.btnTexte);
       
        this.add(this.panelHaut, BorderLayout.NORTH);
        this.add(this.paneldessin, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new FrameDessin();
    }
}
