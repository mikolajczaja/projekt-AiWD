package aiwd.executor;

import aiwd.data.DataRowHolder;
import aiwd.model.DescriptiveStatisticOfAttribute;
import org.apache.commons.math3.stat.descriptive.rank.Percentile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetermineOutliers extends ExecutorOfDescriptiveStatistic {

    private List<DescriptiveStatisticOfAttribute> attributesToProcess;

    public DetermineOutliers() {
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
            evaluateOutliers(columnData,attribute);
        }
    }

    private void evaluateOutliers(List<Double> columnData, DescriptiveStatisticOfAttribute attribute) {
        if (columnData == null || columnData.isEmpty() || attribute.getInterquartileRange() == null) {
            return;
        }
        Percentile quantile25 = new Percentile(25.0);
        Percentile quantile75 = new Percentile(75.0);
        double[] columnDataArray = doubleListToDoubleArray(columnData);
        double q25 = quantile25.evaluate(columnDataArray);
        double q75 = quantile75.evaluate(columnDataArray);

        double lowerRange = (q25 - 1.5 * (double) attribute.getInterquartileRange());
        double upperRange = (q75 + 1.5 * (double) attribute.getInterquartileRange());

        for (Double data : columnData) {
            if (data <= lowerRange || data >= upperRange) {
                attribute.addOutlier(data);
            }
        }
    }
}
