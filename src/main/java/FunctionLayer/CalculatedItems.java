package FunctionLayer;

import java.util.ArrayList;

public class CalculatedItems {

    String itemNavn;
    double itemAntal;
    double itemLængde;

    public CalculatedItems(String itemNavn, double itemAntal, double itemLængde) {
        this.itemNavn = itemNavn;
        this.itemAntal = itemAntal;
        this.itemLængde = itemLængde;
    }

    public String getItemNavn() {
        return itemNavn;
    }

    public void setItemNavn(String itemNavn) {
        this.itemNavn = itemNavn;
    }

    public double getItemAntal() {
        return itemAntal;
    }

    public void setItemAntal(int itemAntal) {
        this.itemAntal = itemAntal;
    }

    public double getItemLængde() {
        return itemLængde;
    }

    public void setItemLængde(int itemLængde) {
        this.itemLængde = itemLængde;
    }

    public static double getSpærAntal(ArrayList<CalculatedItems> items) {
        double antalSpær = 0;
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).getItemNavn().equals("spær")){
                antalSpær = items.get(i).getItemAntal();
            }
        }
        return antalSpær;
    }
}
