package ie.gmit.sw.RestfulJersey;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ie.gmit.sw.Model.Order;
import ie.gmit.sw.RMI.DatabaseService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws NotBoundException 
     * @throws RemoteException 
     * @throws MalformedURLException 
     * @throws SQLException 
     */
    @GET
    @Path("read")
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> getIt() throws MalformedURLException, RemoteException, NotBoundException, SQLException {
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/JDBC");
    	System.out.println("Read entered");
    	// ds.read();
        return ds.read();
    }
	

    @PUT
    @Path("create")
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> putIt() throws MalformedURLException, RemoteException, NotBoundException, SQLException {
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/JDBC");
		System.out.println("Put entered");
		/*
		int OrderID = dataset.getInt("OrderID");
		Date Date = dataset.getDate("Date");
		int cust = dataset.getInt("CustID");
		int car = dataset.getInt("CarID");
		
		return ds.createOrder(OrderID, Date, car, cust);
		*/
		return null;
    }
    /*
	@GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/read")
    public String getIt() throws MalformedURLException, RemoteException, NotBoundException, SQLException {
    	//DatabaseService ds;
    	//ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/JDBC");
    	System.out.println("Read entered");
    	// ds.read();
        return "Hello";
	}
	*/
	
}
