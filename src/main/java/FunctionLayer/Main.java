package FunctionLayer;

import DBAccess.StyklisteMapper;

import java.sql.SQLException;

public class Main {

    public static double beregnTagLægter(Carport carport, Tag tag) {
        double skråTagLængde = (carport.getBredde() / 2) / Math.cos(tag.getHældning());
        // return skråTagLængde;
        return Math.ceil(skråTagLængde / 30.7) + 1;

    }

    public static double beregnTag(Carport carport, Tag tag) {
        double skråTagLængde = Math.sqrt(((Math.pow(((carport.getBredde() / 2)) * Math.tan(Math.toRadians(tag.getHældning())), 2)) + (Math.pow((carport.getBredde() / 2), 2))));
        return skråTagLængde;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Carport carport = new Carport(240, 300, 420);
        StyklisteMapper stkmp = new StyklisteMapper();

        //createOrdre(carport, tag, skur);
        //createOrdre(carport, null, skur);


    }
}
