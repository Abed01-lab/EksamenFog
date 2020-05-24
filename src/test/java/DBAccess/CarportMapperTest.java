package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.CarportException;
import FunctionLayer.LoginSampleException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class CarportMapperTest {
    private static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "Fokken9797";

    @BeforeClass
    public static void setUp() {
        try {
            if (testConnection == null) {
                String url = "jdbc:mysql://localhost:3306/fogprojekt_test?serverTimezone=CET&useSSL=false";
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

    @Before
    public void beforeEachTest() {
        try(Statement stmt = testConnection.createStatement()) {
            stmt.execute("drop table if exists carport;");
            stmt.execute("create table `carport` like fogprojekt.carport;");
            stmt.execute("insert into carport values" +
                    "(1, 200, 240, 240, 'træ')," +
                    "(2, 215, 300, 300, 'træ')," +
                    "(3, 230, 360, 360, 'træ')," +
                    "(4, 245, 420, 420, 'træ')," +
                    "(5, 260, 480, 480, 'træ');");

        } catch (SQLException ex) {
            System.out.println("Could not open connection to database: " + ex.getMessage());
        }

    }

    @Test
    public void testSetUpOK() {
        assertNotNull(testConnection);
    }

    @Test
    public void testCarportCreate() throws CarportException {
        // Can we map to database
        Carport carport = new Carport(240, 300, 420);
        int expectedID = CarportMapper.createCarport(carport);
        assertNotNull(CarportMapper.getCarport(expectedID));
    }

    @Test (expected = CarportException.class)
    public void testForFail() throws CarportException {
        Carport carport = new Carport(6,240, 300, 420, "træ");
        assertNotNull(CarportMapper.getCarport(carport.getId()));
    }

    @Test
    public void testCarportArray() throws CarportException {
        ArrayList<Carport> cp = CarportMapper.getAllCarport();
        assertThat(cp, hasSize(5));
    }

    @Test
    public void testCarportArrayMedTilføjCarport() throws  CarportException{
        Carport carport = new Carport(240, 300, 420);
        int id = CarportMapper.createCarport(carport);
        ArrayList<Carport> cp = CarportMapper.getAllCarport();
        assertThat(cp, hasSize(6));
    }

}



