package aiwd.model;

import java.util.ArrayList;
import java.util.List;

public class DescriptiveStatisticOfAttribute<T> {

    private String attributeName;
    private Class type;
    private T minValue;
    private T maxValue;
    private T avgValue;
    private T standardDeviation;
    private T median;
    private T interquartileRange;
    private T quantile10;
    private T quantile90;
    private List<T> outliers;

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

    public T getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(T avgValue) {
        this.avgValue = avgValue;
    }

    public T getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(T standardDeviation) {
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

    public T getQuantile10() {
        return quantile10;
    }

    public void setQuantile90(T quantile90) {
        this.quantile90 = quantile90;
    }

    public T getQuantile90() {
        return quantile90;
    }

    public void setQuantile10(T quantile10) {
        this.quantile10 = quantile10;
    }

    public List<T> getOutliers() {
        return outliers;
    }

    public void setOutliers(List<T> outliers) {
        this.outliers = outliers;
    }

    public void addOutlier(T outlier) {
        if (outliers == null) {
            outliers = new ArrayList<>();
        }
        outliers.add(outlier);
    }
}
