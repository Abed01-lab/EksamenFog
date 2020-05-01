package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static FunctionLayer.Carport.*;

public class GoToLavcarport extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("bredde", (int[]) breddearray);
        servletContext.setAttribute("længde", (int[]) længdearray);
        servletContext.setAttribute("højde", (int[]) højdearray);
        servletContext.setAttribute("tag", (String[]) tagarray);
        servletContext.setAttribute("taghældning", (int[]) taghældning);
        servletContext.setAttribute("skurbredde", (int[]) skurbreddearray);
        servletContext.setAttribute("skurlængde", (int[]) skurlængdearray);
        servletContext.setAttribute("tagmateriale", (String[]) tagmateriale);
        return "designCarport";
    }
}
