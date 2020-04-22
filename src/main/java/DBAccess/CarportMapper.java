package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.CarportException;

import java.sql.*;


public class CarportMapper {
    public static void createCarport(Carport carport) {

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.carport (højde, bredde, længde) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            //ps.setInt( 1, carport.getCarportId());
            ps.setDouble( 2, carport.getHøjde());
            ps.setDouble( 3, carport.getBredde());
            ps.setDouble( 3, carport.getLængde());
            ps.executeUpdate();

            } catch (SQLException | ClassNotFoundException e) {


        }

    }







}
