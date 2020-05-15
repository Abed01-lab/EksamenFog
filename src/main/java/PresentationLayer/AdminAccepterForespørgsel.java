package PresentationLayer;

import FunctionLayer.CarportException;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Ordre;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminAccepterForespørgsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        int forespørgselsId = Integer.parseInt(request.getParameter("forespørgselsId"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dato = sdf.format(new Date());

        Ordre ordre = new Ordre(dato, forespørgselsId);


        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("kundeForepørgsler", LogicFacade.accepterForespørgsel(ordre));
        return "forespørgslerStatusAdmin";
    }
}
