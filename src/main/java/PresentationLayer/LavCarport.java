package PresentationLayer;

import FunctionLayer.Carport;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Skur;
import FunctionLayer.Tag;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static DBAccess.CarportMapper.createOrdre;
import static FunctionLayer.Carport.*;

public class LavCarport extends Command{


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        double bredde = Double.parseDouble(request.getParameter("bredde"));
        double længde = Double.parseDouble(request.getParameter("længde"));
        double højde = Double.parseDouble(request.getParameter("højde"));

        double skurbredde = Double.parseDouble(request.getParameter("skurbredde"));
        double skurlængde = Double.parseDouble(request.getParameter("skurlængde"));

        String tag = request.getParameter("tag");
        double taghældning = Double.parseDouble(request.getParameter("taghældning"));

        Carport carportobject = new Carport(højde, bredde, længde);
        Skur skurobject = new Skur(skurbredde, skurlængde);
        Tag tagobject = new Tag(tag, taghældning,"stål");

        createOrdre(carportobject, tagobject, skurobject);

        System.out.println(carportobject.getBredde());
        System.out.println(carportobject.getHøjde());

        return "lavcarport";
    }
}
