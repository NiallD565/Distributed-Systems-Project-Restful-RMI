package ie.gmit.sw.RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.SQLException;

public class ServiceSetup {
	public static void main(String[] args) throws MalformedURLException, RemoteException, SQLException {
		DatabaseService ds = (DatabaseService) new DatabaseServiceImpl();
		LocateRegistry.createRegistry(1099);
		Naming.rebind("JDBC", ds);// Binds the database name for later reference
		System.out.println("Server started");// for testing
	}
}
