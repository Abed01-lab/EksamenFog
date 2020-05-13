package FunctionLayer;

public class Carport {

    double højde; // TODO ændrer til int?
    double bredde; // TODO ændrer til int?
    double længde; // TODO ændrer til int?
    String materiale;

    public static int[] breddearray = new int[]{240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690, 720, 750};
    public static int[] længdearray = new int[]{240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690, 720, 750, 780};
    public static int[] højdearray = new int[]{200, 215, 230, 245, 260, 275, 290};
    public static String[] materialearray = new String[]{"Træ"};

    public static String[] tagarray = new String[]{"Fladt tag", "Skråt tag", "Skråt tag til én side"};
    public static String[] tagmateriale = new String[]{"Træ", "Sten"};
    public static int[] taghældning = new int[]{0, 10, 15, 20, 25, 30, 35, 40, 45};

    public static int[] skurbreddearray = new int[]{180, 210, 240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690};
    public static int[] skurlængdearray = new int[]{180, 210, 240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690, 720};
    public static String[] enhedArray = new String[]{"Stk", "Pk", "Tag", "Rulle", "Sæt"};

    public Carport(double højde, double bredde, double længde) {
        this.højde = højde;
        this.bredde = bredde;
        this.længde = længde;
    }

    public Carport(double højde, double bredde, double længde, String materiale) {
        this.højde = højde;
        this.bredde = bredde;
        this.længde = længde;
        this.materiale = materiale;
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

    public double getHøjde() {
        return højde;
    }

    public double getBredde() {
        return bredde;
    }

    public double getLængde() {
        return længde;
    }

    @Override
    public String toString() {
        return "Carport{" +
                "højde=" + højde +
                ", bredde=" + bredde +
                ", længde=" + længde +
                ", materiale='" + materiale + '\'' +
                '}';
    }
}


