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


    public static List<Materials> deleteMaterial(int serienummer) throws SQLException, ClassNotFoundException {
        StyklisteMapper.deleteMaterial(serienummer);
        return StyklisteMapper.getStyklister();
    }

    public static List<Materials> getMaterials() throws SQLException, ClassNotFoundException {
        return StyklisteMapper.getStyklister();
    }
}
