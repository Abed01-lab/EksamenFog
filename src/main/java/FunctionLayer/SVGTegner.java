package FunctionLayer;

public class SVGTegner {

    public static String tegnSVG(Carport carport, Tag tag, Skur skur) {
        Svg svg = new Svg(800, 600, "0,0,400,200", 0, 0);
        svg.addRect(0, 0, (int) carport.getLængde(), 780);
        svg.addRect(0, 35, 4, 780);
        return svg.toString();
    }
}
