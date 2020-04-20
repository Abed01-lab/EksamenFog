package FunctionLayer;

public class Carport {

    double højde;
    double bredde;
    double længde;
    double pris;

    int carportId;
    //Materialer!!!!
    Tag tag;
    Skur skur;


    public Carport(double højde, double bredde, double længde, Skur skur, Tag tag) {
        this.højde = højde;
        this.bredde = bredde;
        this.længde = længde;
        this.skur = skur;
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

    public void setPris(double pris) {
        this.pris = pris;
    }

    public void setCarportId(int carportId) {
        this.carportId = carportId;
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

    public double getPris() {
        return pris;
    }

    public int getCarportId() {
        return carportId;
    }
}
