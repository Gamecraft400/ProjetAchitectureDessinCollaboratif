package net;

import java.io.PrintWriter;
import java.net.Socket;

public class Service implements Runnable
{
    private Socket socket;
    
    public Service(Socket socket)
    {
        this.socket = socket;
    }

    public void run()
    {
        try {
            
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
            out.println("Bonjour");

            socket.close();

        } catch (Exception e) {e.printStackTrace();}        
    }
}

