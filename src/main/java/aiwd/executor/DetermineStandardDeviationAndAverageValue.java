package aiwd.executor;

import aiwd.data.DataRowHolder;
import aiwd.model.DescriptiveStatisticOfAttribute;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetermineStandardDeviationAndAverageValue extends ExecutorOfDescriptiveStatistic {

    private List<DescriptiveStatisticOfAttribute> attributesToProcess;

    public DetermineStandardDeviationAndAverageValue() {
        attributesToProcess = new ArrayList<>();
    }

    @Override
    public void provideData(List<DescriptiveStatisticOfAttribute> attributes) {
        attributesToProcess.addAll(attributes.stream().filter(this::isNumberType).collect(Collectors.toList()));
        attributesToProcess.addAll(attributes.stream().filter(this::isListType).collect(Collectors.toList()));
    }

    @Override
    public void execute() {
        for (DescriptiveStatisticOfAttribute attribute : attributesToProcess) {
            List<Object> objects = DataRowHolder.getInstance().getColumnData(attribute.getAttributeName());
            List<Double> columnData = objectListToDoubleList(objects);
            evaluateStandardDeviation(attribute, columnData);
            evaluateAverageValue(attribute, columnData);
        }
    }

    private void evaluateStandardDeviation(DescriptiveStatisticOfAttribute attribute, List<Double> columnData) {
        if (columnData == null || columnData.isEmpty()) {
            return;
        }
        StandardDeviation standardDeviation = new StandardDeviation();
        double[] columnDataArray = doubleListToDoubleArray(columnData);
        attribute.setStandardDeviation(standardDeviation.evaluate(columnDataArray));
    }

    private void evaluateAverageValue(DescriptiveStatisticOfAttribute attribute, List<Double> columnData) {
        if (columnData == null || columnData.isEmpty()) {
            return;
        }
        double sum = 0.0;
        for (Double d : columnData) {
            sum += d;
        }
        attribute.setAvgValue(sum / columnData.size());
    }
}