package FunctionLayer;

import DBAccess.CarportMapper;

import java.sql.SQLException;

import static DBAccess.CarportMapper.createCarport;
import static DBAccess.CarportMapper.createOrdre;
import static FunctionLayer.Carport.længdearray;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(længdearray[1]);

        Carport carport = new Carport(200, 400, 460);
        Tag tag = new Tag("hældning", 10, "metal");
        Skur skur = new Skur(320, 360);

      createOrdre(carport, tag, skur);

        Skur skur2 = new Skur();
        if(skur2.getBredde() == 0){
            System.out.println("EKONULL");
        }
        if(skur2.getTag() == null){
            System.out.println("NULLTWO");
        }



        System.out.println(carport.getLængde());


        System.out.println(CarportMapper.getMaterials());

    }

}
