package PresentationLayer;

import DBAccess.StyklisteMapper;
import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Skur;
import FunctionLayer.Tag;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import static DBAccess.CarportMapper.*;
import static FunctionLayer.Carport.enhedArray;

public class LavCarport extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("enhed", enhedArray);
        servletContext.setAttribute("materialeId", StyklisteMapper.getStyklisterId());

        double bredde = Double.parseDouble(request.getParameter("bredde"));
        double længde = Double.parseDouble(request.getParameter("længde"));
        double højde = Double.parseDouble(request.getParameter("højde"));

        double skurbredde = Double.parseDouble(request.getParameter("skurbredde"));
        double skurlængde = Double.parseDouble(request.getParameter("skurlængde"));

        String tag = request.getParameter("tag");
        double taghældning = Double.parseDouble(request.getParameter("taghældning"));
        String tagmateriale = request.getParameter("tagmateriale");

        Carport carportobject = new Carport(højde, bredde, længde);

        Skur skurobject = new Skur(skurbredde, skurlængde);
        if (skurbredde == 0) {
            skurobject = new Skur(0, 0);
        } else {
            skurobject = new Skur(skurbredde, skurlængde);
        }
        Tag tagobject = new Tag(tag, taghældning, tagmateriale);


        createSkur(skurobject);
        createTag(tagobject);
        try {
            createOrdre(carportobject, tagobject, skurobject);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(carportobject.getBredde());
        System.out.println(carportobject.getHøjde());

        return "designCarport"; // TODO
    }
}
