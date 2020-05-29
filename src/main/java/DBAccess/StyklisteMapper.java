package DBAccess;

import FunctionLayer.*;

import java.sql.*;
import java.util.ArrayList;

import static FunctionLayer.Calculator.*;

public class StyklisteMapper {

    public static ArrayList<Materials> getStyklister() throws CarportException {
        ArrayList<Materials> materialer = new ArrayList<>();
        String SQL = "SELECT * FROM fogprojekt.styklisteitems;";

        try {
            System.out.println("virker");
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
            throw new CarportException("Fejl ved indhentning af styklister");
        }
        return materialer;
    }

    public static void opdaterMateriale(Materials materiale) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.styklisteitems (beskrivelse, enhed, pris) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materiale.getBeskrivelse());
            ps.setString(2, materiale.getEnhed());
            ps.setDouble(3, materiale.getPris());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new CarportException("Fejl ved opdatering af materiale");
        }
    }

    public static void opdaterPris(int pris, int materialeId) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE fogprojekt.styklisteitems SET pris = ? WHERE itemId = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pris);
            ps.setInt(2, materialeId);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new CarportException("Fejl ved opdatering af pris");
        }
    }

    public static void opdaterStandardStykliste(String styklisteType, int serienummer) {
        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE fogprojekt.styklistedefault SET styklisteitemId = '" + serienummer + "' WHERE item = '" + styklisteType + "'";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMaterial(int serienummer) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "DELETE FROM fogprojekt.styklisteitems WHERE itemId = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, serienummer);
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new CarportException("Fejl ved fjernelse af materiale");
        }
    }

    public static Stykliste getStykliste(int forespørgselsId) throws CarportException {
        ArrayList<Stykliste> styklister = getAllStyklister();
        for (int i = 0; i < styklister.size(); i++) {
            Stykliste stykliste = styklister.get(i);
            if (stykliste.getForespørgselsId() == forespørgselsId) {
                return stykliste;
            }
        }
        throw new CarportException("Fejl ved indhentning af stykliste");
    }

    public static ArrayList<String> getTagMaterialer() {
        ArrayList<String> liste = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogprojekt.styklisteitems";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String tag = rs.getString("beskrivelse");
                String type = rs.getString("enhed");
                if (type.equals("Tag")) {
                    liste.add(tag);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return liste;
    }

    public static int getTagId(String tagNavn) {
        int tagId = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogprojekt.styklisteitems WHERE beskrivelse = '" + tagNavn + "'";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tagId = rs.getInt("itemId");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return tagId;
    }


    public static double getStyklistePris(int id) throws CarportException {
        double total = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT stykliste.forespørgselsId, stykliste.antal, stykliste.længde, styklisteitems.pris " +
                    "FROM stykliste " +
                    "INNER JOIN styklisteitems ON stykliste.serienummer = styklisteitems.itemId " +
                    "WHERE stykliste.forespørgselsId = '" + id + "'";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int antal = rs.getInt("antal");
                int længde = rs.getInt("længde");
                int pris = rs.getInt("pris");

                if (længde != 0) {
                    double sum = (((double) længde / 100) * pris) * antal;
                    total = total + sum;
                } else {
                    double sum = pris * antal;
                    total = total + sum;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new CarportException("Fejl ved indhentning af stykliste priser");
        }
        return total;
    }

    public static ArrayList<Stykliste> getAllStyklister() throws CarportException {
        ArrayList<Stykliste> overlist = new ArrayList();
        // liste, ordreid
        int count = 0;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogprojekt.stykliste";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("forespørgselsId");
                boolean repeat = true;

                for (int i = 0; i < overlist.size(); i++) {
                    if (overlist.get(i).getForespørgselsId() == id) {
                        repeat = false;
                    }
                }

                if (repeat) {

                    ArrayList<StyklisteDetaljer> list = new ArrayList<StyklisteDetaljer>();

                    String SQL2 = "SELECT * FROM fogprojekt.stykliste WHERE forespørgselsId = '" + id + "'";
                    PreparedStatement ps2 = con.prepareStatement(SQL2, Statement.RETURN_GENERATED_KEYS);
                    ResultSet rs2 = ps2.executeQuery();

                    while (rs2.next()) {
                        int serienummer = rs2.getInt("serienummer");
                        int antal = rs2.getInt("antal");
                        int længde = rs2.getInt("længde");

                        String SQL3 = "SELECT * FROM fogprojekt.styklisteitems WHERE itemId = '" + serienummer + "'";
                        PreparedStatement ps3 = con.prepareStatement(SQL3, Statement.RETURN_GENERATED_KEYS);
                        ResultSet rs3 = ps3.executeQuery();
                        String beskrivelse = "temp";
                        while (rs3.next()) {
                            beskrivelse = rs3.getString("beskrivelse");
                        }

                        StyklisteDetaljer styk = new StyklisteDetaljer(serienummer, beskrivelse, antal, længde);
                        list.add(styk);
                    }

                    Stykliste stykliste = new Stykliste(id, list);
                    overlist.add(stykliste);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new CarportException("Fejl ved indhentning  asd af stykliste");
        }
        return overlist;
    }

    public static int getStandardStykliste(String itemName) {
        int serienummer = 0;
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogprojekt.styklistedefault WHERE item = '" + itemName + "'";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                serienummer = rs.getInt("styklisteitemId");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return serienummer;
    }

    public static void lavStyklisterTilCarport(int forespørgselsId, Carport carport, Tag tag, Skur skur) throws CarportException {
        int serienummer = 0;

        ArrayList<CalculatedItems> liste;
        if (tag.getHældning() != 0) {
            liste = udregnStyklisterSkråt(carport, tag, skur);
        } else {
            liste = udregnStyklisterFladt(carport, tag, skur);
        }

        for (int h = 0; h < liste.size(); h++) {
            System.out.println(liste.get(h).getItemNavn());
        }

        for (int i = 0; i < liste.size(); i++) {
            String itemName = liste.get(i).getItemNavn();

            serienummer = getStandardStykliste(itemName);

            try {
                Connection con = Connector.connection();
                String SQL = "INSERT INTO fogprojekt.stykliste (forespørgselsId, serienummer, antal, længde) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, forespørgselsId);
                ps.setInt(2, serienummer);
                ps.setDouble(3, liste.get(i).getItemAntal());
                ps.setDouble(4, liste.get(i).getItemLængde());
                ps.executeUpdate();

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                throw new CarportException("Fejl ved oprettelse af styklister");
            }
        }

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.stykliste (forespørgselsId, serienummer, antal, længde) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            int tagId = getTagId(tag.getMateriale());
            double areal = beregnTagAreal(carport, tag);

            ps.setInt(1, forespørgselsId);
            ps.setInt(2, tagId);
            ps.setDouble(3, areal);
            ps.setDouble(4, 0);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new CarportException("Fejl ved oprettelse af styklister");
        }

        if (skur.getBredde() != 0) {
            try {
                Connection con = Connector.connection();
                String SQL = "INSERT INTO fogprojekt.stykliste (forespørgselsId, serienummer, antal, længde) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

                double brædder = beregnAntalBrædderSkur(skur);
                serienummer = getStandardStykliste("skurbrædder");

                ps.setInt(1, forespørgselsId);
                ps.setDouble(2, serienummer);
                ps.setDouble(3, brædder);
                ps.setDouble(4, carport.getHøjde());
                ps.executeUpdate();

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                throw new CarportException("Fejl ved oprettelse af styklister");
            }
        }

        int nummer = 11;
        for(int h = 0; h < 2; h++) {
            //tilføjer dele til montering af spær

            try {
                Connection con = Connector.connection();
                String SQL = "INSERT INTO fogprojekt.stykliste (forespørgselsId, serienummer, antal, længde) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

                double spær = CalculatedItems.getSpærAntal(liste);

                ps.setInt(1, forespørgselsId);
                ps.setDouble(2, nummer);
                ps.setDouble(3, spær);
                ps.setDouble(4, 0);
                ps.executeUpdate();


            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                throw new CarportException("Fejl ved oprettelse af styklister");
            }
            nummer = nummer + 1;
        }

        int skruenummer = 17;
        for(int h = 0; h < 2; h++) {
            try {
                Connection con = Connector.connection();
                String SQL = "INSERT INTO fogprojekt.stykliste (forespørgselsId, serienummer, antal, længde) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

                int antal = 2;
                if(carport.getBredde() > 600 && carport.getLængde() > 600){
                    antal = 3;
                }
                ps.setInt(1, forespørgselsId);
                ps.setDouble(2, skruenummer);
                ps.setDouble(3, antal);
                ps.setDouble(4, 0);
                ps.executeUpdate();

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                throw new CarportException("Fejl ved oprettelse af styklister");
            }
            skruenummer = skruenummer + 1;
        }

        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.stykliste (forespørgselsId, serienummer, antal, længde) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, forespørgselsId);
            ps.setDouble(2, 15);
            ps.setDouble(3, 18);
            ps.setDouble(4, 0);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new CarportException("Fejl ved oprettelse af styklister");
        }

    }


    public static void main(String[] args) throws CarportException {
        Carport carport = new Carport(220, 400, 720);
        Tag tag = new Tag("Fladt", 15, "Eternittag - Rødbrun");
        Skur skur = new Skur(300, 420);
       // int forespørgselsId = ForespørgselMapper.createForespørgsel(new Forespørgsel("John", "Doe", "Somewhere", "John@something.com", "54325425"));
        //lavStyklisterTilCarport(forespørgselsId, carport, tag, skur);

        ArrayList<Stykliste> styklist = getAllStyklister();

        System.out.println("--" + tag.getMateriale() + "--");
        int tagId = getTagId(tag.getMateriale());
        System.out.println(tagId);

        int a = getTagId("Eternittag - Rødbrun");
        System.out.println(a);

        System.out.println("------");
        System.out.println("------");
        System.out.println("------");
        System.out.println("------");

        for (int i = 0; i < styklist.size(); i++) {
            System.out.println("Ordre : " + styklist.get(i).getForespørgselsId());
            for (int h = 0; h < styklist.get(i).getListe().size(); h++) {
                System.out.println(styklist.get(i).getListe().get(h).getLængde());
            }
        }

        for (int i = 0; i < styklist.size(); i++) {
            System.out.println("Ordre : " + styklist.get(i).getForespørgselsId());
            for (int h = 0; h < styklist.get(i).getListe().size(); h++) {
                System.out.println(styklist.get(i).getListe().get(h));
            }
            System.out.println(styklist.get(i).getListe().size());
        }
        System.out.println("HER:" + styklist.size());

        ArrayList<String> tagma = getTagMaterialer();
        for(int i = 0; i < tagma.size(); i++){
            System.out.println(tagma.get(i));
        }

    }
}


