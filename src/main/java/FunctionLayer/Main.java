package FunctionLayer;

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

    public static void main(String[] args) {
        System.out.println(længdearray[1]);

        Carport carport = new Carport(200, 400, 460);
        Skur skur = new Skur(320, 360);
        Tag tag = new Tag("Tag", 15, "Sten");

        System.out.println(beregnTagLægter(carport, tag));

        System.out.println(beregnTag(carport, tag));

        //createOrdre(carport, tag, skur);
      //createOrdre(carport, null, skur);

    }
}
