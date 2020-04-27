package FunctionLayer;

import java.util.HashMap;

public class Tag {

    String tagtype;
    double hældning;
    String materiale;





    /*
    burde kører i program
    HashMap<String,String> tagTyper = new HashMap<>();
    tagTyper.put("fladt", "fladt");
    tagTyper.put("saddeltag", "saddeltag");
    tagTyper.put("tag med ensidigt fladt", "tag med ensidigt fladt");
     */

    public Tag( String tagtype, double hældning, String materiale) {

        this.tagtype = tagtype;
        this.hældning = hældning;
        this.materiale = materiale;
    }

    public String getTagtype() {
        return tagtype;
    }

    public void setTagtype(String tagtype) {
        this.tagtype = tagtype;
    }

    public double getHældning() {
        return hældning;
    }

    public void setHældning(double hældning) {
        this.hældning = hældning;
    }

    public String getMateriale() {
        return materiale;
    }

    public void setMateriale(String materiale) {
        this.materiale = materiale;
    }
}
