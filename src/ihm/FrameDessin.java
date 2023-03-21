package ihm;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameDessin extends JFrame
{
    private JPanel panelHaut;
    private JPanel paneldessin;
    private JPanel panelCouleur;

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
        this.panelHaut.setLayout(null);

        //création des composants du panel haut
        this.btnCercle = new JButton();
        this.btnCercle.setIcon(new ImageIcon("./donnees/cercle.PNG"));
        this.btnCercle.setBounds(50, 10, 50, 50);
        this.btnCercle.setBorderPainted(false);
        this.btnCercle.setFocusPainted(false);
        this.btnCercle.setBackground(new Color(217,217,217));

        this.btnRectangle = new JButton("Rectangle");
        this.btnRectangle.setIcon(new ImageIcon("./donnees/carre.PNG"));
        this.btnRectangle.setBounds(120, 10, 50, 50);
        this.btnRectangle.setBorderPainted(false);
        this.btnRectangle.setFocusPainted(false);
        this.btnRectangle.setBackground(new Color(217,217,217));

        this.btnLigne = new JButton("Ligne");
        this.btnLigne.setIcon(new ImageIcon("./donnees/ligne.PNG"));
        this.btnLigne.setBounds(160, 10, 50, 50);
        this.btnLigne.setBorderPainted(false);
        this.btnLigne.setFocusPainted(false);
        this.btnLigne.setBackground(new Color(217,217,217));

        this.btnTexte = new JButton("Texte");
        this.btnTexte.setIcon(new ImageIcon("./donnees/texte.PNG"));
        this.btnTexte.setBounds(200, 15, 50, 25);
        this.btnTexte.setBorderPainted(false);
        this.btnTexte.setFocusPainted(false);
        this.btnTexte.setBackground(new Color(217,217,217));

        this.panelHaut.add(this.btnCercle);
        this.panelHaut.add(this.btnRectangle);
        this.panelHaut.add(this.btnLigne);
        this.panelHaut.add(this.btnTexte);
       
        this.add(this.panelHaut);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new FrameDessin();
    }
}
