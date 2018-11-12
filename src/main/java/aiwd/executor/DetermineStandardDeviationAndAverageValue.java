package aiwd.executor;

import aiwd.exception.WrongTypeException;
import aiwd.model.DataRow;
import aiwd.model.DescriptiveStatisticOfAttribute;
import aiwd.model.ExecutionResult;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetermineStandardDeviationAndAverageValue extends ExecutorOfDescriptiveStatistic {

    private List<DescriptiveStatisticOfAttribute> attributesToProcess;
    private List<DataRow> dataToProcess;

    public DetermineStandardDeviationAndAverageValue() {
        attributesToProcess = new ArrayList<>();
    }

    @Override
    public void provideData(List<DescriptiveStatisticOfAttribute> attributes, List<DataRow> dataRows) {
        attributesToProcess.addAll(attributes.stream().filter(this::isNumberType).collect(Collectors.toList()));
        attributesToProcess.addAll(attributes.stream().filter(this::isListType).collect(Collectors.toList()));
        dataToProcess = dataRows;
    }

    @Override
    public ExecutionResult execute() {
        for (DescriptiveStatisticOfAttribute attribute : attributesToProcess) {
            List<Double> columnData = extractColumnData(attribute);
            evaluateStandardDeviation(attribute, columnData);
            evaluateAverageValue(attribute, columnData);
        }
        return null;
    }

    private void evaluateStandardDeviation(DescriptiveStatisticOfAttribute attribute, List<Double> columnData) {
        if (columnData == null || columnData.isEmpty()) {
            return;
        }
        StandardDeviation standardDeviation = new StandardDeviation();
        double[] columnDataArray = new double[columnData.size()];
        for (int i = 0; i < columnData.size(); i++) {
            columnDataArray[i] = columnData.get(i);
        }
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

    private List<Double> extractColumnData(DescriptiveStatisticOfAttribute attribute) {
        List<Double> columnData = new ArrayList<>();
        for (DataRow data : dataToProcess) {
            Object value = getValueByFieldName(attribute.getAttributeName(), data);
            addValuesToList(columnData, value);
        }
        return columnData;
    }

    private void addValuesToList(List<Double> columnData, Object value){
        if (value == null) {
            return;
        }
        addValuesFromFieldOfTypeList(columnData, value);
        addValue(columnData, value);
    }

    private void addValue(List<Double> columnData, Object value){
        if (value instanceof List) {
            return;
        }
        try {
            columnData.add(getValueBasingOnType(value));
        } catch (WrongTypeException e) {
            e.printStackTrace();
        }
    }

    private void addValuesFromFieldOfTypeList(List<Double> columnData, Object value) {
        if (!(value instanceof List)) {
            return;
        }
        for (Object o : (List) value) {
            try {
                columnData.add(getValueBasingOnType(o));
            } catch (WrongTypeException e) {
                e.printStackTrace();
            }
        }
    }

    private Double getValueBasingOnType(Object value) throws WrongTypeException {
        if (value instanceof Double) {
            return (Double) value;
        }
        if (value instanceof Integer) {
            return Double.valueOf((Integer) value);
        }
        throw new WrongTypeException();
    }
}