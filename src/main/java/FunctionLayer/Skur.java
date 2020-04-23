package FunctionLayer;

public class Skur {


    double bredde;
    double længde;

    Tag tag;

    public Skur(double bredde, double længde) {
        this.bredde = bredde;
        this.længde = længde;
    }


    public void setBredde(double bredde) {
        this.bredde = bredde;
    }

    public void setLængde(double længde) {
        this.længde = længde;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }


    public double getBredde() {
        return bredde;
    }

    public double getLængde() {
        return længde;
    }

    public Tag getTag() {
        return tag;
    }

}
