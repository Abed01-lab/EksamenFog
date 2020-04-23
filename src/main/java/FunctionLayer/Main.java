package FunctionLayer;

import static DBAccess.CarportMapper.createCarport;
import static DBAccess.CarportMapper.createOrdre;
import static FunctionLayer.Carport.længdearray;

public class Main {

    public static void main(String[] args) {
        System.out.println(længdearray[1]);

        Carport carport = new Carport(200, 400, 460);
        Tag tag = new Tag("hældning", 10, "metal");
        Skur skur = new Skur(320, 360);

        createOrdre(carport, tag, skur);

        System.out.println(carport.getLængde());
    }
}
