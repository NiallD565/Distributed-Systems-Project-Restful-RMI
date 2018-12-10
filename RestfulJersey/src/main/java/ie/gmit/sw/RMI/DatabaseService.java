package ie.gmit.sw.RMI;

import java.util.List;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

import ie.gmit.sw.Model.Order;

public interface DatabaseService extends Remote{
	public List<Order> read() throws RemoteException, SQLException;
	
	void createOrder(Order order)throws RemoteException, SQLException;
	
	void deleteOrder(Order order)throws RemoteException, SQLException;
}
