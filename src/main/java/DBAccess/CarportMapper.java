package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.CarportException;
import FunctionLayer.Skur;
import FunctionLayer.Tag;

import java.sql.*;
import java.util.Calendar;


public class CarportMapper {

    public static int createCarport(Carport carport) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.carport (højde, bredde, længde, materiale) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, carport.getHøjde());
            ps.setDouble(2, carport.getBredde());
            ps.setDouble(3, carport.getLængde());
            ps.setString(4, "træ");
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            throw new CarportException("Fejl i oprettelse af carport");
        }
    }

    public static int createSkur(Skur skur) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.skur (bredde, længde) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, skur.getBredde());
            ps.setDouble(2, skur.getLængde());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            throw new CarportException("Fejl i oprettelse af skur");
        }
    }

    public static int createTag(Tag tag) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.tag (tag.type, hældning, materiale) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tag.getType());
            ps.setDouble(2, tag.getHældning());
            ps.setString(3, tag.getMateriale());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            throw new CarportException("Fejl i oprettelse af tag");
        }
    }

    public static Carport getCarport(int carportId) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogprojekt.carport WHERE carportId = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, carportId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int højde = rs.getInt("højde");
                int længde = rs.getInt("længde");
                int bredde = rs.getInt("bredde");
                String materiale = rs.getString("materiale");
                return new Carport(højde, bredde, længde, materiale);
            } else {
                throw new CarportException("Der findes ingen carport med id: " + carportId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new CarportException("Fejl ved indhentning af carport: " + carportId);
        }
    }

    public static Tag getTag(int tagId) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogprojekt.tag WHERE tagId = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tagId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String type = rs.getString("type");
                int hældning = rs.getInt("hældning");
                String materiale = rs.getString("materiale");
                return new Tag(type, hældning, materiale);
            } else {
                throw new CarportException("Der findes ingen tag med id: " + tagId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new CarportException("Fejl ved indhentning af tag: " + tagId);
        }
    }

    public static Skur getSkur(int skurId) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogprojekt.skur WHERE skurId = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, skurId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int længde = rs.getInt("længde");
                int bredde = rs.getInt("bredde");
                return new Skur(bredde, længde);
            } else {
                throw new CarportException("Der findes ingen skur med id: " + skurId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new CarportException("Fejl ved indhentning af skur: " + skurId);
        }
    }
}
