package aiwd.model;

public class DescriptiveStatisticOfAttribute<T> {

    private String attributeName;
    private Class type;
    private T minValue;
    private T maxValue;
    private Double avgValue;
    private Double standardDeviation;
    private T median;
    private T interquartileRange;

    public DescriptiveStatisticOfAttribute(String attributeName, Class type) {
        this.attributeName = attributeName;
        this.type = type;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public T getMinValue() {
        return minValue;
    }

    public void setMinValue(T minValue) {
        this.minValue = minValue;
    }

    public T getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(T maxValue) {
        this.maxValue = maxValue;
    }

    public Double getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(Double avgValue) {
        this.avgValue = avgValue;
    }

    public Double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(Double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }

    public T getMedian() {
        return median;
    }

    public void setMedian(T median) {
        this.median = median;
    }

    public T getInterquartileRange() {
        return interquartileRange;
    }

    public void setInterquartileRange(T interquartileRange) {
        this.interquartileRange = interquartileRange;
    }
}
