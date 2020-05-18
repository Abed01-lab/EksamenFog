package FunctionLayer;


public class SVGTegner {

    public static String tegnSVG(Carport carport, Tag tag, Skur skur) {
        Svg outerDrawing = new Svg(carport.getLængde()+30 + 100, carport.getBredde() + 100, "0,0, 900+30, 800", 0, 0);
        Svg svg = new Svg(carport.getLængde() + 30, carport.getBredde(), "0,0,800+30,700", 75, 30);
        svg.addRect(0, 0, (int) carport.getBredde(), (int) carport.getLængde());


        //hent antal stolper
        double stolper = Math.ceil(Calculator.beregnAntalStolper(carport, skur));
        System.out.println(stolper);
        int stolpeAfstand = (int) (carport.getLængde()/(stolper/2));
        int afstand = stolpeAfstand - 100;
/*        if (skur.getBredde() != 0 && skur.getBredde() != 0){
            svg.addRect(carport.getLængde()-skur.getLængde(), 0, skur.getLængde(), skur.getBredde());
            stolper = stolper + 4;
        }*/
        for (int i = 0; i < (stolper/2); i++){
            svg.addRect(afstand, 20, (int)9.7, (int)9.7);
            svg.addRect(afstand, carport.getBredde()-30, (int)9.7, (int)9.7);
            afstand += stolpeAfstand;
        }


        //hent remme længder
        svg.addRect(0, 23, (int) 4.5, carport.getLængde());
        svg.addRect(0, (int) (carport.getBredde()-27.5), (int) 4.5, (int) carport.getLængde());

        //hent antal spær
        double spær = (Calculator.beregnAntalSpærFladt(carport));
        int spaces = 0;
        int spærAfstand = 55;
        int pile = 55;
        for (int i=0;i<spær-1;i++) {
            outerDrawing.addArrow(spaces + 77, 15, pile + 75, 15);
            spaces += spærAfstand;
            pile = pile + spærAfstand;
        }
        spaces = 0;
        for (int i = 0; i < spær; i++){
            svg.addRect(spaces, 0, carport.getBredde(), (int) 4.5);
            outerDrawing.addRect(spaces + 77, 5,  20, 1);
            spaces += spærAfstand;
        }

        //Kryds
        int kryds1 = (carport.getLængde()/6)*5;
        //svg.addArrow(0, 23, kryds1, carport.getBredde()-23);
        //svg.addArrow(kryds1, 23, 0, carport.getBredde()-23);
        svg.addKryds(0, 23, kryds1, carport.getBredde()-23);
        svg.addKryds(0, carport.getBredde()-23, kryds1, 23);

        // Outer Drawing

        outerDrawing.insertDrawing(svg);
        outerDrawing.addLabelX(carport.getLængde()/2 + 75, carport.getBredde()+65, String.valueOf(carport.getLængde()));
        outerDrawing.addLabelY(15, carport.getBredde()/2+30, String.valueOf(carport.getBredde()));

        // Tegn pile osv
        outerDrawing.addArrow(30, 30, 30 , carport.getBredde()+30);
        outerDrawing.addArrow(75,carport.getBredde()+50, carport.getLængde()+75,carport.getBredde()+50);


        return outerDrawing.toString();
    }
}
