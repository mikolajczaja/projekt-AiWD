package aiwd.data;

import aiwd.model.DataRow;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DataRowHolder {

    private static DataRowHolder instance;
    private List<DataRow> dataRowList;

    private DataRowHolder() {
    }

    public static DataRowHolder getInstance() {
        if (instance == null) {
            instance = new DataRowHolder();
        }
        return instance;
    }

    public void setDataRowList(List<DataRow> dataRows) {
        dataRowList = dataRows;
    }

    public List<DataRow> getDataRowList() {
        return dataRowList;
    }

    public List<Object> getColumnData(String attributeName) {
        List<Object> columnData = new ArrayList<>();
        if(attributeName == null || dataRowList == null){
            return columnData;
        }
        for (DataRow dataRow : dataRowList) {
            Object value = getValueByFieldName(attributeName, dataRow);
            addValuesToList(columnData, value);
        }
        return columnData;
    }

    public Object getValueByFieldName(String fieldName, DataRow data) {
        Object value = null;
        try {
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method m = DataRow.class.getMethod(methodName, null);
            value = m.invoke(data);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return value;
    }

    private void addValuesToList(List<Object> columnData, Object value) {
        if(value == null){
            return;
        }
        addValuesFromFieldOfTypeList(columnData, value);
        addValue(columnData, value);
    }

    private void addValue(List<Object> columnData, Object value) {
        if (value instanceof List) {
            return;
        }
        columnData.add(value);
    }

    private void addValuesFromFieldOfTypeList(List<Object> columnData, Object value) {
        if (!(value instanceof List)) {
            return;
        }
        for (Object o : (List) value) {
            if(o != null) {
                columnData.add(o);
            }
        }
    }
}
