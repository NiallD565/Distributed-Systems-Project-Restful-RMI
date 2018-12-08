package ie.gmit.sw.RestfulJersey;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
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
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/read")
    public List<Order> getIt() throws MalformedURLException, RemoteException, NotBoundException, SQLException {
    	DatabaseService ds;
    	ds = (DatabaseService) Naming.lookup("rmi://127.0.0.1:1099/JDBC");
    	
    	ds.read();
        return ds.read();
    }
}
