package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Skur;
import FunctionLayer.Tag;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static FunctionLayer.Carport.*;

public class LavCarport extends Command{


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int bredde = Integer.parseInt(request.getParameter("bredde"));
        int længde = Integer.parseInt(request.getParameter("længde"));
        int højde = Integer.parseInt(request.getParameter("længde"));
        String tag = request.getParameter("tag");

        Tag tagobject = new Tag(tag, 10);

return null;
    }
}
