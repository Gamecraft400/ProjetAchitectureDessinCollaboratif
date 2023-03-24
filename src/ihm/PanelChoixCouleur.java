package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

import controleur.Controleur;

public class PanelChoixCouleur extends JPanel implements ActionListener
{
	private final static Color[] COULEURS_DISPONIBLE = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.BLACK,Color.WHITE};
	private Controleur ctrl;

	private JButton[] tabBtnCoul;

	public PanelChoixCouleur(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.tabBtnCoul = new JButton[9];
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		//afficher le contour du panel

		int x = 100;

		this.add(Box.createRigidArea(new Dimension(500,0)));
		for(int cpt = 0; cpt < COULEURS_DISPONIBLE.length; cpt++)
		{
			this.tabBtnCoul[cpt] = new JButton(" ");
			this.tabBtnCoul[cpt].setBackground(COULEURS_DISPONIBLE[cpt]);
			this.tabBtnCoul[cpt].setFocusPainted(false);
			this.tabBtnCoul[cpt].setPreferredSize(new Dimension(50,80));
			this.add(this.tabBtnCoul[cpt]);
			this.add(Box.createRigidArea(new Dimension(50,0)));
			this.tabBtnCoul[cpt].addActionListener(this);
			x += 60;
		}

		this.tabBtnCoul[8] = new JButton("+");
		this.add(tabBtnCoul[8]);
		this.tabBtnCoul[8].addActionListener(this);	

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int cpt = 0; cpt < COULEURS_DISPONIBLE.length; cpt++)
		{
			if(e.getSource().equals(this.tabBtnCoul[cpt]))
			{
				this.ctrl.setCouleur(COULEURS_DISPONIBLE[cpt]);
			}
		}

		if(e.getSource().equals(this.tabBtnCoul[8]))
		{
			Color couleur = JColorChooser.showDialog(this, "Choix de la couleur", Color.BLACK);
			this.tabBtnCoul[8].setBackground(couleur);
			this.ctrl.setCouleur(couleur);
		}
	}
}
