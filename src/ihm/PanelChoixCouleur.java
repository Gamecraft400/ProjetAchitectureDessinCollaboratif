package ihm;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelChoixCouleur extends JPanel 
{
	private final static Color[] COULEURS_DISPONIBLE = {Color.RED,Color.BLUE,Color.GREEN,Color.YELLOW,Color.BLACK,Color.WHITE};

	private JButton[] tabBtnCoul;

	public PanelChoixCouleur()
	{
		this.tabBtnCoul = new JButton[6];

		for(int cpt = 0; cpt < COULEURS_DISPONIBLE.length; cpt++)
		{
			this.tabBtnCoul[cpt] = new JButton();
			this.tabBtnCoul[cpt].setBackground(COULEURS_DISPONIBLE[cpt]);
		}

		

	}
	
}
