package net;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import ihm.FrameDessin;
import ihm.PanelDessin;

public class ClientHandler implements Runnable 
{

    private Socket clientSocket;
    private Serveur server;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket clientSocket, Serveur server) 
    {
        this.clientSocket = clientSocket;
        this.server = server;

        try {

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) {
            System.out.println("Erreur lors de la création du clientHandler : " + e.getMessage());
        }
    }

    @Override
    public void run() 
    {
        try {

            byte[] inputObject;
            
            while(inputObject = in.readObject() != null)
            {
                // Réception du panelDessin
                panelDessin = (PanelDessin) in.readObject();

                // Envoi du panelDessin à tous les clients
                server.sendPanelDessin(panelDessin);
            }
            
            // Le client s'est déconnecté
            server.removeClient(this);
            in.close();
            out.close();
            clientSocket.close();


        } catch (IOException e) {
            System.out.println("Erreur lors de la communication avec le client " + clientSocket + " : " + e.getMessage());
            server.removeClient(this);
        }
    }

    public void sendMessage(String message) 
    {
        out.println(message);
    }

    public void sendPanelDessin(PanelDessin panelDessin) 
    {
        try {

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(panelDessin);
            byte[] data = byteArrayOutputStream.toByteArray();
    
            // Envoi du tableau de bytes contenant le panelDessin au client
            OutputStream outputStream = clientSocket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            
            dataOutputStream.writeInt(data.length);
            dataOutputStream.write(data);
            dataOutputStream.flush();
            
        } catch (IOException e) {
            System.err.println("Erreur lors de l'envoi du panelDessin au client.");
            e.printStackTrace();
        }
    }

    public Socket getClientSocket() 
    {
        return this.clientSocket;
    }

}