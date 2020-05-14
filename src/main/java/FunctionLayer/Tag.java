package FunctionLayer;

public class Tag {

    int hældning;
    String type;
    String materiale;

    public Tag(String type, int hældning, String materiale) {
        this.hældning = hældning;
        this.type = type;
        this.materiale = materiale;
    }

    public int getHældning() {
        return hældning;
    }

    public String getType() {
        return type;
    }

    public String getMateriale() {
        return materiale;
    }

}
