package TestDriven;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class TestDrivenTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testRangeValues()
    {
        int[] inputValues = new int[]{4, 5};
        assertTrue( TestDriven.getRange(inputValues) == "4-5, 2" );
    }
}
