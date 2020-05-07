package PresentationLayer;

import DBAccess.StyklisteMapper;
import FunctionLayer.CarportException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Materials;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static FunctionLayer.Carport.enhedArray;
import static FunctionLayer.Carport.tagmateriale;

public class OpdaterMateriale extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        int pris = Integer.parseInt(request.getParameter("pris"));
        String enhed = request.getParameter("enhed");
        String beskrivelse = request.getParameter("beskrivelse");

        Materials mat = new Materials(beskrivelse, enhed, pris);

        StyklisteMapper.opdaterMateriale(mat);

        return "materialeIndsatBekræftelse";
    }
}
