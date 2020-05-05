package FunctionLayer;

public class CalculatorSecond {


    public static double beregnAntalStolper(Carport carport, Skur skur){
        double antalStolper;
        if(skur.getLængde() != 0 && skur.getLængde() == carport.getLængde()){
            antalStolper = Math.ceil(((carport.getLængde() - skur.getBredde()) / 325) + 1);
        }
        else {
            antalStolper = Math.ceil((carport.getLængde() / 325.0) );
            if(antalStolper > 2){
                antalStolper = 2;
            }
        }
        return antalStolper * 2;
    }

    public static double beregnAntalSpærFladt(Carport carport){
        return Math.ceil(carport.getLængde()/ 55.0);
    }

    public static double beregnAntalSpærSkråtLodret(Carport carport){
        return Math.ceil(carport.getLængde()/ 89.0);
    }

    public static double beregnTagLægter(Carport carport, Tag tag){
        double skråTagLængde = Math.sqrt(((Math.pow(((carport.getBredde() / 2)) * Math.tan(Math.toRadians(tag.getHældning())), 2)) + (Math.pow((carport.getBredde() / 2), 2))));
        skråTagLængde =- 65;
        return Math.ceil(skråTagLængde / 30.7) + 1;
    }

    //public static double beregnAntalSpærSkråtVandret(Carport carport){
    //    return Math.ceil(carport.getBredde()/40.0);
    //}

    public static double beregnTagAreal(Carport carport, Tag tag){
        double skråTagLængde = 0;
        double areal = 0;
        if(tag.getHældning() != 0){
            skråTagLængde = Math.sqrt(((Math.pow(((carport.getBredde() / 2)) * Math.tan(Math.toRadians(tag.getHældning())), 2)) + (Math.pow((carport.getBredde() / 2), 2))));
            areal = skråTagLængde * carport.getLængde() * 2;
        } else {
            areal = carport.getLængde() * carport.getBredde();
        }
        return areal / 10000;
    }

    public static void udregnSkurStyklister(Carport carport, Tag tag, Skur skur){
        double stolper = beregnAntalStolper(carport, skur);
        double areal = beregnTagAreal(carport, tag);
        if(tag.getHældning() != 0) {
            double spær = beregnAntalSpærSkråtLodret(carport);
            double læger = beregnTagLægter(carport, tag);
        }
        else {
            double spær = beregnAntalSpærFladt(carport);
        }
    }

    public static void main(String[] args) {
        Carport carport = new Carport(200, 400, 300);
        Tag tag = new Tag("skråt", 15, "sten");
        System.out.println(beregnAntalSpærSkråtLodret(carport));
        System.out.println(beregnTagAreal(carport, tag));
    }
}
