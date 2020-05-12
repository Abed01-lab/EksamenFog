package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Drawing extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        Carport cp = new Carport(600,700,900);
        Svg svg = new Svg(800, 600, "0,0,800,600",0,0);
        svg.addRect(cp.getBredde(), cp.getHøjde(), 600, 780);
        svg.addRect(0, 35, 4, 780);
        svg.addRect(0, 565, 4, 780);
        request.setAttribute("svgdrawing", svg.toString());
        return "drawing";
    }
}
