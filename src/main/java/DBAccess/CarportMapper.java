package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.Skur;
import FunctionLayer.Tag;
import FunctionLayer.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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

    public static void createOrdre(Carport carport, Tag tag, Skur skur) throws SQLException, ClassNotFoundException {
        int autoIncKeySkur = createSkur(skur);
        int autoIncKeyCarport = createCarport(carport);
        int autoIncKeyTag = createTag(tag);


        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.ordre (brugerId, carportId, skurId, tagId, dato) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, 1);
            ps.setDouble(2, autoIncKeyCarport);
            ps.setDouble(3, autoIncKeySkur);
            ps.setDouble(4, autoIncKeyTag);
            ps.setString(5, "EKODATO");
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
