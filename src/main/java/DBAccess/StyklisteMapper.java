package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static DBAccess.CarportMapper.createOrdre;
import static FunctionLayer.Calculator.*;

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

    public static ArrayList<Stykliste> getStykliste(){
        ArrayList<Stykliste> overlist = new ArrayList<Stykliste>();
        // liste, ordreid
        int count = 0;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogprojekt.stykliste";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("ordreId");
                boolean repeat = true;

                for(int i = 0; i < overlist.size(); i++) {
                    if (overlist.get(i).getOrdreId() == id){
                        repeat = false;
                        count = count + 1;
                        System.out.println(count);
                    }
                }

                if(repeat) {

                    ArrayList<StyklisteDetaljer> list = new ArrayList<StyklisteDetaljer>();

                    int serienummer = rs.getInt("serienummer");
                    int antal = rs.getInt("antal");
                    int længde = rs.getInt("længde");
                    StyklisteDetaljer styk = new StyklisteDetaljer(serienummer, antal, længde);
                    list.add(styk);

                    while (id == rs.getInt("ordreId") && rs.next()) {
                        serienummer = rs.getInt("serienummer");
                        antal = rs.getInt("antal");
                        længde = rs.getInt("længde");
                        StyklisteDetaljer styk2 = new StyklisteDetaljer(serienummer, antal, længde);
                        list.add(styk2);
                    }
                    Stykliste stykliste = new Stykliste(id, list);
                    overlist.add(stykliste);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return overlist;
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
        ArrayList<CalculatedItems> liste;
        if(tag.getHældning() != 0){
            liste = udregnStyklisterSkråt(carport, tag, skur);
        }
        else {
            liste = udregnStyklisterFladt(carport, tag, skur);
        }

        for(int h = 0; h < liste.size(); h++){
            System.out.println(liste.get(h).getItemNavn());
        }

        for(int i = 0; i < liste.size(); i++) {
            String itemName = liste.get(i).getItemNavn();

            switch(itemName){
                case "breddestolper":
                    serienummer = 2;
                    break;
                case "længdestolper":
                    serienummer = 4;
                    break;
                case "stolper":
                    serienummer = 6;
                    break;
                case "spær":
                    serienummer = 5;
                    break;
                case "lægter":
                    serienummer = 7;
                    break;
            }

            try {
                Connection con = Connector.connection();
                String SQL = "INSERT INTO fogprojekt.stykliste (ordreId, serienummer, antal, længde) VALUES (?, ?, ?, ?)";
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
            String SQL = "INSERT INTO fogprojekt.stykliste (ordreId, serienummer, antal, længde) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            //serienummer = tag.getTagmateriale();
            double areal = beregnTagAreal(carport, tag);
            ps.setInt(1, ordreId);
            ps.setInt(2, 2);
            ps.setDouble(3, areal);
            ps.setDouble(4, 0);
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Carport carport = new Carport(220, 400,720);
        Tag tag = new Tag("Fladt", 15, "Sten");
        Skur skur = new Skur(300, 420);
        lavStyklisterTilCarport(carport, tag, skur);

       /* ArrayList<CalculatedItems> liste = udregnStyklisterSkråt(carport, tag, skur);
        for(int i = 0; i < liste.size(); i++)
            System.out.println(liste.get(i).getItemAntal()); */

        ArrayList<Stykliste> styklist = getStykliste();

        for(int i = 0; i < styklist.size(); i++){
            System.out.println("Ordre : " + styklist.get(i).getOrdreId());
            for(int h = 0; h < styklist.get(i).getListe().size(); h++){
                System.out.println(styklist.get(i).getListe().get(h).getLængde());
            }
        }

        //lavStyklisterTilCarport(carport, tag, skur);
        //kør først denne hvis ikke virker

        for(int i = 0; i < styklist.size(); i++){
            System.out.println("Ordre : " + styklist.get(i).getOrdreId());
            for(int h = 0; h < styklist.get(i).getListe().size(); h++){
                System.out.println(styklist.get(i).getListe().get(h));
            }
        }
        System.out.println("HER:" + styklist.size());

    }
}


