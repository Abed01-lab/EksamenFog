package PresentationLayer;

import DBAccess.StyklisteMapper;
import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Materials;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;

import static FunctionLayer.Carport.enhedArray;
import static FunctionLayer.Carport.tagmateriale;

public class OpdaterMateriale extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        ServletContext servletContext = request.getServletContext();
        int pris = Integer.parseInt(request.getParameter("pris"));
        String enhed = request.getParameter("enhed");
        String beskrivelse = request.getParameter("beskrivelse");

        Materials mat = new Materials(beskrivelse, enhed, pris);

        StyklisteMapper.opdaterMateriale(mat);

        try {
            servletContext.setAttribute("materials", LogicFacade.getMaterials());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("tilføjetMaterialeBesked", "   Materialet " + beskrivelse + " er nu tilføjet");

        return "opdaterMaterialeAdmin";
    }
}
