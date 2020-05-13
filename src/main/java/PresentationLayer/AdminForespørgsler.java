package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminForespørgsler extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("kundeForepørgsler", LogicFacade.getAllForespørgsel());
        return "forespørgslerStatusAdmin";
    }
}
