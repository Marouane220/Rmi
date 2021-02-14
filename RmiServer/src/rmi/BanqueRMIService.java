package rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import metier.Compte;

public class BanqueRMIService extends UnicastRemoteObject implements IBanqueRemote{

	public BanqueRMIService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public double conversion(double montant) throws RemoteException {
		return montant*8.9;
	}

	@Override
	public Compte consulterCompte(int code) throws RemoteException {
		Compte compte = new Compte(1, 1000, new Date());
		return compte;
	}

	@Override
	public List<Compte> listComptes() throws RemoteException {
		List<Compte> comptes = new ArrayList<Compte>();
		for(int i=1; i<6; i++) {
			comptes.add(new Compte(i, i*1000, new Date()));
		}
		return comptes;
	}
}
