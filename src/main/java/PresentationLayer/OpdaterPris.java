package PresentationLayer;

import DBAccess.StyklisteMapper;
import FunctionLayer.LogicFacade;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class OpdaterPris extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        ServletContext servletContext = request.getServletContext();
        int pris = Integer.parseInt(request.getParameter("pris"));
        int materialeId = Integer.parseInt(request.getParameter("materialeId"));
        request.setAttribute("besked", "   Prisen på varen med serienummer  " + materialeId + " er opdateret til " + pris + ",-");
        // String beskrivelse = request.getParameter("beskrivelse");
        // String enhed = request.getParameter("enhed");


        try {
            LogicFacade.opdaterPris(pris, materialeId);
            servletContext.setAttribute("materials", LogicFacade.getMaterials());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "opdaterMaterialeAdmin";
    }
}
