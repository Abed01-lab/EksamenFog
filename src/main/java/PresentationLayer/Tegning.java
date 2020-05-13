package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.CarportException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Svg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tegning extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        Carport carport = new Carport(400, 300, 200);
        Svg svg = new Svg(800, 600, "0,0,400,200", 0, 0);
        svg.addRect(0, 0, (int) carport.getLængde(), 780);
        svg.addRect(0, 35, 4, 780);
        // svg.addRect(0,565,4,788);
        request.setAttribute("svgtegning", svg.toString());
        return "seTegningKunde";
    }
}
