package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminSeForespørgsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {

        int forespørgselsId = Integer.parseInt(request.getParameter("forespørgselsId"));
        Forespørgsel forespørgsel = LogicFacade.getForespørgsel(forespørgselsId);
        Carport carport = LogicFacade.getCarport(forespørgsel.getCarportId());
        Tag tag = LogicFacade.getTag(forespørgsel.getTagId());
        Skur skur = LogicFacade.getSkur(forespørgsel.getSkurId());
        Stykliste stykliste = LogicFacade.getStykliste(forespørgselsId);
        System.out.println(stykliste);
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("forespørgsel", forespørgsel);
        servletContext.setAttribute("forespørgselCarport", carport);
        servletContext.setAttribute("forespørgselTag", tag);
        servletContext.setAttribute("forespørgselSkur", skur);
        servletContext.setAttribute("forespørgselStykliste", stykliste.getListe());
        servletContext.setAttribute("svg", LogicFacade.tegnSVG(carport, tag, skur));
        return "seForespørgslerAdmin";
    }
}
