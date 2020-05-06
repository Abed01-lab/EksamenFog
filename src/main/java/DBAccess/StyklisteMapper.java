package DBAccess;

import FunctionLayer.Carport;
import FunctionLayer.Materials;
import FunctionLayer.Skur;
import FunctionLayer.Tag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DBAccess.CarportMapper.createOrdre;

public class StyklisteMapper {

    public static List<Materials> getFladtStyklister(int kvm) throws SQLException, ClassNotFoundException {
        ArrayList<Materials> materialer = new ArrayList<>();
        String SQL = "SELECT * FROM fogprojekt.fladttagstyklister";

        try {
            Connection con = Connector.connection();

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("idFladtTagStyklister");
                String deminsion = rs.getString("deminsion");
                double længde = rs.getDouble("længde");
                System.out.println(længde);
                double antal = rs.getDouble("antal");
                String enhed = rs.getString("enhed");
                String beskrivelse = rs.getString("beskrivelse");


                længde = længde * kvm;
                antal = antal * kvm;
                int længdeInt = (int) længde;
                int antalInt = (int) antal;

                //Materials materialInstance = new Materials(deminsion, længdeInt, antalInt, enhed, beskrivelse);
                //materialer.add(materialInstance);

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return materialer;
    }

    public static List<Materials> getStyklister() throws SQLException, ClassNotFoundException {
        ArrayList<Materials> materialer = new ArrayList<>();
        String SQL = "SELECT * FROM fogprojekt.styklisteitems";

        try {
            Connection con = Connector.connection();

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("itemId");
                String beskrivelse = rs.getString("beskrivelse");
                String enhed = rs.getString("enhed");
                int pris = rs.getInt("pris");

                Materials materialInstance = new Materials(id, beskrivelse, enhed, pris);
                materialer.add(materialInstance);

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return materialer;
    }


    public static void lavStyklisterTilCarport(Carport carport, Tag tag, Skur skur, int stolper, int areal, int spær) {
        try {
            int ordreId = createOrdre(carport, tag, skur);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            List<Materials> materialer = getStyklister();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 4; i++) {
            try {
                Connection con = Connector.connection();
                String SQL = "INSERT INTO fogprojekt.stykliste () VALUES (?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

                ps.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
    /*
    public static List<Materials> getSkråStyklister(int kvm) throws SQLException, ClassNotFoundException {
        ArrayList<Materials> materialer = new ArrayList<>();
        String SQL = "SELECT * FROM fogprojekt.skråtagstyklister";

        try {
            Connection con = Connector.connection();

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("idSkråTagStyklister");
                String deminsion = rs.getString("deminsion");
                double længde = rs.getDouble("længde");
                double antal = rs.getDouble("antal");
                String enhed = rs.getString("enhed");
                String beskrivelse = rs.getString("beskrivelse");

                længde = længde * kvm;
                antal = antal * kvm;

                Materials materialInstance = new Materials(deminsion, Math.ceil(længde), Math.ceil(antal), enhed, beskrivelse);
                materialer.add(materialInstance);

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return materialer;
    }

   /* public static void opdaterMaterialeFladtTag(Materials materiale) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.fladttagstyklister (deminsion, længde, antal, enhed, beskrivelse) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materiale.getDeminsion());
            ps.setFloat(2, materiale.getLængde());
            ps.setFloat(3, materiale.getAntal());
            ps.setString(4, materiale.getEnhed());
            ps.setString(5, materiale.getBeskrivelse());
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void opdaterMaterialeSkråTag(Materials materiale) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.skråtagstyklister (deminsion, længde, antal, enhed, beskrivelse) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materiale.getDeminsion());
            ps.setFloat(2, materiale.getLængde());
            ps.setFloat(3, materiale.getAntal());
            ps.setString(4, materiale.getEnhed());
            ps.setString(5, materiale.getBeskrivelse());
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}*/

