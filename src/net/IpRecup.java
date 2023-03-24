package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpRecup 
{
    public static String getLocalIpAddress() 
    {
        try {

            InetAddress inetAddress = InetAddress.getLocalHost();
            return inetAddress.getHostAddress();
            
        } catch (UnknownHostException e) {
            System.out.println("Erreur lors de la récupération de l'adresse IP : " + e.getMessage());
            return null;
        }
    }
}
