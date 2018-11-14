package aiwd.executor;

import aiwd.data.DataRowHolder;
import aiwd.model.DescriptiveStatisticOfAttribute;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetermineInterquartileRangeValue extends ExecutorOfDescriptiveStatistic{

    private List<DescriptiveStatisticOfAttribute> attributesToProcess;

    public DetermineInterquartileRangeValue() {
        this.attributesToProcess = new ArrayList<>();
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
            evaluateInterquartileRangeValue(columnData,attribute);
        }
    }

    private void evaluateInterquartileRangeValue(List<Double> columnData, DescriptiveStatisticOfAttribute attribute) {
        if (columnData == null || columnData.isEmpty()) {
            return;
        }
        Percentile quantile25 = new Percentile(25.0);
        Percentile quantile75 = new Percentile(75.0);
        double[] columnDataArray = doubleListToDoubleArray(columnData);
        attribute.setInterquartileRange(quantile75.evaluate(columnDataArray) - quantile25.evaluate(columnDataArray));
    }
}
