package FunctionLayer;

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
}
