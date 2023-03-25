package ihm;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Controleur;
import net.Client;
import net.IpRecup;
import net.Serveur;

public class FrameAccueil extends JFrame implements ActionListener
{
    private Controleur ctrl;

    private Serveur serveur;

    private FrameDessin frameDessin;

    private JPanel panelAccueil;

    private JLabel     lblPseudo;
    private JTextField txtPseudo;
    private JLabel     lblIP;
    private JTextField txtIP;

    private JButton btnCreer;
    private JButton btnRejoindre;


    public FrameAccueil(Controleur ctrl)
    {
        this.ctrl = ctrl;
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

        this.btnCreer.addActionListener(this);
        this.btnRejoindre.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == this.btnCreer)
        {
            if (this.txtPseudo.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Veuillez saisir un pseudo", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                System.out.println("Creer");
                
                serveur = new Serveur();
                serveur.start();

                Client client = new Client(this.ctrl, this.txtPseudo.getText());
                client.connecter("localhost", 1234);

                String ip = IpRecup.getLocalIpAddress();
                System.out.println("IP : " + ip);
                this.dispose();
            
            }
        }
        else if(e.getSource() == this.btnRejoindre)
        {
            if (this.txtPseudo.getText().equals("") || this.txtIP.getText().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Veuillez saisir un pseudo et une adresse IP", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                System.out.println("Rejoindre");

                String pseudo = this.txtPseudo.getText();
                Client client = new Client(this.ctrl, pseudo);

                String ip = this.txtIP.getText();
                client.connecter(ip, 1234);

                this.dispose();
            }
        }
        
    }
}


