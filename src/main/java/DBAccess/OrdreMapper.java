package DBAccess;

import FunctionLayer.CarportException;
import FunctionLayer.Ordre;

import java.sql.*;
import java.util.ArrayList;

public class OrdreMapper {
    public static int createOrdre(Ordre ordre) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.ordre (dato, forespørgselsId) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ordre.getDato());
            ps.setInt(2, ordre.getForespørgselsId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new CarportException("Fejl ved oprettelse af ordre");

        }
    }


    public static ArrayList<Ordre> getAllOrdrer() throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogprojekt.ordre";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            ArrayList<Ordre> kundeOrdrer = new ArrayList();
            while (rs.next()) {
                int id = rs.getInt("id");
                String dato = rs.getString("dato");
                int forespørgselsId = rs.getInt("forespørgselsId");

                Ordre ordre = new Ordre(id, dato, forespørgselsId);
                kundeOrdrer.add(ordre);
            }
            return kundeOrdrer;
        } catch (SQLException | ClassNotFoundException e) {
            throw new CarportException("Fejl ved indhentning af ordrer");
        }
    }
}
