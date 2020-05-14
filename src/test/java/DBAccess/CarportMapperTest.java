package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.CarportException;
import FunctionLayer.LoginSampleException;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

import static org.junit.Assert.*;

public class CarportMapperTest {
    private static Connection testConnection;
    private static String USER = "root";
    private static String USERPW = "MichaelDue20!";
    Carport carport = new Carport(240, 300, 420);

    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
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
    public void testSetUpOK() {
        assertNotNull(testConnection);
    }

    @Test
    public void testCarportCreate() throws CarportException {
        // Can we map to database
        int expected = CarportMapper.createCarport(carport);
        assertTrue(expected != 0);
    }

    @Test
    public void testCreateCarport() {
        String SQL = "INSERT INTO fogprojekt.carport (højde, bredde, længde, materiale) VALUES (?, ?, ?, ?)";
        int id = 0;
        int højde = 0;
        int bredde = 0;
        int længde = 0;
        String mat = "";
        Carport carportTest = null;

        try {
            PreparedStatement ps = testConnection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, carport.getHøjde());
            ps.setDouble(2, carport.getBredde());
            ps.setDouble(3, carport.getLængde());
            ps.setString(4, "sten");
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) id = rs.getInt(1);


            SQL = "SELECT * FROM fogprojekt.carport Where carportId = " + id;
            ps = testConnection.prepareStatement(SQL);
            rs = ps.executeQuery();
            if (rs.next()) {
                højde = rs.getInt("højde");
                bredde = rs.getInt("bredde");
                længde = rs.getInt("længde");
                mat = rs.getString("materiale");

            }

            carportTest = new Carport(højde, bredde, længde);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        assertEquals(carport.getHøjde(), carportTest.getHøjde(), 1);
        assertEquals(carport.getBredde(), carportTest.getBredde(), 1);
        assertEquals(carport.getLængde(), carportTest.getLængde(), 1);

    }


}
