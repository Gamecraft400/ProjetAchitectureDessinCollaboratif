package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelChoixCouleur extends JPanel 
{
	private final static Color[] COULEURS_DISPONIBLE = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.BLACK,Color.WHITE};

	private JButton[] tabBtnCoul;

	public PanelChoixCouleur()
	{
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
}
