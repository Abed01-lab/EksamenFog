package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static DBAccess.StyklisteMapper.getTagMaterialer;
import static FunctionLayer.Carport.*;

public class GoToLavcarport extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("bredde", breddearray);
        servletContext.setAttribute("længde", længdearray);
        servletContext.setAttribute("højde", højdearray);
        servletContext.setAttribute("tag", tagarray);
        servletContext.setAttribute("taghældning", taghældning);
        servletContext.setAttribute("skurbredde", skurbreddearray);
        servletContext.setAttribute("skurlængde", skurlængdearray);
        servletContext.setAttribute("tagmateriale", getTagMaterialer());
        return "designCarport";
    }
}
