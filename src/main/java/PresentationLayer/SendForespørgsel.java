package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendForespørgsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        String fornavn = request.getParameter("Fornavn");
        String efternavn = request.getParameter("Efternavn");
        String adresse = request.getParameter("Adresse");
        String email = request.getParameter("Email");
        String telefonnummer = request.getParameter("Telefonnummer");

        ServletContext servletContext = request.getServletContext();
        Carport carport = (Carport) servletContext.getAttribute("carportObject");
        Tag tag = (Tag) servletContext.getAttribute("tagObject");
        Skur skur = (Skur) servletContext.getAttribute("skurObject");

        Forespørgsel forespørgsel = new Forespørgsel(fornavn, efternavn, adresse, email, telefonnummer);
        int forespørgelseId = LogicFacade.sendForespørgsel(forespørgsel, carport, tag, skur);
        request.getSession().setAttribute("forespørgelseId", forespørgelseId);

        return "index";
    }
}
