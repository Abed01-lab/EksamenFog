package FunctionLayer;

public class CalculatorSecond {


    public double beregnAntalStolper(Carport carport, Skur skur){
        double antalStolper;
        if(skur.getLængde() != 0 && skur.getLængde() == carport.getLængde()){
                antalStolper = Math.ceil(((carport.getLængde() - skur.getBredde()) / 325) + 1);
        }
        else {
            antalStolper = Math.ceil((carport.getLængde() / 325) + 1);
            if(antalStolper > 2){
                antalStolper = 2;
            }
        }
        return antalStolper * 2;
    }

    public double beregnAntalSpærFladt(Carport carport){
        return Math.ceil(carport.getLængde()/ 55) + 1;
    }

    public double beregnAntalSpærSkråtLodret(Carport carport){
        return Math.ceil(carport.getLængde()/ 89) + 1;
    }

    public double beregnAntalSpærSkråtVandret(Carport carport){
        return Math.ceil(carport.getBredde()/40) + 1;
    }

    public double beregnTagLægter (Carport carport, Tag tag) {
        double skråTagLængde = (carport.getBredde() / 2) / Math.cos(tag.getHældning());
        return skråTagLængde;
        //return Math.ceil(skråTagLængde / 30.7) + 1;
    }

    public double beregnTag(Carport carport, Tag tag){
        double skråTagLængde = Math.sqrt(((Math.pow(((carport.getBredde() / 2)) * Math.tan(Math.toRadians(tag.getHældning())), 2)) + (Math.pow((carport.getBredde() / 2), 2))));
        return Math.ceil(skråTagLængde / 30.7) + 1;
    }
}
