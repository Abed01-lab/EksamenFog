package FunctionLayer;

public class Materials {
    int id;
    String beskrivelse;
    int længde;
    int bredde;

    public Materials(int id, String beskrivelse, int længde, int bredde) {
        this.id = id;
        this.beskrivelse = beskrivelse;
        this.længde = længde;
        this.bredde = bredde;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public int getLængde() {
        return længde;
    }



    public void setLængde(int længde) {
        this.længde = længde;
    }

    public int getBredde() {
        return bredde;
    }

    public void setBredde(int bredde) {
        this.bredde = bredde;
    }
    @Override
    public String toString() {
        return "Materials{" +
                "id=" + id +
                ", beskrivelse='" + beskrivelse + '\'' +
                ", længde=" + længde +
                ", bredde=" + bredde +
                '}';
    }

}
