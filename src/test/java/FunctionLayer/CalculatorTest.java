package FunctionLayer;

import DBAccess.Connector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;

public class CalculatorTest {

    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();

    }

    @Test
    public void beregnAntalStolperTestPositiv1() {

        // Arrange
        Carport carport = new Carport(200, 240, 240);
        Skur skur = new Skur(180, 180);

        // Act
        double result = calculator.beregnAntalStolper(carport, skur);

        // Assert
        Assert.assertEquals(4.0 ,result,0.005);
    }

    @Test
    public void beregnAntalStolperTestPositiv2() {

        // Arrange
        Carport carport = new Carport(200, 240, 240);
        Skur skur = new Skur(180, 240);

        // Act
        double result = calculator.beregnAntalStolper(carport, skur);

        // Assert
        Assert.assertEquals(4.0 ,result,0.005);
    }


    @Test
    public void beregnAntalStolperTestPositiv3() {

        // Arrange
        Carport carport = new Carport(200, 240, 900);
        Skur skur = new Skur(180, 180);

        // Act
        double result = calculator.beregnAntalStolper(carport, skur);

        // Assert
        Assert.assertEquals(6.0 ,result,0.005);
    }

    @Test
    public void beregnAntalSpærFladtTestPositiv1() {

        // Arrange
        Carport carport = new Carport(200, 240, 240);

        // Act
        double result = calculator.beregnAntalSpærFladt(carport);

        // Assert
        Assert.assertEquals(5.0 ,result,0.005);
    }

    @Test
    public void beregnAntalSpærSkråtLodretTestPositiv1() {

        // Arrange
        Carport carport = new Carport(200, 240, 240);

        // Act
        double result = calculator.beregnAntalSpærSkråtLodret(carport);

        // Assert
        Assert.assertEquals(4.0 ,result,0.005);
    }



    @Test
    public void beregnTagArealTestPositiv1() {

        // Arrange
        Carport carport = new Carport(200, 240, 240);
        Tag tag = new Tag("Fladt tag", 10, "Træ");

        // Act
        double result = calculator.beregnTagAreal(carport, tag);

        // Assert
        Assert.assertEquals(5.85 ,result,0.005);
    }

    @Test
    public void beregnTagArealTestPositiv2() {

        // Arrange
        Carport carport = new Carport(200, 240, 240);
        Tag tag = new Tag("Fladt tag", 0, "Træ");

        // Act
        double result = calculator.beregnTagAreal(carport, tag);

        // Assert
        Assert.assertEquals(5.76 ,result,0.005);
    }

    @Test
    public void udregnStyklisterFladtTestPositiv1() {

        // Arrange
        Carport carport = new Carport(200, 240, 240);
        Tag tag = new Tag("Fladt tag", 0, "Træ");
        Skur skur = new Skur(180, 180);

        // Act
        ArrayList<CalculatedItems> result = calculator.udregnStyklisterFladt(carport, tag, skur);

        // Assert
        Assert.assertEquals(4 ,result.size());
    }

    @Test
    public void beregnTagLægterTestPositiv1() {

        // Arrange
        Carport carport = new Carport(200, 240, 240);
        Tag tag = new Tag("Fladt tag", 0, "Træ");

        // Act
        double result = calculator.beregnTagLægter(carport, tag);

        // Assert
        Assert.assertEquals(8.0 ,result,0.005);
    }

}
