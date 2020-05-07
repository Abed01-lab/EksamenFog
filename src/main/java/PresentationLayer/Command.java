package PresentationLayer;

import FunctionLayer.CarportException;
import FunctionLayer.LoginSampleException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "GoToLavcarport", new GoToLavcarport() );
        commands.put( "LavCarport", new LavCarport() );
        commands.put("Ordrebekræftelse", new OrdreBekræftelse());
        commands.put("OpdaterMateriale", new OpdaterMateriale());
        commands.put("DeleteMaterial", new DeleteMaterial());
        commands.put("AdminPage", new AdminPage());
    }

    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws LoginSampleException, CarportException;

}
