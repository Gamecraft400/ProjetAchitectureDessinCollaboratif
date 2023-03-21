package ihm;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameAccueil extends JFrame
{
    private JPanel panelAccueil;

    private JLabel     lblPseudo;
    private JTextField txtPseudo;
    private JLabel     lblIP;
    private JTextField txtIP;

    private JButton btnCreer;
    private JButton btnRejoindre;

    public FrameAccueil()
    {
        this.setTitle("Accueil");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBackground(new Color(217,217,217));

        //Creation du panel Accueil
        this.panelAccueil = new JPanel();
        this.panelAccueil.setBackground(new Color(217,217,217));
        this.panelAccueil.setLayout(null);

        //Creation des composants
        this.lblPseudo = new JLabel("Pseudo : ");
        this.lblPseudo.setBounds(100, 100, 100, 20);
        this.txtPseudo = new JTextField(10);
        this.txtPseudo.setBounds(200, 100, 200, 20);
        this.txtPseudo.setBorder(null);
        
        this.lblIP = new JLabel("IP : ");
        this.lblIP.setBounds(100, 140, 100, 20);
        this.txtIP = new JTextField(15);
        this.txtIP.setBounds(200, 140, 200, 20);
        this.txtIP.setBorder(null);
    
        this.btnCreer = new JButton("Creer");
        this.btnCreer.setBorderPainted(false);
        this.btnCreer.setFocusPainted(false);
        this.btnCreer.setBackground(new Color(156,87,71));
        this.btnCreer.setBounds(100, 180, 150, 50);
        
        this.btnRejoindre = new JButton("Rejoindre");
        this.btnRejoindre.setBorderPainted(false);
        this.btnRejoindre.setFocusPainted(false);
        this.btnRejoindre.setBackground(new Color(156,87,71));
        this.btnRejoindre.setBounds(260, 180, 150, 50);

        //Ajout des composants au panel
        this.panelAccueil.add(this.lblPseudo);
        this.panelAccueil.add(this.txtPseudo);
        this.panelAccueil.add(this.lblIP);
        this.panelAccueil.add(this.txtIP);
        this.panelAccueil.add(this.btnCreer);
        this.panelAccueil.add(this.btnRejoindre);
       
        //Ajout du panel à la frame
        this.add(this.panelAccueil);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
        new FrameAccueil();
    }
}