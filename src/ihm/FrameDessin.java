package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.Controleur;
import metier.Outil;

public class FrameDessin extends JFrame implements ActionListener
{
    private Controleur ctrl;
    private JPanel panelHaut;
    private PanelDessin paneldessin;
    private PanelChoixCouleur panelChoixCouleur;

    private JButton btnCercle;
    private JButton btnRectangle;
    private JButton btnLigne;
    private JButton btnTexte;
    private JButton btnFill;

    private boolean isCercle = false;
    private boolean isRectangle = false;
    private boolean isLigne = false;
    private boolean isTexte = false;

    private ArrayList<Outil> outils;
    private boolean isFill = false;
    
    public FrameDessin(Controleur ctrl, ArrayList<Outil> outils)
    {
        this.ctrl = ctrl;
        this.outils = outils;
        this.setTitle("Dessin");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setBackground(new Color(217,217,217));
        this.setLayout(new BorderLayout());

        
        //création du panel haut
        this.panelHaut = new JPanel();
        this.panelHaut.setBackground(new Color(217,217,217));
        this.panelHaut.setLayout(new GridLayout(1,5));

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

        this.btnTexte = new JButton("Texte");
        this.btnTexte.setBorderPainted(false);
        this.btnTexte.setFocusPainted(false);
        this.btnTexte.setBackground(new Color(217,217,217));

        this.btnFill = new JButton("Remplir");
        this.btnFill.setBorderPainted(false);
        this.btnFill.setFocusPainted(false);
        this.btnFill.setBackground(new Color(217,217,217));

        this.panelHaut.add(this.btnCercle);
        this.panelHaut.add(this.btnRectangle);
        this.panelHaut.add(this.btnLigne);
        this.panelHaut.add(this.btnTexte);
        this.panelHaut.add(this.btnFill);
        
        //création du panel dessin
        this.paneldessin = new PanelDessin(this.ctrl, this);

        //création du panel choix couleur
        this.panelChoixCouleur = new PanelChoixCouleur(this.ctrl);
        this.panelChoixCouleur.setPreferredSize(new Dimension(0, 100));
        
        this.add(this.panelHaut, BorderLayout.NORTH);
        this.add(this.paneldessin, BorderLayout.CENTER);
        this.add(this.panelChoixCouleur,BorderLayout.SOUTH);
        this.setVisible(true);

        this.btnCercle.addActionListener(this);
        this.btnRectangle.addActionListener(this);
        this.btnLigne.addActionListener(this);
        this.btnTexte.addActionListener(this);
        this.btnFill.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == this.btnCercle)
        {
            this.setSelection("Cercle");
            this.paneldessin.cercle(this.isCercle);
            this.btnCercle.setBorderPainted(this.isCercle);
        }
        else if(e.getSource() == this.btnRectangle)
        {
            this.setSelection("Rectangle");
            this.paneldessin.rectangle(this.isRectangle);
            this.btnRectangle.setBorderPainted(this.isRectangle);
        }
        else if(e.getSource() == this.btnLigne)
        {
            this.setSelection("Ligne");
            this.paneldessin.ligne(isLigne);
            this.btnLigne.setBorderPainted(this.isLigne);
        }
        else if(e.getSource() == this.btnTexte)
        {
            this.setSelection("Texte");
            this.paneldessin.texte(isTexte);
            this.btnTexte.setBorderPainted(this.isTexte);
        }
        else if(e.getSource() == this.btnFill)
        {
            this.isFill = !isFill;
            this.paneldessin.remplir(isFill);
            this.btnFill.setBorderPainted(this.isFill);
        }
    }

    private void setSelection(String titre)
    {
        if(titre.equals("Cercle"))
        {
            this.btnCercle.setBorderPainted(true);
            this.btnRectangle.setBorderPainted(false);
            this.btnLigne.setBorderPainted(false);
            this.btnTexte.setBorderPainted(false);

            this.isCercle = !isCercle;
            this.isRectangle = false;
            this.isLigne = false;
            this.isTexte = false;
        }
        else if(titre.equals("Rectangle"))
        {
            this.btnCercle.setBorderPainted(false);
            this.btnRectangle.setBorderPainted(true);
            this.btnLigne.setBorderPainted(false);
            this.btnTexte.setBorderPainted(false);

            this.isRectangle = !isRectangle;
            this.isCercle = false;
            this.isLigne = false;
            this.isTexte = false;
        }
        else if(titre.equals("Ligne"))
        {
            this.btnCercle.setBorderPainted(false);
            this.btnRectangle.setBorderPainted(false);
            this.btnLigne.setBorderPainted(true);
            this.btnTexte.setBorderPainted(false);

            this.isLigne = !isLigne;
            this.isCercle = false;
            this.isRectangle = false;
            this.isTexte = false;
        }
        else if(titre.equals("Texte"))
        {
            this.btnCercle.setBorderPainted(false);
            this.btnRectangle.setBorderPainted(false);
            this.btnLigne.setBorderPainted(false);
            this.btnTexte.setBorderPainted(true);

            this.isTexte = !isTexte;
            this.isCercle = false;
            this.isRectangle = false;
            this.isLigne = false;
        }
    }

    public PanelDessin getPanelDessin() {
        return this.paneldessin;
    }

    public void setPanelDessin(PanelDessin paneldessin) {
        this.paneldessin = paneldessin;
    }

    public void ajouterOutil(Outil outil)
    {
        this.outils.add(outil);
        this.paneldessin.ajouterOutil(outil);
    }

    public void maj()
    {
        this.paneldessin.repaint();
    }


    public void majIHM() {
        this.paneldessin.majIHM();
    }
}
