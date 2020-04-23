package FunctionLayer;

import java.sql.Array;
import java.util.ArrayList;


public class Carport {

    double højde;
    double bredde;
    double længde;
    double pris;

    public static int[] breddearray = new int[] {240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690, 720, 750};
    public static int[] længdearray = new int[] {240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690, 720, 750, 780};
    public static int[] højdearray = new int[] {200, 215, 230, 245, 260, 275, 290};
    public static String[] tagarray = new String[] {"Flat tag", "Skråt tag", "Skråt tag til én side"};
    public static int[] taghældning = new int[] {10, 15, 20, 25, 30, 35, 40, 45};

    public static int[] skurbreddearray = new int[] {180, 210, 240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690};
    public static int[] skurlængdearray = new int[] {180, 210, 240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690, 720};

    public ArrayList<Integer> breddetwo = new ArrayList<>();

    int carportId;
    //Materialer!!!!

    public Carport(double højde, double bredde, double længde) {
        this.højde = højde;
        this.bredde = bredde;
        this.længde = længde;
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


