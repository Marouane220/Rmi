package serveur;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmi.BanqueRMIService;

public class ServeurRmi {
	
	public static void main(String[] args) throws MalformedURLException {
		try {
			LocateRegistry.createRegistry(1099);
			BanqueRMIService objet = new BanqueRMIService();
			Naming.rebind ("rmi://0.0.0.0:1099/banque" , objet);
			System.out.println(objet.toString());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
