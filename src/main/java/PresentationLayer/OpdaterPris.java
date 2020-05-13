package PresentationLayer;

import FunctionLayer.LogicFacade;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpdaterPris extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = request.getServletContext();
        int pris = Integer.parseInt(request.getParameter("pris"));
        int materialeId = Integer.parseInt(request.getParameter("materialeId"));
        request.setAttribute("besked", "   Prisen på varen med serienummer  " + materialeId + " er opdateret til " + pris + ",-");


        servletContext.setAttribute("materials", LogicFacade.opdaterPris(pris, materialeId));

        return "opdaterMaterialeAdmin";
    }
}
