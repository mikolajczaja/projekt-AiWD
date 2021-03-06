package aiwd.executor;

import aiwd.data.DataRowHolder;
import aiwd.model.DescriptiveStatisticOfAttribute;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetermineSpecificQuantiles extends ExecutorOfDescriptiveStatistic {

    private List<DescriptiveStatisticOfAttribute> attributesToProcess;

    public DetermineSpecificQuantiles() {
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
            double[] columnDataArray = doubleListToDoubleArray(columnData);
            attribute.setQuantile10(evaluateQuantile(columnDataArray,10.0));
            attribute.setQuantile90(evaluateQuantile(columnDataArray,90.0));
        }
    }

    private Double evaluateQuantile(double[] columnData, double percent) {
        if (columnData == null || columnData.length == 0) {
            return null;
        }
        Percentile quantile = new Percentile(percent);
        return quantile.evaluate(columnData);
    }
}
