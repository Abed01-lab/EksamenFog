package FunctionLayer;

public class Skur {

    double højde;
    double bredde;
    double længde;

    Tag tag;

    public Skur(double højde, double bredde, double længde, Tag tag) {
        this.højde = højde;
        this.bredde = bredde;
        this.længde = længde;
        this.tag = tag;
    }

    public void setHøjde(double højde) {
        this.højde = højde;
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

    public double getHøjde() {
        return højde;
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
