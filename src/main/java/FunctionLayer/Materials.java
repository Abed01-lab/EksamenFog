package FunctionLayer;

public class Materials {

    String deminsion;
    double længde;
    double antal;
    String enhed;
    String beskrivelse;

    public Materials(String deminsion, double længde, double antal, String enhed, String beskrivelse) {
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

    public double getLængde() {
        return længde;
    }

    public void setLængde(double længde) {
        this.længde = længde;
    }

    public double getAntal() {
        return antal;
    }

    public void setAntal(double antal) {
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
