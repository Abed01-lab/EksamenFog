package FunctionLayer;

import java.util.ArrayList;

public class Calculator {


    public static double beregnAntalStolper(Carport carport, Skur skur) {
        double antalStolper;
        if (skur.getLængde() != 0 && skur.getLængde() == carport.getLængde()) {
            antalStolper = Math.ceil(((carport.getLængde() - skur.getBredde()) / 325) + 1);
        } else {
            antalStolper = Math.ceil((carport.getLængde() / 325.0));
            if (antalStolper < 2) {
                antalStolper = 2;
            }
        }
        return antalStolper * 2;
    }

    public static double beregnAntalSpærFladt(Carport carport) { return Math.floor((carport.getLængde() + 30) / 55.0);
    }

    public static double beregnAntalSpærSkråtLodret(Carport carport, Tag tag) {
        double skråTagLængde = Math.sqrt(((Math.pow(((carport.getBredde() / 2)) * Math.tan(Math.toRadians(tag.getHældning())), 2)) + (Math.pow((carport.getBredde() / 2), 2)))) + 30;
        return Math.ceil((skråTagLængde + 15) / 89.0) * 2;
    }

    public static double beregnTagLægter(Carport carport, Tag tag) {
        double skråTagLængde = Math.sqrt(((Math.pow(((carport.getBredde() / 2)) * Math.tan(Math.toRadians(tag.getHældning())), 2)) + (Math.pow((carport.getBredde() / 2), 2)))) + 30;
        skråTagLængde = skråTagLængde - 65;
        return (Math.ceil(skråTagLængde / 30.7) + 1) * 2;
        // måske * 2
    }

    public static double beregnTagAreal(Carport carport, Tag tag) {
        double skråTagLængde = 0;
        double areal = 0;
        if (tag.getHældning() != 0) {
            skråTagLængde = Math.sqrt(((Math.pow(((carport.getBredde() / 2)) * Math.tan(Math.toRadians(tag.getHældning())), 2)) + (Math.pow((carport.getBredde() / 2), 2))));
            areal = skråTagLængde * carport.getLængde() * 2;
        } else {
            areal = carport.getLængde() * carport.getBredde();
        }
        return areal / 10000;
    }

    public static ArrayList<CalculatedItems> udregnStyklisterFladt(Carport carport, Tag tag, Skur skur) {
        double stolperAntal = beregnAntalStolper(carport, skur);
        double spærAntal = beregnAntalSpærFladt(carport);
        double areal = beregnTagAreal(carport, tag);

        ArrayList<CalculatedItems> list = new ArrayList<CalculatedItems>();
        CalculatedItems breddestolpe = new CalculatedItems("breddestolper", 2, carport.getBredde());
        CalculatedItems længdestolpe = new CalculatedItems("længdestolper", 2, carport.getLængde());
        CalculatedItems stolper = new CalculatedItems("stolper", stolperAntal, carport.højde + 90);
        CalculatedItems spær = new CalculatedItems("spær", spærAntal, carport.bredde);
        list.add(breddestolpe);
        list.add(længdestolpe);
        list.add(stolper);
        list.add(spær);
        return list;
    }

    public static ArrayList<CalculatedItems> udregnStyklisterSkråt(Carport carport, Tag tag, Skur skur) {
        double stolperAntal = beregnAntalStolper(carport, skur);
        double spærAntal = beregnAntalSpærFladt(carport);
        double lægterAntal = beregnTagLægter(carport, tag);
        double areal = beregnTagAreal(carport, tag);

        ArrayList<CalculatedItems> list = new ArrayList<CalculatedItems>();
        CalculatedItems breddestolpe = new CalculatedItems("breddestolper", 2, carport.getBredde());
        CalculatedItems længdestolpe = new CalculatedItems("længdestolper", 2, carport.getLængde());
        CalculatedItems stolper = new CalculatedItems("stolper", stolperAntal, carport.højde + 90);
        CalculatedItems spær = new CalculatedItems("spær", spærAntal, carport.bredde);
        CalculatedItems lægter = new CalculatedItems("lægter", lægterAntal, Math.sqrt(((Math.pow(((carport.getBredde() / 2)) * Math.tan(Math.toRadians(tag.getHældning())), 2)) + (Math.pow((carport.getBredde() / 2), 2)))));
        list.add(breddestolpe);
        list.add(længdestolpe);
        list.add(stolper);
        list.add(spær);
        list.add(lægter);
        return list;
    }

}
