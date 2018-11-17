import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicStatisticTest
{
    BasicStatistic basicStatistic = new BasicStatistic();

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

        Assert.assertEquals(6, basicStatistic.sum(), Double.POSITIVE_INFINITY);
    }

    @Test
    public void highestValueNormalTest() throws NoDataItemsException
    {
        basicStatistic.addDoubleToData(1.0);
        basicStatistic.addDoubleToData(2.0);
        basicStatistic.addDoubleToData(3.0);

        Assert.assertEquals(3.0, basicStatistic.highestValue(), Double.POSITIVE_INFINITY);
    }

    @Test
    public void highestValueExceptionTest()
    {
        try
        {
            basicStatistic.highestValue();
            fail();
        }
        catch (NoDataItemsException ex)
        {

        }
    }

    @Test
    public void getMeanNormalTest() throws NoDataItemsException
    {
        basicStatistic.addDoubleToData(1.0);
        basicStatistic.addDoubleToData(2.0);
        basicStatistic.addDoubleToData(3.0);

        Assert.assertEquals(2.0, basicStatistic.getMean(), Double.POSITIVE_INFINITY);
    }

    @Test
    public void getMeanExceptionTest()
    {
        try
        {
            basicStatistic.getMean();
            fail();
        }
        catch (NoDataItemsException ex)
        {

        }
    }
}