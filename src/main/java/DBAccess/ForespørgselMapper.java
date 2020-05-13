package DBAccess;

import FunctionLayer.CarportException;
import FunctionLayer.Forespørgsel;

import java.sql.*;
import java.util.ArrayList;

public class ForespørgselMapper {

    public static int createForespørgsel(Forespørgsel forespørgsel) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO fogprojekt.forespørgsel (fornavn, efternavn, adresse, email, telefonnummer, carportId, tagId, skurId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, forespørgsel.getFornavn());
            ps.setString(2, forespørgsel.getEfternavn());
            ps.setString(3, forespørgsel.getAdresse());
            ps.setString(4, forespørgsel.getEmail());
            ps.setString(5, forespørgsel.getTelefonnummer());
            ps.setInt(6, forespørgsel.getCarportId());
            ps.setInt(7, forespørgsel.getTagId());
            ps.setInt(8, forespørgsel.getSkurId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException | ClassNotFoundException e) {
            throw new CarportException("Fejl ved oprettelse af forespørgelse");
        }
    }


    public static ArrayList<Forespørgsel> getAllForespørgsel() throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogprojekt.forespørgsel";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            ArrayList<Forespørgsel> kundeForespørgsler = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("forespørgselsId");
                String fornavn = rs.getString("fornavn");
                String efternavn = rs.getString("efternavn");
                String adresse = rs.getString("adresse");
                String email = rs.getString("email");
                String telefonnummer = rs.getString("telefonnummer");
                int carportId = rs.getInt("carportId");
                int tagId = rs.getInt("tagId");
                int skurId = rs.getInt("skurId");
                int status = rs.getInt("status");
                Forespørgsel forespørgsel = new Forespørgsel(id, fornavn, efternavn, adresse, email, telefonnummer, carportId, tagId, skurId, status);
                kundeForespørgsler.add(forespørgsel);
            }
            return kundeForespørgsler;
        } catch (SQLException | ClassNotFoundException e) {
            throw new CarportException("Fejl ved indhentning af forespørgsler");
        }
    }

    public static Forespørgsel getForespørgsel(int forespørgselsId) throws CarportException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM fogprojekt.forespørgsel WHERE forespørgselsId = ?";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, forespørgselsId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("forespørgselsId");
                String fornavn = rs.getString("fornavn");
                String efternavn = rs.getString("efternavn");
                String adresse = rs.getString("adresse");
                String email = rs.getString("email");
                String telefonnummer = rs.getString("telefonnummer");
                int carportId = rs.getInt("carportId");
                int tagId = rs.getInt("tagId");
                int skurId = rs.getInt("skurId");
                int status = rs.getInt("status");
                return new Forespørgsel(id, fornavn, efternavn, adresse, email, telefonnummer, carportId, tagId, skurId, status);
            } else {
                throw new CarportException("Der findes ingen forespørgsel med id: " + forespørgselsId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new CarportException("Fejl ved indhentning af forespørgslen: " + forespørgselsId);
        }
    }
}
