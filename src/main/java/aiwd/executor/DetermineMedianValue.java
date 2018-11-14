package aiwd.executor;

import aiwd.data.DataRowHolder;
import aiwd.model.DescriptiveStatisticOfAttribute;
import org.apache.commons.math3.stat.descriptive.rank.Median;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetermineMedianValue extends ExecutorOfDescriptiveStatistic {

    private List<DescriptiveStatisticOfAttribute> attributesToProcess;

    public DetermineMedianValue() {
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
            evaluateMedianValue(columnData,attribute);
        }
    }

    private void evaluateMedianValue(List<Double> columnData, DescriptiveStatisticOfAttribute attribute) {
        if(columnData == null || columnData.isEmpty()){
            return;
        }
        Median median = new Median();
        double[] columnDataArray = doubleListToDoubleArray(columnData);
        double result = median.evaluate(columnDataArray);
        attribute.setMedian(result);
    }
}
