package metier;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import controleur.Controleur;
import net.Client;
import net.ClientHandler;

public class Metier 
{
    private Controleur ctrl;

    private List<Outil> alOutils;
    private List<Outil> alOutilsServeur;
    private List<Client> alClient;
    private Color couleur;

    //singleton
    private static Metier instance = null;

    public static Metier getInstance(Controleur ctrl)
    {
        if(Metier.instance == null)
            Metier.instance = new Metier(ctrl);

        return Metier.instance;
    }

    private Metier(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.alOutils = new ArrayList<Outil>();
        this.alOutilsServeur = new ArrayList<Outil>();
        this.alClient = new ArrayList<Client>();
    }

    public void ajouterOutil(Outil outil)
    {
        this.alOutils.add(outil);
    }

    public void ajouterClient(String pseudo, String ip)
    {
        Client c = new Client(pseudo, this);
        this.alClient.add(c);
        c.connect(ip, 1234);
        c.run();

    }

    public List<Outil> getOutils()
    {
        return this.alOutils;
    }

    public List<ClientHandler> getAlClients()
    {
        return this.alClient;
    }

    public void ajouterOutil(String outil, Color coul, int x, int y, int width, int height) 
    {
        this.alOutils.add(new Outil(outil, coul, x, y, width, height));
        this.envoieDonnees();
    }

    private void envoieDonnees() {
        String mess = this.alOutils.get(this.alOutils.size()-1).toString();
        this.alClient.get(0).sendMessage(mess);
    }

    public void setCouleur(Color color)
    {
        this.couleur = color;
    }

    public Color getCouleur()
    {
        return this.couleur;
    }

    public void ajouterOutil(String outil, String texte, Color couleur2, int x, int y, int width, int height) 
    {
        this.alOutils.add(new Outil(outil, texte, couleur2, x, y, width, height));
        System.out.println("ajouterOutil METIER");
    }


    public void envoyerOutil(String string) 
    {
        for(ClientHandler client : this.alClient)
        {
            client.envoyerOutil(string);
            System.out.println("envoyerOutil METIER");
        }
    }

    public void ajoutClient(ClientHandler clientHandler) 
    {
        this.alClient.add(clientHandler);
        this.envoieDonnees();
    }

    public List<Outil> getAlOutilsServeur() {
        return alOutilsServeur;
    }

    public void traiterDonnees(String inputLine) {

        String[] lineSplit = inputLine.split(";");

        String outil = lineSplit[0];
        String texte = lineSplit[1];
        String col   = lineSplit[2];
        String x     = lineSplit[3];
        String y     = lineSplit[4];
        String larg  = lineSplit[5];
        String haut  = lineSplit[6];

        if(texte == "")
            this.alOutilsServeur.add( new Outil(    outil,
                                                    new Color(Integer.parseInt(col)) ,
                                                    Integer.parseInt(x),
                                                    Integer.parseInt(y),
                                                    Integer.parseInt(larg),
                                                    Integer.parseInt(haut)) );
        else
            this.alOutilsServeur.add( new Outil(    outil, texte,
                                                    new Color(Integer.parseInt(col)) ,
                                                    Integer.parseInt(x),
                                                    Integer.parseInt(y),
                                                    Integer.parseInt(larg),
                                                    Integer.parseInt(haut)) );

        this.ctrl.majIHM();
    }
}
