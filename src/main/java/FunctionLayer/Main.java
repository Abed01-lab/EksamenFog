package FunctionLayer;

import DBAccess.StyklisteMapper;

import java.sql.SQLException;

import static DBAccess.StyklisteMapper.getStyklistePris;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //Carport carport = new Carport(240, 300, 420);
        //StyklisteMapper stkmp = new StyklisteMapper();

        //createOrdre(carport, tag, skur);
        //createOrdre(carport, null, skur);
        int i = (int) 5.2/1;
        double e = 5.2 % 1;
        System.out.println(i);
        System.out.println(e);

        double total = (((double)450/100) * 35) * 2;
        double q = (double) 450/100;
        System.out.println(q);
        System.out.println(total);

        double result = 0;
        try {
            result = getStyklistePris(7);
        } catch (CarportException carportException) {
            carportException.printStackTrace();
        }
        System.out.println(result);

    }
}
