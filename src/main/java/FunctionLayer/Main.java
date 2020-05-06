package FunctionLayer;

import DBAccess.CarportMapper;
import DBAccess.StyklisteMapper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static DBAccess.CarportMapper.createCarport;
import static DBAccess.CarportMapper.createOrdre;
import static FunctionLayer.Carport.længdearray;

public class Main {

    public static double beregnTagLægter(Carport carport, Tag tag) {
        double skråTagLængde = (carport.getBredde() / 2) / Math.cos(tag.getHældning());
        // return skråTagLængde;
        return Math.ceil(skråTagLængde / 30.7) + 1;

    }

    public static double beregnTag(Carport carport, Tag tag){
        double skråTagLængde = Math.sqrt(((Math.pow(((carport.getBredde() / 2)) * Math.tan(Math.toRadians(tag.getHældning())), 2)) + (Math.pow((carport.getBredde() / 2), 2))));
        return skråTagLængde;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Carport carport = new Carport(240, 300,420);
        StyklisteMapper stkmp = new StyklisteMapper();
        
        System.out.println(carport.beregnKvm());
        for (Materials mat: stkmp.getFladtStyklister(carport.beregnKvm())) {
            System.out.println(mat.toString());
        }

        //createOrdre(carport, tag, skur);
        //createOrdre(carport, null, skur);

    }
}
