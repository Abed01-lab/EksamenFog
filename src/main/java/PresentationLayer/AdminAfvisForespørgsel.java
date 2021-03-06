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

public class AdminAfvisForespørgsel extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        int forespørgselsId = Integer.parseInt(request.getParameter("forespørgselsId"));

        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("kundeForepørgsler", LogicFacade.afvisForespørgsel(forespørgselsId));
        return "forespørgslerStatusAdmin";
    }
}
