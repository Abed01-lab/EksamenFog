package FunctionLayer;

import DBAccess.StyklisteMapper;

public class SVGTegner {

    public static String tegnSVG(Carport carport, Tag tag, Skur skur) {
        Svg outerDrawing = new Svg(carport.getLængde()+30 + 100, carport.getBredde() + 100, "0,0, 900+30, 800", 0, 0);
        Svg svg = new Svg(800 + 30, 700, "0,0,800+30,700", 75, 30);
        svg.addRect(0, 0, (int) carport.getBredde(), (int) carport.getLængde());


        //hent antal stolper
        double stolper = Math.ceil(Calculator.beregnAntalStolper(carport, skur));
        System.out.println(stolper);
        int stolpeAfstand = (int) (carport.getLængde()/(stolper/2));
        int afstand = stolpeAfstand - 100;
        if (skur.getBredde() != 0 && skur.getBredde() != 0){
            svg.addRect(carport.getLængde()-skur.getLængde(), 0, skur.getLængde(), skur.getBredde());
            stolper = stolper + 4;
        }
        for (int i = 0; i < (stolper/2); i++){
            svg.addRect(afstand, 20, (int)9.7, (int)9.7);
            svg.addRect(afstand, carport.getBredde()-30, (int)9.7, (int)9.7);
            afstand += stolpeAfstand;
        }


        //hent remme længder
        svg.addRect(0, 23, (int) 4.5, (int) carport.getLængde());
        svg.addRect(0, (int) ((int) carport.getBredde()-27.5), (int) 4.5, (int) carport.getLængde());

        //hent antal spær
        double spær = (Calculator.beregnAntalSpærFladt(carport));
        int spaces = 0;
        int spærAfstand = 55;
        outerDrawing.addArrow( spaces + 75, 15, spærAfstand + 75, 15);
        for (int i = 0; i < spær; i++){
            svg.addRect(spaces, 0, carport.getBredde(), (int) 4.5);
            spaces += spærAfstand;

        }

        //Kryds
        int kryds = carport.getLængde()/6;
        int kryds1 = (carport.getLængde()/6)*5;
        svg.addKryds(kryds, 0, kryds1, carport.getBredde());
        svg.addKryds(kryds1, 0, kryds, carport.getBredde());

        // Outer Drawing
        //Svg outerDrawing = new Svg(carport.getLængde()+30 + 100, carport.getBredde() + 100, "0,0, 900+30, 800", 0, 0);
        outerDrawing.insertDrawing(svg);
        //outerDrawing.addLabel(carport.getLængde()/2, carport.getBredde()+15);

        // Tegn pile osv
        outerDrawing.addArrow(30, 30, 30 , (int) carport.getBredde()+30);
        outerDrawing.addArrow(75, (int) carport.getBredde()+50, (int) carport.getLængde()+75,(int) carport.getBredde()+50);


        return outerDrawing.toString();
    }
}
