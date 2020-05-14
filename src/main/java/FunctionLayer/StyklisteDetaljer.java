package FunctionLayer;

public class StyklisteDetaljer {

    int serienummer;
    String beskrivelse;
    int antal;
    int længde;

    public StyklisteDetaljer(int serienummer, String beskrivelse, int antal, int længde) {
        this.serienummer = serienummer;
        this.beskrivelse = beskrivelse;
        this.antal = antal;
        this.længde = længde;
    }

    public int getSerienummer() {
        return serienummer;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public int getAntal() {
        return antal;
    }

    public int getLængde() {
        return længde;
    }

    public void setLængde(int længde) {
        this.længde = længde;
    }

    @Override
    public String toString() {
        return "Stykliste: " +
                "serienummer = " + serienummer +
                ", beskrivelse = '" + beskrivelse + '\'' +
                ", antal = " + antal +
                ", længde = " + længde
                ;
    }
}
