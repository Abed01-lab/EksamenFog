package FunctionLayer;

public class Carport {

    int højde;
    int bredde;
    int længde;
    int id;
    String materiale;

    public static int[] breddearray = new int[]{240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690, 720, 750};
    public static int[] længdearray = new int[]{240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690, 720, 750, 780};
    public static int[] højdearray = new int[]{200, 215, 230, 245, 260, 275, 290};
    public static String[] materialearray = new String[]{"Træ"};

    public static String[] tagarray = new String[]{"Fladt tag", "Skråt tag"};
    public static int[] taghældning = new int[]{0, 10, 15, 20, 25, 30, 35, 40, 45};

    public static int[] skurbreddearray = new int[]{180, 210, 240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690};
    public static int[] skurlængdearray = new int[]{180, 210, 240, 270, 300, 330, 360, 390, 420, 450, 480, 510, 540, 570, 600, 630, 660, 690, 720};
    public static String[] enhedArray = new String[]{"Stk", "Pk", "Tag", "Rulle", "Sæt"};
    public static String[] styklistetypeArray = new String[]{"Breddestolper", "Længdestolper", "Stolper", "Spær", "Lægter"};


    public Carport(int højde, int bredde, int længde) {
        this.højde = højde;
        this.bredde = bredde;
        this.længde = længde;
    }

    public Carport(int højde, int bredde, int længde, String materiale) {
        this.højde = højde;
        this.bredde = bredde;
        this.længde = længde;
        this.materiale = materiale;
    }

    public Carport(int id, int højde, int bredde, int længde, String materiale) {
        this.id = id;
        this.højde = højde;
        this.bredde = bredde;
        this.længde = længde;
        this.materiale = materiale;
    }

    public int getHøjde() {
        return højde;
    }

    public int getBredde() {
        return bredde;
    }

    public int getLængde() {
        return længde;
    }

    public String getMateriale() {
        return materiale;
    }

    public int getId() {
        return id;
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


