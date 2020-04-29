package FunctionLayer;

import static DBAccess.CarportMapper.createCarport;
import static DBAccess.CarportMapper.createOrdre;
import static FunctionLayer.Carport.længdearray;

public class Main {

    public static void main(String[] args) {
        System.out.println(længdearray[1]);
        Calculator cal = new Calculator();

        Carport carport = new Carport(200, 360, 460);
        Carport carport1 = new Carport(200, 400, 780);

        Skur skur = new Skur(320, 360);


      //createOrdre(carport, tag, skur);
      //createOrdre(carport, null, skur);//ystem.out.println(cal.fladtTagCarport(carport));



        System.out.println("antal lægter " + cal.beregnTagLægter(carport));
    }


}
