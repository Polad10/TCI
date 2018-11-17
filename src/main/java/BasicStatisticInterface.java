/**
 * This utility interface is used for doing statistics calculations
 * The interface has 2 responsibilities:
 * -collecting data to do statistics calculations on
 * -doing the statistics calculations
 *
 * Data items are Double objects.
 */

public interface BasicStatisticInterface {
    /**
    * @param valueToAdd value which will be added.
    */
    void addDoubleToData(double valueToAdd);

    /**
     * clear all data items
     */
    void clearData();

    /**
     * this method returns the number of data items.
     *
     * @return number of data items.
     */
    int numberOfDataItems();

    /**
     * this method returns the sum of all collected data items
     *
     * @return the sum of the data items, or 0 when no data items are present
     */
    double sum();

    /**
     * this method returns the highest value of the collected data items.
     * returns NoDataItemsException when there are no data items to calculate on.
     *
     * @return
     */
    double highestValue()  throws NoDataItemsException;

    /**
     * calculates the Mean of the data items
     * returns NoDataItemsException when there are no data items to calculate on.
     *
     * @return mean value of data items
     */
    double getMean() throws NoDataItemsException;

    /**
     * calculates the Mean of the data items
     * returns NoDataItemsException when there are no data items to calculate on.
     *
     * @return median value of data items
     */
    double getMedian() throws NoDataItemsException;

    /**
     * calculates the standard deviation of the data items
     * returns NoDataItemsException when there are no data items to calculate on.
     *
     * @return median value of data items
     */
    double getStandardDeviation() throws NoDataItemsException;
}
