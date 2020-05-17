package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("GoToLavcarport", new GoToLavcarport());
        commands.put("LavCarport", new LavCarport());
        commands.put("OpdaterMateriale", new OpdaterMateriale());
        commands.put("DeleteMaterial", new DeleteMaterial());
        commands.put("AdminPage", new AdminPage());
        commands.put("OpdaterPris", new OpdaterPris());
        commands.put("AdminForespørgsler", new AdminForespørgsler());
        commands.put("AdminSeForespørgsel", new AdminSeForespørgsel());
        commands.put("Tegning", new Tegning()); // skal muligvis ikke bruges
        commands.put("SendForespørgsel", new SendForespørgsel());
        commands.put("AdminAccepterForespørgsel", new AdminAccepterForespørgsel());
        commands.put("AdminAfvisForespørgsel", new AdminAfvisForespørgsel());
        commands.put("AdminOrdrer", new AdminOrdrer());
        commands.put("SeForside", new SeForside());
        commands.put("SetStandardStykliste", new SetStandardStykliste());

    }

    static Command from(HttpServletRequest request) {
        String targetName = request.getParameter("target");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand());   // unknowncommand er default.
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException, CarportException;

}
