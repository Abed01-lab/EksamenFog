package PresentationLayer;

import DBAccess.CarportMapper;
import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tegning extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        Carport carport = new Carport(400,300,200);
        StyklisteDetaljer styk = new StyklisteDetaljer(1, 1, 1);
        Svg svg = new Svg(800, 600, "0,0,800,600", 75, 10);
        svg.addRect(0,0, (int) carport.getLængde(), 450);

        //hent antal stolper
        svg.addRect(10, 5, (int) 9.7, (int) 9.7);

        //hent antal
        svg.addRect(0, 4, (int) carport.getHøjde(),styk.getLængde());
        // svg.addRect(0,565,4,788);


        // Outer Drawing
        Svg outerDrawing = new Svg(800 + 100, 600 + 100, "0,0, 900, 700", 0, 0);
        outerDrawing.addRect(50, 10, 300, 5);
        outerDrawing.insertDrawing(svg);
        // Tegn pile osv
        outerDrawing.addArrow(3, 0, 3, 70);


        request.setAttribute("svgtegning", outerDrawing.toString());
        return "seForespørgslerAdmin";
    }
}