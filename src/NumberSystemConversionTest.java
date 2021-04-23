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
        assertEquals(350, nb.BinaryToDecimal("101011110"));
        assertTrue(nb.OctalToDecimal("45234") == 19100);
        assertTrue(nb.HexaDecimalToDecimal("ABC69") == 703593);
        assertEquals("101011110", nb.DecimalToBinary(350));
        assertEquals("45234", nb.DecimalToOctal(19100));
        assertEquals("ABC69", nb.DecimalToHexaDecimal(703593));
    }

    @Test
    public void checkStringValidation(){
        assertEquals(-2, nb.BinaryToDecimal("10101j234"));
        assertTrue(-8 == nb.OctalToDecimal("1528934"));
        assertTrue(-16 == nb.HexaDecimalToDecimal("Aa3419Dh"));
    }

    @Test
    public void checkSVdoesntCrashtheMethod(){
        assertNotEquals(-2, nb.BinaryToDecimal("111011"));
        assertFalse(-8 == nb.OctalToDecimal("12734"));
        assertFalse(-16 == nb.OctalToDecimal("AC34"));

    }

    @Test
    public void checkValueHandling(){
        assertAll(
        () ->assertEquals("Value smaller than Zero", nb.DecimalToBinary(-23)),
        () ->assertEquals("Value smaller than Zero", nb.DecimalToOctal(-1)),
        () ->assertEquals("Value smaller than Zero", nb.DecimalToHexaDecimal(-92))
        );
    }

    @Test
    public void checkVHdosentCrashtheMethod() {
        assertAll(
                () ->assertNotEquals("Value smaller than Zero", nb.DecimalToBinary(654)),
                () ->assertNotEquals("Value smaller than Zero", nb.DecimalToOctal(18)),
                () ->assertNotEquals("Value smaller than Zero", nb.DecimalToHexaDecimal(87))
        );
        
    }
}
