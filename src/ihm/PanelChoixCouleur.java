package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Controleur;

public class PanelChoixCouleur extends JPanel implements ActionListener
{
	private final static Color[] COULEURS_DISPONIBLE = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.BLACK,Color.WHITE};
	private Controleur ctrl;

	private JButton[] tabBtnCoul;

	public PanelChoixCouleur(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.tabBtnCoul = new JButton[8];
		this.setLayout(new GridLayout(1,8,150,0));

		this.add(new JLabel());

		for(int cpt = 0; cpt < COULEURS_DISPONIBLE.length; cpt++)
		{
			this.tabBtnCoul[cpt] = new JButton();
			this.tabBtnCoul[cpt].setBackground(COULEURS_DISPONIBLE[cpt]);
			this.add(new DispoBouton(tabBtnCoul[cpt]));
		}	

		this.add(new JLabel());

	}
	
	class DispoBouton extends JPanel
	{
		public DispoBouton(JButton btnAction)
		{
			this.setLayout(new BorderLayout());
			this.add(btnAction,BorderLayout.CENTER);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int cpt = 0; cpt < COULEURS_DISPONIBLE.length; cpt++)
		{
			if(e.getSource() == this.tabBtnCoul[cpt])
			{
				this.ctrl.setCouleur(COULEURS_DISPONIBLE[cpt]);
			}
		}
	}
}
