package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.CarportException;
import FunctionLayer.Skur;
import FunctionLayer.Tag;

import java.sql.*;
import java.util.Calendar;


public class CarportMapper {

    public static int createCarport(Carport carport) {
        int autoIncKeyCarport = -1;
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.carport (højde, bredde, længde, materiale) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, carport.getHøjde());
            ps.setDouble(2, carport.getBredde());
            ps.setDouble(3, carport.getLængde());
            ps.setString(4, "sten");
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                autoIncKeyCarport = rs.getInt(1);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return autoIncKeyCarport;
    }

    public static int createSkur(Skur skur) {
        int autoIncKeySkur = -1;
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.skur (skurbredde, skurlængde) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, skur.getBredde());
            ps.setDouble(2, skur.getLængde());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            autoIncKeySkur = rs.getInt(1);
            if (rs.next()) {
                autoIncKeySkur = rs.getInt(1);
            }

        } catch (SQLException | ClassNotFoundException e) {
        }
        return autoIncKeySkur;
    }

    public static int createTag(Tag tag) {
        int autoIncKeyTag = -1;
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.tag (tagtype, taghældning, tagmateriale) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tag.getTagtype());
            ps.setDouble(2, tag.getHældning());
            ps.setString(3, tag.getTagmateriale());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            autoIncKeyTag = rs.getInt(1);
            if (rs.next()) {
                autoIncKeyTag = rs.getInt(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
        }
        return autoIncKeyTag;
    }

    public static int createOrdre(Carport carport, Tag tag, Skur skur) throws SQLException, ClassNotFoundException {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date datoObjekt = new java.sql.Date(calendar.getTime().getTime());

        int autoIncKeySkur = createSkur(skur);
        int autoIncKeyCarport = createCarport(carport);
        int autoIncKeyTag = createTag(tag);
        int autoIncKey = -1;
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.ordre (brugerId, carportId, skurId, tagId, dato) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, 1);
            ps.setDouble(2, autoIncKeyCarport);
            ps.setDouble(3, autoIncKeySkur);
            ps.setDouble(4, autoIncKeyTag);
            ps.setDate(5, datoObjekt);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            autoIncKey = rs.getInt(1);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return autoIncKey;
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
                String type = rs.getString("tagtype");
                int hældning = rs.getInt("taghældning");
                String materiale = rs.getString("tagmateriale");

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
                int længde = rs.getInt("skurlængde");
                int bredde = rs.getInt("skurbredde");
                return new Skur(bredde, længde);
            } else {
                throw new CarportException("Der findes ingen skur med id: " + skurId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new CarportException("Fejl ved indhentning af skur: " + skurId);
        }
    }
}
