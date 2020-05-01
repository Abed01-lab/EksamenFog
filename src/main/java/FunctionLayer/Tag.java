package FunctionLayer;

public class Tag {

    double hældning;
    String tagtype;
    String tagmateriale;

    public Tag(String tagtype, double hældning, String tagmateriale) {
        this.hældning = hældning;
        this.tagtype = tagtype;
        this.tagmateriale = tagmateriale;
    }

    public double getHældning() {
        return hældning;
    }

    public void setHældning(double hældning) {
        this.hældning = hældning;
    }

    public String getTagtype() {
        return tagtype;
    }

    public void setTagtype(String tagtype) {
        this.tagtype = tagtype;
    }

    public String getTagmateriale() {
        return tagmateriale;
    }

    public void setTagmateriale(String tagmateriale) {
        this.tagmateriale = tagmateriale;
    }
}
