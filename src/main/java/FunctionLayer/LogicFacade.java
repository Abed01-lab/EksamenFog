package FunctionLayer;

import DBAccess.CarportMapper;
import DBAccess.ForespørgselMapper;
import DBAccess.OrdreMapper;
import DBAccess.StyklisteMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static Carport createCarport(double højde, double bredde, double længde) {
        //Carport carport = new Carport(højde, bredde, længde);
        //CarportMapper.createCarport(carport);
        //return carport;'
        return null;
    }


    public static List<Materials> deleteMaterial(int serienummer) throws CarportException {
        StyklisteMapper.deleteMaterial(serienummer);
        return getMaterials();
    }

    public static List<Materials> getMaterials() throws CarportException {
        return StyklisteMapper.getStyklister();
    }

    public static List<Materials> opdaterMateriale(String beskrivelse, String enhed, int pris) throws CarportException {
        Materials mat = new Materials(beskrivelse, enhed, pris);
        StyklisteMapper.opdaterMateriale(mat);
        return getMaterials();
    }

    public static List<Materials> opdaterPris(int serienummer, int pris) throws CarportException {
        StyklisteMapper.opdaterPris(serienummer, pris);
        return getMaterials();
    }

    public static Stykliste getStykliste(int forespørgselsId) throws CarportException {
        return StyklisteMapper.getStykliste(forespørgselsId);
    }

    public static int sendForespørgsel(Forespørgsel forespørgsel, Carport carport, Tag tag, Skur skur) throws CarportException {
        int carportId = CarportMapper.createCarport(carport);
        forespørgsel.setCarportId(carportId);
        int tagId = CarportMapper.createTag(tag);
        forespørgsel.setTagId(tagId);
        int skurId = CarportMapper.createSkur(skur);
        forespørgsel.setSkurId(skurId);
        int forespørgselsId = ForespørgselMapper.createForespørgsel(forespørgsel);
        StyklisteMapper.lavStyklisterTilCarport(forespørgselsId, carport, tag, skur);
        return forespørgselsId;
    }

    public static ArrayList<Forespørgsel> getAllForespørgsel() throws CarportException {
        return ForespørgselMapper.getAllForespørgsel();
    }

    public static Forespørgsel getForespørgsel(int forespørgselsId) throws CarportException {
        return ForespørgselMapper.getForespørgsel(forespørgselsId);
    }

    public static Carport getCarport(int carportId) throws CarportException {
        return CarportMapper.getCarport(carportId);
    }

    public static Tag getTag(int tagId) throws CarportException {
        return CarportMapper.getTag(tagId);
    }

    public static Skur getSkur(int skurId) throws CarportException {
        return CarportMapper.getSkur(skurId);
    }

    public static String tegnSVG(Carport carport, Tag tag, Skur skur) {
        return SVGTegner.tegnSVG(carport, tag, skur);
    }


    public static ArrayList<Ordre> getAllOrdrer() throws CarportException {
        return OrdreMapper.getAllOrdrer();
    }

    public static ArrayList<Forespørgsel> accepterForespørgsel(Ordre ordre) throws CarportException {
        OrdreMapper.createOrdre(ordre);
        ForespørgselMapper.accepterForespørgsel(ordre.getForespørgselsId());
        return ForespørgselMapper.getAllForespørgsel();
    }


    public static ArrayList<Forespørgsel> afvisForespørgsel(int forespørgselsId) throws CarportException {
        ForespørgselMapper.afvisForespørgsel(forespørgselsId);
        return ForespørgselMapper.getAllForespørgsel();
    }
}
