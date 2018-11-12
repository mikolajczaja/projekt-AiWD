package aiwd.executor;

import aiwd.exception.WrongTypeException;
import aiwd.model.DataRow;
import aiwd.model.DescriptiveStatisticOfAttribute;
import aiwd.model.ExecutionResult;
import org.apache.commons.math3.stat.descriptive.rank.Median;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetermineMedianVale extends ExecutorOfDescriptiveStatistic {

    private List<DescriptiveStatisticOfAttribute> attributesToProcess;
    private List<DataRow> dataToProcess;

    public DetermineMedianVale() {
        this.attributesToProcess = new ArrayList<>();
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
            evaluateMedianValue(columnData,attribute);
        }
        return null;
    }

    private void evaluateMedianValue(List<Double> columnData, DescriptiveStatisticOfAttribute attribute) {
        if(columnData == null || columnData.isEmpty()){
            return;
        }
        Median median = new Median();
        double[] columnDataArray = processToDoubleArray(columnData);
        double result = median.evaluate(columnDataArray);
        attribute.setMedian(result);
    }

    private double[] processToDoubleArray(List<Double> columnData) {
        double[] columnDataArray = new double[columnData.size()];
        for (int i = 0; i < columnData.size(); i++) {
            columnDataArray[i] = (double) columnData.get(i);
        }
        return columnDataArray;
    }

    private List<Double> extractColumnData(DescriptiveStatisticOfAttribute attribute) {
        List<Double> columnData = new ArrayList<>();
        for (DataRow data : dataToProcess) {
            Object value = getValueByFieldName(attribute.getAttributeName(), data);
            if (value != null) {
                addValuesToList(columnData, value);
            }
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
