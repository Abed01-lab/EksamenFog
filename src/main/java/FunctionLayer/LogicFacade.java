package FunctionLayer;

import DBAccess.CarportMapper;
import DBAccess.ForespørgselMapper;
import DBAccess.StyklisteMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static Carport createCarport(double højde, double bredde, double længde) {
        //Carport carport = new Carport(højde, bredde, længde);
        //CarportMapper.createCarport(carport);
        //return carport;'
        return null;
    }


    public static List<Materials> deleteMaterial(int serienummer) {
        StyklisteMapper.deleteMaterial(serienummer);
        return getMaterials();
    }

    public static List<Materials> getMaterials() {
        return StyklisteMapper.getStyklister();
    }

    public static List<Materials> opdaterMateriale(String beskrivelse, String enhed, int pris) {
        Materials mat = new Materials(beskrivelse, enhed, pris);
        StyklisteMapper.opdaterMateriale(mat);
        return getMaterials();
    }

    public static List<Materials> opdaterPris(int serienummer, int pris) {
        StyklisteMapper.opdaterPris(serienummer, pris);
        return getMaterials();
    }

    public static ArrayList<Stykliste> getStykliste() {
        return StyklisteMapper.getStykliste();
    }

    public static int sendForespørgsel(String fornavn, String efternavn, String adresse, String email, String telefonnummer, Carport carport, Tag tag, Skur skur) throws CarportException {
        int carportId = CarportMapper.createCarport(carport);
        int tagId = CarportMapper.createTag(tag);
        int skurId = 0;
        if (skur != null) {
            skurId = CarportMapper.createSkur(skur);
        }
        return ForespørgselMapper.createForespørgsel(fornavn, efternavn, adresse, email, telefonnummer, carportId, tagId, skurId);
    }

    public static ArrayList<Forespørgsel> getAllForespørgsel() throws CarportException {
        return ForespørgselMapper.getAllForespørgsel();
    }

    public static Forespørgsel getForespørgsel(int forespørgselsId) throws CarportException {
        return ForespørgselMapper.getForespørgsel(forespørgselsId);
    }

    public static Carport getCarport(int carportId) throws CarportException {
        return CarportMapper.getCarport(carportId);
    }

    public static Tag getTag(int tagId) throws CarportException {
        return CarportMapper.getTag(tagId);
    }

    public static Skur getSkur(int skurId) throws CarportException {
        return CarportMapper.getSkur(skurId);
    }

    public static String tegnSVG(Carport carport, Tag tag, Skur skur) {
        return SVGTegner.tegnSVG(carport, tag, skur);
    }
}
