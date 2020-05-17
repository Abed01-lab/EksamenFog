package FunctionLayer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatedItemTest {


    private CalculatedItems ci;

    @Before
    public void setUp(){
        ci = new CalculatedItems("spær", 2, 200);
    }


    @Test
    public void getItemNavnTest() {
        String expectedNavn = "rem";
        ci.setItemNavn(expectedNavn);

        assertEquals(expectedNavn, ci.getItemNavn());
    }

    @Test
    public void getItemAntalTest() {
        double expectedAntal = 10;
        ci.setItemAntal(10);

        assertEquals(expectedAntal, ci.getItemAntal(), 1);
    }

    @Test
    public void getItemLængdeTest() {
        double expectedLængde = 350;
        ci.setItemLængde(350);

        assertEquals(expectedLængde, ci.getItemLængde(), 1);
    }

}
