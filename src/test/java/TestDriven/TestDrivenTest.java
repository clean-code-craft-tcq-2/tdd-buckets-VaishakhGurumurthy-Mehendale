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
    public void testRangeValues(int[] inputValues, String expectedOutput)
    {
        //System.out.println(expectedOutput);
        assertTrue(TestDriven.getRange(inputValues).equals(expectedOutput));
    }

    @Test
    public void passInputsToTest(){
        int[] inputValues1 = new int[]{1,3, 3, 1, 5, 4, 10, 11, 12, 12, 4, 17};
        String expectedOutput1 = "10-12, 4\n" + "3-5, 5";
        testRangeValues(inputValues1, expectedOutput1);

        int[] inputValues2 = new int[]{1,3, 3, 1, 5, 4, 10, 11, 12, 12, 4, 17, 18};
        String expectedOutput2 = "17-18, 2\n" + "10-12, 4\n" + "3-5, 5";
        testRangeValues(inputValues2, expectedOutput2);

        int[] inputValues3 = new int[]{1};
        String expectedOutput3 = "";
        testRangeValues(inputValues3, expectedOutput3);

        int[] inputValues4 = new int[]{1,1,1,1,1,1};
        String expectedOutput4 = "";
        testRangeValues(inputValues4, expectedOutput4);

        int[] inputValues5 = new int[]{1, 2, 3, 4, 5, 6, 8, 200, 201, 222, 14, 15, 19};
        String expectedOutput5 = "200-201, 2\n" + "14-15, 2\n" + "1-6, 6";

        testRangeValues(inputValues5, expectedOutput5);

        int[] inputValues6 = new int[]{};
        String expectedOutput6 = "";
        testRangeValues(inputValues6, expectedOutput6);
    }
}
