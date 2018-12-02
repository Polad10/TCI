import java.util.ArrayList;
import java.util.Comparator;

/**
 * very simple implementation of the BasicStatisticInterface
 */

public class BasicStatistic implements BasicStatisticInterface
{
    ArrayList<Double> data;

    BasicStatistic()
    {
        data = new ArrayList<Double>();
    }

    @Override
    public void addDoubleToData(double valueToAdd)
    {
        data.add(valueToAdd);
    }

    @Override
    public void clearData()
    {
        data.clear();
    };

    @Override
    public int numberOfDataItems()
    {
        return data.size();
    }

    @Override
    public double sum()
    {
        double sum = 0;

        for(double val : data)
        {
            sum += val;
        }

        return sum;
    }

    @Override
    public double highestValue() throws NoDataItemsException
    {
        if(data.size() == 0)
        {
            throw new NoDataItemsException();
        }
        else
        {
            double highest = data.get(0);

            for(double val : data)
            {
                if(val > highest)
                {
                    highest = val;
                }
            }

            return highest;
        }
    }

    @Override
    public double getMean() throws NoDataItemsException
    {
        if(data.size() == 0)
        {
            throw new NoDataItemsException();
        }
        else
        {
            double sum = sum();
            double count = numberOfDataItems();

            return sum / count;
        }
    }

    @Override
    public double getMedian() throws NoDataItemsException
    {
        int dataSize = data.size();

        if(dataSize == 0)
        {
            throw new NoDataItemsException();
        }
        else
        {
            sortData();

            int lastIndex = dataSize - 1;
            int middleIndex = lastIndex / 2;

            return data.get(middleIndex);
        }
    }

    @Override
    public double getStandardDeviation() throws NoDataItemsException {
        double rv = 0.0;
        return rv;
    }

    private void sortData()
    {
        data.sort(new Comparator<Double>() {
            @Override
            public int compare(Double val1, Double val2)
            {
                return val1.compareTo(val2);
            }
        });
    }
}