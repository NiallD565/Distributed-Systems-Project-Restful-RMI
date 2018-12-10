package ie.gmit.sw.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ie.gmit.sw.Model.Order;

public class DatabaseServiceImpl extends UnicastRemoteObject implements DatabaseService {

	private static final long serialVersionUID = 1l;
	private Connection conn;
	private Statement stmt;

	protected DatabaseServiceImpl() throws RemoteException, SQLException {
		super();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CUSTOMERCARS?useSSL=false", "root", "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Order> read() throws SQLException {
		System.out.println("In read");

		stmt = conn.createStatement();

		List<Order> List = new ArrayList<Order>();
		String strSelect = "select * from orders ORDER BY OrderID";

		ResultSet dataset = stmt.executeQuery(strSelect);

		while (dataset.next()) {
			int OrderID = dataset.getInt("OrderID");
			Date Date = dataset.getDate("Date");
			int cust = dataset.getInt("CustID");
			int car = dataset.getInt("CarID");

			Order s = new Order(OrderID, Date, cust, car);
			// Order s = new Order(car, Date, car, car);

			s.setOrderID(OrderID);
			s.setDate(Date);
			s.setCar(car);
			s.setCust(cust);

			List.add(s);
		}
		return List;
	}

	@Override
	public void createOrder(Order order) throws RemoteException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(Order order) throws RemoteException, SQLException {
		// TODO Auto-generated method stub
		
	}

}
