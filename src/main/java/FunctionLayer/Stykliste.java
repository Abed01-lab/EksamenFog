package FunctionLayer;

import java.util.ArrayList;

public class Stykliste {

    ArrayList<StyklisteDetaljer> liste = new ArrayList<StyklisteDetaljer>();
    int ordreId;

    public Stykliste(int ordreId, ArrayList<StyklisteDetaljer> liste) {
        this.ordreId = ordreId;
        this.liste = liste;
    }

    public ArrayList<StyklisteDetaljer> getListe() {
        return liste;
    }

    public void setListe(ArrayList<StyklisteDetaljer> liste) {
        this.liste = liste;
    }

    public int getOrdreId() {
        return ordreId;
    }

    public void setOrdreId(int ordreId) {
        this.ordreId = ordreId;
    }
}

