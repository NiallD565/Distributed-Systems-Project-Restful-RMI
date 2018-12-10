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
		// establishes connection with database
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CUSTOMERCARS?useSSL=false", "root", "");
		
	}

	@Override
	public List<Order> read() throws SQLException {
		System.out.println("In read");// for early testing

		stmt = conn.createStatement();// to create a SQL statement once a connection is made

		List<Order> List = new ArrayList<Order>();
		String strSelect = "select * from Orders;";// inputs a command into the database

		ResultSet dataset = stmt.executeQuery(strSelect);

		while (dataset.next()) {// loops over the table to get all the values to be displayed
			int OrderID = dataset.getInt("OrderID");
			Date Date = dataset.getDate("Date");
			int cust = dataset.getInt("CustID");
			int car = dataset.getInt("CarID");

			//Order s = new Order();
			Order s = new Order(OrderID, Date, car, cust);

			s.setOrderID(OrderID);
			s.setDate(Date);
			s.setCar(car);
			s.setCust(cust);

			//List.add(s);// for testing on console
		}
		//System.out.println(List);// for testing on console
		return List;
	}

	@Override
	public void createOrder(Order order) throws RemoteException, SQLException {
		System.out.println("In create");

	}

	@Override
	public void deleteOrder(Order order) throws RemoteException, SQLException {
		
	}

}
