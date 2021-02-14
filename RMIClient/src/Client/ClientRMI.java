package Client;
import java.rmi.Naming;
import java.util.List;

import metier.Compte;
import rmi.IBanqueRemote;

public class ClientRMI {

	public static void main(String[] args) {
		try {
			IBanqueRemote stub = (IBanqueRemote) Naming.lookup("rmi://0.0.0.0:1099/banque");
			
			List<Compte> compte =  stub.listComptes();
			int i = 1;
			for(Compte c:compte) {
				System.out.println("*** Consultation du compte "+ i + " ***");
				System.out.println("code = "+ c.getCode());
				System.out.println("Solde en Dollar = "+ c.getSolde());
				System.out.println("Solde en Dirham = "+ stub.conversion(c.getSolde()));
				System.out.println("Date de creation = "+ c.getDateCreation());
				System.out.println();
				i = i+1;
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
