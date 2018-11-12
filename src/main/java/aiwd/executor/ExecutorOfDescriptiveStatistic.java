package aiwd.executor;

import aiwd.exception.NoTypeDefinedForDescriptiveStatisticAttributeException;
import aiwd.model.DataRow;
import aiwd.model.DescriptiveStatisticOfAttribute;
import aiwd.model.ExecutionResult;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class ExecutorOfDescriptiveStatistic {

    public abstract void provideData(List<DescriptiveStatisticOfAttribute> attributes, List<DataRow> dataRows);

    public abstract ExecutionResult execute();

    protected Object getValueByFieldName(String name, DataRow data) {
        Object value = null;
        try {
            String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
            Method m = data.getClass().getMethod(methodName, null);
            value = m.invoke(data);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return value;
    }

    protected boolean isNumberType(DescriptiveStatisticOfAttribute attribute) {
        try {
            validateDescriptiveStatisticOfAttribute(attribute);
            return attribute.getType().getSuperclass().equals(Number.class);
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
        if (attribute.getType() == null || attribute.getType().getSuperclass() == null) {
            throw new NoTypeDefinedForDescriptiveStatisticAttributeException();
        }
    }

}
