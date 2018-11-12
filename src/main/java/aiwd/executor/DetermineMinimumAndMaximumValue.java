package aiwd.executor;

import aiwd.model.DataRow;
import aiwd.model.DescriptiveStatisticOfAttribute;
import aiwd.model.ExecutionResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetermineMinimumAndMaximumValue extends ExecutorOfDescriptiveStatistic {

    private List<DescriptiveStatisticOfAttribute> attributesToProcess;
    private List<DataRow> dataToProcess;


    public DetermineMinimumAndMaximumValue() {
        this.attributesToProcess = new ArrayList<>();
    }

    @Override
    public void provideData(List<DescriptiveStatisticOfAttribute> attributes, List<DataRow> dataRows) {
        attributesToProcess.addAll(attributes.stream().filter(this::isNumberType).collect(Collectors.toList()));
        attributesToProcess.addAll(attributes.stream().filter(this::isBooleanType).collect(Collectors.toList()));
        attributesToProcess.addAll(attributes.stream().filter(this::isListType).collect(Collectors.toList()));
        dataToProcess = dataRows;
    }

    @Override
    public ExecutionResult execute() {
        for (DescriptiveStatisticOfAttribute attribute : attributesToProcess) {
            for (DataRow data : dataToProcess) {
                setMinimumAndMaximumValue(attribute, getValueByFieldName(attribute.getAttributeName(), data));
            }
        }
        return null;
    }

    private void setMinimumAndMaximumValue(DescriptiveStatisticOfAttribute attribute, Object value) {
        if (value == null) {
            return;
        }
        setMinimumAndMaximumValueForInteger(attribute, value);
        setMinimumAndMaximumValueForDouble(attribute, value);
        setMinimumAndMaximumValueForBoolean(attribute, value);
        setMinimumAndMaximumValueForList(attribute, value);
    }

    private void setMinimumAndMaximumValueForList(DescriptiveStatisticOfAttribute attribute, Object value) {
        if (!(value instanceof List)) {
            return;
        }
        for (Object object : (List) value) {
            setMinimumAndMaximumValueForInteger(attribute, object);
            setMinimumAndMaximumValueForDouble(attribute, object);
            setMinimumAndMaximumValueForBoolean(attribute, object);
        }
    }

    private void setMinimumAndMaximumValueForBoolean(DescriptiveStatisticOfAttribute attribute, Object value) {
        if (!(value instanceof Boolean)) {
            return;
        }
        Boolean min = (Boolean) attribute.getMinValue();
        Boolean max = (Boolean) attribute.getMaxValue();
        if (min == null) {
            attribute.setMinValue(value);
        }
        if (max == null) {
            attribute.setMaxValue(value);
        }
        if (((Boolean) value)) {
            attribute.setMaxValue(value);
        } else {
            attribute.setMinValue(value);
        }
    }

    private void setMinimumAndMaximumValueForDouble(DescriptiveStatisticOfAttribute attribute, Object value) {
        if (!(value instanceof Double)) {
            return;
        }
        Double min = (Double) attribute.getMinValue();
        Double max = (Double) attribute.getMaxValue();
        if (min == null) {
            min = (Double) value;
            attribute.setMinValue(value);
        }
        if (max == null) {
            max = (Double) value;
            attribute.setMaxValue(value);
        }
        if ((Double) value < min) {
            attribute.setMinValue(value);
        }
        if ((Double) value > max) {
            attribute.setMaxValue(value);
        }
    }

    private void setMinimumAndMaximumValueForInteger(DescriptiveStatisticOfAttribute attribute, Object value) {
        if (!(value instanceof Integer)) {
            return;
        }
        Integer min = (Integer) attribute.getMinValue();
        Integer max = (Integer) attribute.getMaxValue();
        if (min == null) {
            min = (Integer) value;
            attribute.setMinValue(value);
        }
        if (max == null) {
            max = (Integer) value;
            attribute.setMaxValue(value);
        }
        if ((Integer) value < min) {
            attribute.setMinValue(value);
        }
        if ((Integer) value > max) {
            attribute.setMaxValue(value);
        }
    }
}
