package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static DBAccess.StyklisteMapper.opdaterStandardStykliste;

public class SetStandardStykliste extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        ServletContext servletContext = request.getServletContext();
        String styklistetype = request.getParameter("styklisteType").toLowerCase();
        int materialeId = Integer.parseInt(request.getParameter("materialeId"));
        opdaterStandardStykliste(styklistetype, materialeId);
        //servletContext.setAttribute("materials", LogicFacade.deleteMaterial(serienummer));

        return "opdaterMaterialeAdmin";
    }
}