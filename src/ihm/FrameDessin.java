package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.Controleur;

public class FrameDessin extends JFrame implements ActionListener
{
    private Controleur ctrl;
    private JPanel panelHaut;

    private JButton btnCercle;
    private JButton btnRectangle;
    private JButton btnLigne;
    private JButton btnTexte;
    
    public FrameDessin(Controleur ctrl)
    {
        this.ctrl = ctrl;
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

        this.panelHaut.add(this.btnCercle);
        this.panelHaut.add(this.btnRectangle);
        this.panelHaut.add(this.btnLigne);
        this.panelHaut.add(this.btnTexte);
       
        this.add(this.panelHaut, BorderLayout.NORTH);
        this.setVisible(true);

        this.btnCercle.addActionListener(this);
        this.btnRectangle.addActionListener(this);
        this.btnLigne.addActionListener(this);
        this.btnTexte.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == this.btnCercle)
        {
            this.ctrl.ajouterOutil("Cercle", "BLACK");
        }
        else if(e.getSource() == this.btnRectangle)
        {
            this.ctrl.ajouterOutil("Rectangle", "BLACK");
        }
        else if(e.getSource() == this.btnLigne)
        {
            this.ctrl.ajouterOutil("Ligne", "BLACK");
        }
        else if(e.getSource() == this.btnTexte)
        {
            this.ctrl.ajouterOutil("Texte", "BLACK");
        }
    }
}
