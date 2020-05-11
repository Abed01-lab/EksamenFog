package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class DeleteMaterial extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        ServletContext servletContext = request.getServletContext();
        int serienummer = Integer.parseInt(request.getParameter("serienummer"));
        servletContext.setAttribute("materials", LogicFacade.deleteMaterial(serienummer));

        return "opdaterMaterialeAdmin";
    }
}
