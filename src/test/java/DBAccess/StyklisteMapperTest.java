package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.CarportException;
import FunctionLayer.Materials;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class StyklisteMapperTest {
    private static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "MichaelDue20!";
    Carport carport = new Carport(240, 300, 420);

    @Before
    public void setUp() {
        try {
            // avoid making a new connection for each test
            if (testConnection == null) {
                String url = "jdbc:mysql://localhost:3306/fogprojekt?serverTimezone=CET&useSSL=false";
                Class.forName("com.mysql.cj.jdbc.Driver");

                testConnection = DriverManager.getConnection(url, USER, USERPW);
                // Make mappers use test
                Connector.setConnection(testConnection);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            testConnection = null;
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }
    }

    @Test
    public void testGetStyklister() throws CarportException {
        ArrayList<Materials> materialer = StyklisteMapper.getStyklister();
        assertTrue(materialer != null);
    }
}
