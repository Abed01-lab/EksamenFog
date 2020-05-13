package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpdaterMateriale extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        ServletContext servletContext = request.getServletContext();
        int pris = Integer.parseInt(request.getParameter("pris"));
        String enhed = request.getParameter("enhed");
        String beskrivelse = request.getParameter("beskrivelse");

        servletContext.setAttribute("materials", LogicFacade.opdaterMateriale(beskrivelse, enhed, pris));
        request.setAttribute("tilføjetMaterialeBesked", "   Materialet " + beskrivelse + " er nu tilføjet");

        return "opdaterMaterialeAdmin";
    }
}
