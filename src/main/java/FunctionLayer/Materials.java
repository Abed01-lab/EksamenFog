package FunctionLayer;

public class Materials {

    String deminsion;
    int længde;
    int antal;
    String enhed;
    String beskrivelse;

    public Materials(String deminsion, int længde, int antal, String enhed, String beskrivelse) {
        this.deminsion = deminsion;
        this.længde = længde;
        this.antal = antal;
        this.enhed = enhed;
        this.beskrivelse = beskrivelse;
    }

    public String getDeminsion() {
        return deminsion;
    }

    public void setDeminsion(String deminsion) {
        this.deminsion = deminsion;
    }

    public int getLængde() {
        return længde;
    }

    public void setLængde(int længde) {
        this.længde = længde;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
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

    @Override
    public String toString() {
        return "Materials " +
                "deminsion: " + deminsion +
                ", længde: " + længde +
                ", antal: " + antal +
                ", enhed: " + enhed +
                ", beskrivelse: " + beskrivelse;
    }
}
