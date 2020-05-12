package FunctionLayer;

public class StyklisteDetaljer {

    int serienummer;
    String beskrivelse;
    int antal;
    int længde;

    public StyklisteDetaljer(int serienummer, int antal, int længde) {
        this.serienummer = serienummer;
        this.antal = antal;
        this.længde = længde;
    }

    public int getSerienummer() {
        return serienummer;
    }

    public void setSerienummer(int serienummer) {
        this.serienummer = serienummer;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
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
