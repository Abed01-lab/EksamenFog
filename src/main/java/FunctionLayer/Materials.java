package FunctionLayer;

public class Materials {

    int itemId;
    String beskrivelse;
    String enhed;
    double pris;

    public Materials(int itemId, String beskrivelse, String enhed, double pris) {
        this.itemId = itemId;
        this.pris = pris;
        this.enhed = enhed;
        this.beskrivelse = beskrivelse;
    }

    public Materials(String beskrivelse, String enhed, double pris) {

        this.pris = pris;
        this.enhed = enhed;
        this.beskrivelse = beskrivelse;
    }

    public String getEnhed() {
        return enhed;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getItemId() {
        return itemId;
    }

    public double getPris() {
        return pris;
    }


    @Override
    public String toString() {
        return "Materials{" +
                "itemId=" + itemId +
                ", beskrivelse='" + beskrivelse + '\'' +
                ", enhed='" + enhed + '\'' +
                ", pris=" + pris +
                '}';
    }
}
