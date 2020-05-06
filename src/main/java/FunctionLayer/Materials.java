package FunctionLayer;

public class Materials {

    int itemId;
    String beskrivelse;
    String enhed;
    int pris;

    public Materials(int itemId, String beskrivelse, String enhed, int pris) {
        this.itemId = itemId;
        this.pris = pris;
        this.enhed = enhed;
        this.beskrivelse = beskrivelse;
    }


    public String getEnhed() {
        return enhed;
    }

    public void setEnhed(String enhed) {
        this.enhed = enhed;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Materials " +
                ", enhed: " + enhed +
                ", beskrivelse: " + beskrivelse;
    }
}
