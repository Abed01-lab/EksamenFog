package PresentationLayer;

import DBAccess.StyklisteMapper;
import FunctionLayer.CarportException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Materials;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OpdaterMateriale extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {

        int pris = Integer.parseInt(request.getParameter("pris"));
        String enhed = request.getParameter("enhed");
        String beskrivelse = request.getParameter("beskrivelse");

        Materials mat = new Materials(beskrivelse, enhed,pris);

        StyklisteMapper.opdaterMateriale(mat);

        return "ordreBekræftelse";
    }
}
