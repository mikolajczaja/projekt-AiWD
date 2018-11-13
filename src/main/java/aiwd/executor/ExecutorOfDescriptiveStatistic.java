package aiwd.executor;

import aiwd.exception.NoTypeDefinedForDescriptiveStatisticAttributeException;
import aiwd.exception.WrongTypeException;
import aiwd.model.DescriptiveStatisticOfAttribute;
import java.util.ArrayList;
import java.util.List;

public abstract class ExecutorOfDescriptiveStatistic {

    public abstract void provideData(List<DescriptiveStatisticOfAttribute> attributes);

    public abstract void execute();

    protected boolean isNumberType(DescriptiveStatisticOfAttribute attribute) {
        try {
            validateDescriptiveStatisticOfAttribute(attribute);
            if (attribute.getType().getSuperclass() != null) {
                return attribute.getType().getSuperclass().equals(Number.class);
            } else {
                return false;
            }
        } catch (NoTypeDefinedForDescriptiveStatisticAttributeException e) {
            return false;
        }
    }

    protected boolean isBooleanType(DescriptiveStatisticOfAttribute attribute) {
        try {
            validateDescriptiveStatisticOfAttribute(attribute);
            return attribute.getType().equals(Boolean.class);
        } catch (NoTypeDefinedForDescriptiveStatisticAttributeException e) {
            return false;
        }
    }

    protected boolean isListType(DescriptiveStatisticOfAttribute attribute) {
        try {
            validateDescriptiveStatisticOfAttribute(attribute);
            return attribute.getType().equals(List.class);
        } catch (NoTypeDefinedForDescriptiveStatisticAttributeException e) {
            return false;
        }
    }

    private void validateDescriptiveStatisticOfAttribute(DescriptiveStatisticOfAttribute attribute) throws NoTypeDefinedForDescriptiveStatisticAttributeException {
        if (attribute.getType() == null) {
            throw new NoTypeDefinedForDescriptiveStatisticAttributeException();
        }
    }

    protected double[] doubleListToDoubleArray(List<Double> doubleList) {
        double[] doubleArray = new double[doubleList.size()];
        for (int i = 0; i < doubleList.size(); i++) {
            doubleArray[i] = doubleList.get(i);
        }
        return doubleArray;
    }

    protected List<Double> objectListToDoubleList(List<Object> numbers) {
        List<Double> doubles = new ArrayList<>();
        for (Object object : numbers) {
            try {
                doubles.add(tryParseToDouble(object));
            } catch (WrongTypeException e) {
                e.printStackTrace();
            }
        }
        return doubles;
    }

    private Double tryParseToDouble(Object o) throws WrongTypeException {
        if (o instanceof Integer) {
            return ((Integer) o).doubleValue();
        }
        if (o instanceof Double) {
            return (Double) o;
        }
        throw new WrongTypeException();
    }
}
