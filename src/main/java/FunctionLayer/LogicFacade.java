package FunctionLayer;

import DBAccess.StyklisteMapper;
import DBAccess.UserMapper;

import java.sql.SQLException;
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
    public static List<Materials> opdaterPris(int serienummer, int pris){
        StyklisteMapper.opdaterPris(serienummer, pris);
        return getMaterials();
    }
}
