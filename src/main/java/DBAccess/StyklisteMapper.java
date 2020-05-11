package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DBAccess.CarportMapper.createOrdre;
import static FunctionLayer.CalculatorSecond.udregnStyklisterFladt;

public class StyklisteMapper {

    public static List<Materials> getStyklister() {
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

    public static void opdaterPris(int pris, int materialeId) {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE fogprojekt.styklisteitems SET pris = ? WHERE itemId = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pris);
            ps.setInt(2, materialeId);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMaterial(int serienummer) {
        try {
            Connection con = Connector.connection();
            String SQL = "DELETE FROM fogprojekt.styklisteitems WHERE itemId = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, serienummer);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getStykliste(){
        ArrayList<Stykliste> overlist = new ArrayList<Stykliste>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogprojekt.stykliste";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ArrayList<StyklisteDetaljer> list = new ArrayList<StyklisteDetaljer>();
                int id = rs.getInt("ordreId");
                    while(id == rs.getInt("ordreId") && rs.next()){
                        int serienummer = rs.getInt("serienummer");
                        int antal = rs.getInt("antal");
                        int længde = rs.getInt("længde");
                        StyklisteDetaljer styk = new StyklisteDetaljer(serienummer, antal, længde);
                        list.add(styk);
                    }
                Stykliste stykliste = new Stykliste(id, list);
                    overlist.add(stykliste);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void lavStyklisterTilCarport(Carport carport, Tag tag, Skur skur) {
        int ordreId = 0;
        int serienummer = 0;

        try {
            ordreId = createOrdre(carport, tag, skur);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Materials> materialer = getStyklister();
        ArrayList<CalculatedItems> liste = udregnStyklisterFladt(carport, tag, skur);


        for(int i = 1; i < 4; i++) {
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
                String SQL = "INSERT INTO fogprojekt.stykliste (ordreId, serienummer, antal, længde) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, ordreId);
                ps.setInt(2, 2);
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
            String SQL = "INSERT INTO fogprojekt.stykliste (ordreId, serienummer, antal, længde) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            //serienummer = tag.getTagmateriale();

            ps.setInt(1, ordreId);
            ps.setInt(2, 2);
            ps.setDouble(3, 5);
            ps.setDouble(4, 0);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Carport carport = new Carport(240, 400,720);
        Tag tag = new Tag("Fladt", 0, "Sten");
        Skur skur = new Skur(300, 420);
        lavStyklisterTilCarport(carport, tag, skur);

        ArrayList<CalculatedItems> liste = udregnStyklisterFladt(carport, tag, skur);
        for(int i = 0; i < liste.size(); i++)
            System.out.println(liste.get(i).getItemAntal());
    }
}


