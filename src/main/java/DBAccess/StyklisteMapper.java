package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DBAccess.CarportMapper.createOrdre;
import static FunctionLayer.CalculatorSecond.udregnStyklisterFladt;

public class StyklisteMapper {

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

    public static List<Materials> deleteMaterial(int serienummer) throws SQLException, ClassNotFoundException {
        ArrayList<Materials> materialer = new ArrayList<>();
        String SQL = "DELETE FROM fogprojekt.styklisteitems WHERE itemId = ?";

        try {
            Connection con = Connector.connection();

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, serienummer);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return materialer;
    }

    public static void opdaterMateriale(Materials materiale) {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.styklisteitems (beskrivelse, enhed, pris) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materiale.getBeskrivelse());
            ps.setString(2, materiale.getEnhed());
            ps.setInt(3, materiale.getPris());
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void lavStyklisterTilCarport(Carport carport, Tag tag, Skur skur, int stolper, int areal, int spær) {
        int ordreId = 0;
        int serienummer = 0;

        try {
            ordreId = createOrdre(carport, tag, skur);
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
        ArrayList<CalculatedItems> liste = udregnStyklisterFladt(carport, tag, skur);

        for(int i = 0; i < liste.size(); i++) {
            String item = liste.get(i).getItemNavn();

            switch(item){
                case "breddestolper":
                    serienummer = 1;
                    break;
                case "længdestolper":
                    serienummer = 1;
                case "stolper":
                    serienummer = 6;
                case "spær":
                    serienummer = 4;
            }

            try {
                Connection con = Connector.connection();
                String SQL = "INSERT INTO fogprojekt.stykliste (ordreId, serienummer, antal, længde) VALUES (?, ?, ?, ?";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, ordreId);
                ps.setInt(2, serienummer);
                ps.setDouble(3, liste.get(i).getItemAntal());
                ps.setDouble(4, liste.get(i).getItemLængde());
                ps.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.stykliste (ordreId, serienummer, antal, længde) VALUES (?, ?, ?, ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            //serienummer = tag.getTagmateriale();

            ps.setInt(1, ordreId);
            ps.setInt(2, serienummer);
            ps.setDouble(3, areal);
            ps.setDouble(4, 0);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        }
    public static void opdaterPris(int pris, int materialeId) throws SQLException, ClassNotFoundException {
        Connection con = Connector.connection();
        String SQL = "UPDATE fogprojekt.styklisteitems" + " SET pris = ?" + " WHERE itemId = ?";
        PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, pris);
        ps.setInt(2, materialeId);
        ps.executeUpdate();
        System.out.println("Database opdateret");
    }


    public static List<Integer> getStyklisterId() {
        ArrayList<Integer> materialerId = new ArrayList<>();
        String SQL = "SELECT * FROM fogprojekt.styklisteitems WHERE itemId";

        try {
            Connection con = Connector.connection();

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("itemId");
                materialerId.add(id);



            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return materialerId;
    }
}


