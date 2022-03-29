package TestDriven;

import static TestDriven.TestDriven.SENSOR10BIT;
import static TestDriven.TestDriven.SENSOR12BIT;
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
    public void testRangeValues(int[] inputValues, String expectedOutput, String sensortType)
    {
        //System.out.println(expectedOutput);
        assertTrue(TestDriven.getRange(inputValues, sensortType).equals(expectedOutput));
    }

    @Test
    public void passInputsToTest(){

        testRangeValues(new int[]{4094, 4095}, "10-10, 1", SENSOR12BIT);
        testRangeValues(new int[]{4095, 4096, 5000, 5000}, "", SENSOR12BIT);
        testRangeValues(new int[]{0}, "0-0, 1", SENSOR12BIT);
        testRangeValues(new int[]{0, 0, 0, 0}, "0-0, 4", SENSOR12BIT);
        testRangeValues(new int[]{0, 1, 2, 4, 5, 4000, 4001, 4002, 4094}, "0-0, 5\n10-10, 4", SENSOR12BIT);


        testRangeValues(new int[]{0,100,150,300,500,70,1500,700,600,2000,1022}, "0-0, 1\n3-3, 1\n6-6, 2\n11-13, 3\n15-15, 2", SENSOR10BIT);
        testRangeValues(new int[]{0}, "15-15, 1", SENSOR10BIT);
        testRangeValues(new int[]{511}, "0-0, 1", SENSOR10BIT);
        testRangeValues(new int[]{1022}, "15-15, 1", SENSOR10BIT);

    }
}
