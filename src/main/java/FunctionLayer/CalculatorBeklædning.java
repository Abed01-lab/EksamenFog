package FunctionLayer;



public class CalculatorBeklædning {
    //Materials bagbrædt = new Materials(1, "bagbrædt", 360,20);
    //Materials sidebrædt = new Materials(2, "sidebrædt", 540,20);
    double antalSideBrædt = 0;
    double antalBagBrædt = 0;
    Carport carport;

    public static void main(String[] args) {
        Carport carport = new Carport(300,350,400);
        CalculatorBeklædning stykliste = new CalculatorBeklædning(carport);
        System.out.println(stykliste.antalBagBrædt);
        System.out.println(stykliste.antalSideBrædt);
    }


    public CalculatorBeklædning(Carport carport) {

        this.carport = carport;
        //antalSideBrædt = Math.ceil((carport.længde * carport.højde) / (sidebrædt.længde * sidebrædt.bredde) * 2);
        //antalBagBrædt = Math.ceil((carport.bredde * carport.højde) / (bagbrædt.længde * bagbrædt.bredde));


    }

    public void sideCarport() {


    }




}
