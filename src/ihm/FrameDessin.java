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
    //singleton
    private static FrameDessin instance = null;

    public static FrameDessin getInstance(Controleur ctrl)
    {
        if(instance == null)
        {
            instance = new FrameDessin(ctrl);
        }
        return instance;
    }
    
    private Controleur ctrl;
    private JPanel panelHaut;
    private PanelDessin paneldessin;
    private PanelChoixCouleur panelChoixCouleur;

    private JButton btnCercle;
    private JButton btnRectangle;
    private JButton btnLigne;
    private JButton btnTexte;

    private boolean isCercle = false;
    private boolean isRectangle = false;
    private boolean isLigne = false;
    private boolean isTexte = false;
    
    public FrameDessin(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setTitle("Dessin");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(new Color(217,217,217));
        this.setLayout(new BorderLayout());

        this.panelChoixCouleur = new PanelChoixCouleur(this.ctrl);

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
        this.paneldessin = new PanelDessin(this.ctrl);

        this.panelHaut.add(this.btnCercle);
        this.panelHaut.add(this.btnRectangle);
        this.panelHaut.add(this.btnLigne);
        this.panelHaut.add(this.btnTexte);

        
        this.add(this.panelChoixCouleur,BorderLayout.SOUTH);
        this.add(this.panelHaut, BorderLayout.NORTH);
        this.add(this.paneldessin, BorderLayout.CENTER);
        this.add(this.panelChoixCouleur,BorderLayout.SOUTH);
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
}
