package FunctionLayer;

import java.util.HashMap;

public class Tag {

    String typeTag;

    /*
    burde kører i program
    HashMap<String,String> tagTyper = new HashMap<>();
    tagTyper.put("fladt", "fladt");
    tagTyper.put("saddeltag", "saddeltag");
    tagTyper.put("tag med ensidigt fladt", "tag med ensidigt fladt");
     */

    public Tag(String typeTag) {
        this.typeTag = typeTag;
    }

    public void setTypeTag(String typeTag) {
        this.typeTag = typeTag;
    }

    public String getTypeTag() {
        return typeTag;
    }
}
