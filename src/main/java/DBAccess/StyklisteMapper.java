package DBAccess;

import FunctionLayer.Materials;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

                Materials materialInstance = new Materials(deminsion, længdeInt, antalInt, enhed, beskrivelse);
                materialer.add(materialInstance);

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return materialer;
    }

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
}
