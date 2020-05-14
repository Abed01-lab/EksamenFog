package FunctionLayer;

public class Ordre {

    private int id;
    private String dato;
    private int forespørgselsId;

    public Ordre(int id, String dato, int forespørgselsId) {
        this.id = id;
        this.dato = dato;
        this.forespørgselsId = forespørgselsId;
    }

    public Ordre(String dato, int forespørgselsId) {
        this.dato = dato;
        this.forespørgselsId = forespørgselsId;
    }

    public int getId() {
        return id;
    }

    public String getDato() {
        return dato;
    }

    public int getForespørgselsId() {
        return forespørgselsId;
    }

    @Override
    public String toString() {
        return "Ordre{" +
                "id=" + id +
                ", dato='" + dato + '\'' +
                ", forespørgselsId=" + forespørgselsId +
                '}';
    }
}
