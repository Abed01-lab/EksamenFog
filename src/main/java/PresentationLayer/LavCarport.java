package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LavCarport extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int bredde = Integer.parseInt(request.getParameter("bredde"));
        int længde = Integer.parseInt(request.getParameter("længde"));
        int højde = Integer.parseInt(request.getParameter("højde"));

        int skurbredde = Integer.parseInt(request.getParameter("skurbredde"));
        int skurlængde = Integer.parseInt(request.getParameter("skurlængde"));

        String tag = request.getParameter("tag");
        int taghældning = Integer.parseInt(request.getParameter("taghældning"));
        String tagmateriale = request.getParameter("tagmateriale");

        Carport carportobject = new Carport(højde, bredde, længde);

        Skur skurobject;
        if (skurbredde == 0) {
            skurobject = new Skur(0, 0);
        } else {
            skurobject = new Skur(skurbredde, skurlængde);
        }
        if ("Fladt tag".equals(tag)) {
            taghældning = 0;
        }
        Tag tagobject = new Tag(tag, taghældning, tagmateriale);


        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("carportObject", carportobject);
        servletContext.setAttribute("tagObject", tagobject);
        servletContext.setAttribute("skurObject", skurobject);
        servletContext.setAttribute("svg", LogicFacade.tegnSVG(carportobject, tagobject, skurobject));

        return "seTegningKunde";
    }
}
