package FunctionLayer;

public class SVGTegner {

    public static String tegnSVG(Carport carport, Tag tag, Skur skur) {
        Svg svg = new Svg(800, 700, "0,0,800,700", 75, 10);
        svg.addRect(0,0, (int) carport.getBredde(), (int) carport.getLængde());

        //hent antal stolper
        svg.addRect(100, 20, (int) 9.7, (int) 9.7);
        svg.addRect(250, 20, (int) 9.7, (int) 9.7);
        svg.addRect(400, 20, (int) 9.7, (int) 9.7);
        svg.addRect(650, 20, (int) 9.7, (int) 9.7);

        svg.addRect(100, (int) carport.getBredde()-30, (int) 9.7, (int) 9.7);
        svg.addRect(250, (int) carport.getBredde()-30, (int) 9.7, (int) 9.7);
        svg.addRect(400, (int) carport.getBredde()-30, (int) 9.7, (int) 9.7);
        svg.addRect(650, (int) carport.getBredde()-30, (int) 9.7, (int) 9.7);

        //hent remme længder
        svg.addRect(0, 23, (int) 4.5, (int) carport.getLængde());
        svg.addRect(0, (int) ((int) carport.getBredde()-27.5), (int) 4.5, (int) carport.getLængde());

        //hent antal spær
        int spaces = 0;
        svg.addRect(spaces, 0, (int) carport.getBredde(), (int) 4.5);

        for (int i = 0; i < carport.getLængde()-55; i = i+55) {
                spaces += 55;
            svg.addRect(spaces, 0, (int) carport.getBredde(), (int) 4.5);
            System.out.println(spaces);

        }


        // Outer Drawing
        Svg outerDrawing = new Svg(800 + 100, 700 + 100, "0,0, 900, 800", 0, 0);
        outerDrawing.insertDrawing(svg);
        outerDrawing.addLabel();

        // Tegn pile osv
        outerDrawing.addArrow(10, 10, 10 , (int) carport.getBredde()+10);
        outerDrawing.addArrow(75, (int) carport.getBredde()+30, (int) carport.getLængde()+75,(int) carport.getBredde()+30);
        return outerDrawing.toString();
    }
}
