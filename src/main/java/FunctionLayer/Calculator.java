package FunctionLayer;

public class Calculator {

    public double beregnAntalStolper(Carport carport){
        double antalStolper = Math.ceil(((carport.getLængde() - 130) / 325) + 1);
        return antalStolper * 2;
    }

    public double beregnAntalSpærFladt(Carport carport){
        return Math.ceil(carport.getLængde()/ 55);
    }

    public double beregnAntalSpærSkråtLodret(Carport carport){
        return Math.ceil(carport.getLængde()/ 89);
    }

    public double beregnAntalSpærSkråtVandret(Carport carport){
        return Math.ceil(carport.getBredde()/40);
    }

    public double beregnTagLægter (Carport carport) {
        double skråTagLængde = (carport.getBredde() / 2) / Math.cos(carport.getHældning());
        return Math.ceil(skråTagLængde / 30.7) + 1;
    }

}