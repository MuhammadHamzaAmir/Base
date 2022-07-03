import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.Test;
import static org.junit.Assert.*;


public class NumberSystemConversionTest {
    
    public NumberSystemConversion nb;
    
    @Before
    public void setUp() throws Exception {
        nb = new NumberSystemConversion();
    }

    @Test
    public void checkFunctionsWorkProperly(){
        assertEquals(350, nb.binaryToDecimal("101011110"));
        assertTrue(nb.octalToDecimal("45234") == 19100);
        assertTrue(nb.hexaDecimalToDecimal("ABC69") == 703593);
        assertEquals("101011110", nb.decimalToBinary(350));
        assertEquals("45234", nb.decimalToOctal(19100));
        assertEquals("ABC69", nb.decimalToHexaDecimal(703593));
    }

    @Test
    public void checkStringValidation(){
        assertEquals(-2, nb.binaryToDecimal("10101j234"));
        assertTrue(-8 == nb.octalToDecimal("1528934"));
        assertTrue(-16 == nb.hexaDecimalToDecimal("Aa3419Dh"));
    }

    @Test
    public void checkSVdoesntCrashtheMethod(){
        assertNotEquals(-2, nb.binaryToDecimal("111011"));
        assertFalse(-8 == nb.octalToDecimal("12734"));
        assertFalse(-16 == nb.octalToDecimal("AC34"));

    }

    @Test
    public void checkValueHandling(){
        assertAll(
        () ->assertEquals("Value smaller than Zero", nb.decimalToBinary(-23)),
        () ->assertEquals("Value smaller than Zero", nb.decimalToOctal(-1)),
        () ->assertEquals("Value smaller than Zero", nb.decimalToHexaDecimal(-92))
        );
    }

    @Test
    public void checkVHdosentCrashtheMethod() {
        assertAll(
                () ->assertNotEquals("Value smaller than Zero", nb.decimalToBinary(654)),
                () ->assertNotEquals("Value smaller than Zero", nb.decimalToOctal(18)),
                () ->assertNotEquals("Value smaller than Zero", nb.decimalToHexaDecimal(87))
        );
        
    }
}
