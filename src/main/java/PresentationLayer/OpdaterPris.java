package PresentationLayer;

import DBAccess.StyklisteMapper;
import FunctionLayer.CarportException;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Materials;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class OpdaterPris extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        int pris = Integer.parseInt(request.getParameter("pris"));
        int materialeId = Integer.parseInt(request.getParameter("materialeId"));
       // String beskrivelse = request.getParameter("beskrivelse");
       // String enhed = request.getParameter("enhed");



        try {
            StyklisteMapper.opdaterPris(pris, materialeId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "ordreBekræftelse";
    }
}
