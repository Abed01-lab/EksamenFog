package FunctionLayer;

public class Ordre {

    private int ordreId;
    private String dato;
    private int forespørgselsId;
    private String navn;

    public Ordre(int ordreId, String dato, String fornavn, String efternavn) {
        this.ordreId = ordreId;
        this.dato = dato;
        this.navn = fornavn + " " + efternavn;
    }

    public Ordre(String dato, int forespørgselsId) {
        this.dato = dato;
        this.forespørgselsId = forespørgselsId;
    }

    public int getOrdreId() {
        return ordreId;
    }

    public String getDato() {
        return dato;
    }

    public int getForespørgselsId() {
        return forespørgselsId;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return "Ordre{" +
                "ordreId=" + ordreId +
                ", dato='" + dato + '\'' +
                ", forespørgselsId=" + forespørgselsId +
                ", navn='" + navn + '\'' +
                '}';
    }
}
