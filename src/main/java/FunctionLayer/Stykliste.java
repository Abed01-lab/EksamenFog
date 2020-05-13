package FunctionLayer;

import java.util.ArrayList;

public class Stykliste {

    ArrayList<StyklisteDetaljer> liste = new ArrayList<StyklisteDetaljer>();
    int forespørgselsId;

    public Stykliste(int forespørgselsId, ArrayList<StyklisteDetaljer> liste) {
        this.forespørgselsId = forespørgselsId;
        this.liste = liste;
    }

    public ArrayList<StyklisteDetaljer> getListe() {
        return liste;
    }

    public int getForespørgselsId() {
        return forespørgselsId;
    }

    @Override
    public String toString() {
        return "Stykliste{" +
                "liste=" + liste +
                ", forespørgselsId=" + forespørgselsId +
                '}';
    }
}

