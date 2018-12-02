import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class BasicStatisticTest
{
    private BasicStatistic basicStatistic;

    @Before
    public void setUp()
    {
        this.basicStatistic = new BasicStatistic();
    }

    @Test
    public void addDoubleToDataTest()
    {
        basicStatistic.addDoubleToData(1.0);
        basicStatistic.addDoubleToData(2.0);
        basicStatistic.addDoubleToData(3.0);

        Assert.assertNotEquals(0, basicStatistic.numberOfDataItems());
        Assert.assertEquals(3, basicStatistic.numberOfDataItems());
    }

    @Test
    public void clearDataTest()
    {
        basicStatistic.clearData();
        Assert.assertEquals(0, basicStatistic.numberOfDataItems());
    }

    @Test
    public void numberOfDataItemsTest()
    {
        Assert.assertEquals(0, basicStatistic.numberOfDataItems());
    }

    @Test
    public void sumTest()
    {
        double val1 = 1.0;
        double val2 = 2.0;
        double val3 = 3.0;

        basicStatistic.addDoubleToData(val1);
        basicStatistic.addDoubleToData(val2);
        basicStatistic.addDoubleToData(val3);

        Assert.assertEquals(6, basicStatistic.sum(), 0);
    }

    private Double[][] sortedValueProvider()
    {
        return new Double[][] {{1.0, 2.0, 3.0, 4.0}, {3.0, 5.0, 7.0, 9.0}, {10.0, 15.0, 20.0, 25.0}};
    }

    @Test
    @Parameters(method="sortedValueProvider")
    public void highestValueNormalTest(double smallest, double lowMiddle, double highMiddle, double highest) throws NoDataItemsException
    {
        basicStatistic.addDoubleToData(smallest);
        basicStatistic.addDoubleToData(lowMiddle);
        basicStatistic.addDoubleToData(highMiddle);
        basicStatistic.addDoubleToData(highest);

        Assert.assertEquals(highest, basicStatistic.highestValue(), 0);
    }

    @Test(expected = NoDataItemsException.class)
    public void highestValueExceptionTest() throws NoDataItemsException
    {
        basicStatistic.highestValue();
    }

    @Test
    @Parameters(method = "sortedValueProvider")
    public void getMeanNormalTest(double smallest, double lowMiddle, double highMiddle, double highest) throws NoDataItemsException
    {
        double expected = (smallest + lowMiddle + highMiddle + highest) / 4.0;

        basicStatistic.addDoubleToData(smallest);
        basicStatistic.addDoubleToData(lowMiddle);
        basicStatistic.addDoubleToData(highMiddle);
        basicStatistic.addDoubleToData(highest);

        Assert.assertEquals(expected, basicStatistic.getMean(), 0);
    }

    @Test(expected = NoDataItemsException.class)
    public void getMeanExceptionTest() throws NoDataItemsException
    {
        basicStatistic.getMean();
    }

    @Test
    @Parameters(method = "sortedValueProvider")
    public void getMedianNormalTest(double smallest, double lowMiddle, double highMiddle, double highest) throws NoDataItemsException
    {
        basicStatistic.addDoubleToData(smallest);
        basicStatistic.addDoubleToData(lowMiddle);
        basicStatistic.addDoubleToData(highMiddle);
        basicStatistic.addDoubleToData(highest);

        Assert.assertEquals(lowMiddle, basicStatistic.getMedian(), 0);
    }
}