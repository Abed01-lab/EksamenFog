package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminForespørgsler extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, CarportException {
        return "forespørgslerStatusAdmin";
    }
}
