package PresentationLayer;

import DBAccess.StyklisteMapper;
import FunctionLayer.CarportException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Materials;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class opdaterMateriale extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        String deminsion = request.getParameter("deminsion");
        int længde = Integer.parseInt(request.getParameter("længde"));
        int antal = Integer.parseInt(request.getParameter("antal"));
        String enhed = request.getParameter("enhed");
        String beskrivelse = request.getParameter("beskrivelse");

        Materials mat = new Materials(deminsion, længde, antal, enhed, beskrivelse);

        StyklisteMapper.opdaterMaterialeFladtTag(mat);

        return "opdaterMateriale";
    }
}
