package aiwd.data;

import aiwd.model.DataRow;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

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

    public List<DataRow> getDataRowList() {
        return dataRowList;
    }

    public void setDataRowList(List<DataRow> dataRows) {
        dataRowList = dataRows;
    }

    public List<Object> getColumnData(String attributeName) {
        List<Object> columnData = new ArrayList<>();
        if (attributeName == null || dataRowList == null) {
            return columnData;
        }
        for (DataRow dataRow : dataRowList) {
            Object value = getValueByFieldName(attributeName, dataRow);
            addValuesToList(columnData, value);
        }
        return columnData;
    }

    public Map<String, List<Object>> getAllColumnDataSortedByColumnNames() {
        Map<String, List<Object>> allColumnDataSortedByColumnNames = new HashMap<>();

        for (Field field : DataRow.class.getDeclaredFields()) {
            for (DataRow dataRow : getDataRowList()) {
                List<Object> columnDataForSingleKey = allColumnDataSortedByColumnNames.get(field.getName());
                if (columnDataForSingleKey == null) {
                    columnDataForSingleKey = new LinkedList<>();
                }
                Object valueByFieldName = getValueByFieldName(field.getName(), dataRow);
                if (valueByFieldName instanceof List) {
                    columnDataForSingleKey.addAll((List) valueByFieldName);
                } else {
                    columnDataForSingleKey.add(valueByFieldName);
                }

                allColumnDataSortedByColumnNames.put(field.getName(), columnDataForSingleKey);
            }
        }
        return allColumnDataSortedByColumnNames;
    }

    public Map<String, List<Object>> getAllColumnDataExceptBooleanAndStringFieldsSortedByColumnNames() {
        Map<String, List<Object>> allColumnDataSortedByColumnNames = new HashMap<>();

        for (Field field : DataRow.class.getDeclaredFields()) {
            for (DataRow dataRow : getDataRowList()) {
                List<Object> columnDataForSingleKey = allColumnDataSortedByColumnNames.get(field.getName());
                if (columnDataForSingleKey == null) {
                    columnDataForSingleKey = new LinkedList<>();
                }
                Object valueByFieldName = getValueByFieldName(field.getName(), dataRow);
                if ((field.getType() != Boolean.class) && (field.getType() != String.class)) {
                    if (valueByFieldName instanceof List) {
                        columnDataForSingleKey.addAll((List) valueByFieldName);
                    } else {
                        columnDataForSingleKey.add(valueByFieldName);
                    }
                }

                allColumnDataSortedByColumnNames.put(field.getName(), columnDataForSingleKey);
            }
        }
        return allColumnDataSortedByColumnNames;
    }

    public Map<String, List<Double>> getAllParsableToDoubleColumnDataFieldsSortedByColumnNames() {
        Map<String, List<Double>> allColumnDataSortedByColumnNames = new HashMap<>();

        for (Field field : DataRow.class.getDeclaredFields()) {
            for (DataRow dataRow : getDataRowList()) {
                List<Double> columnDataForSingleKey = allColumnDataSortedByColumnNames.get(field.getName());
                if (columnDataForSingleKey == null) {
                    columnDataForSingleKey = new LinkedList<>();
                }
                Object valueByFieldName = getValueByFieldName(field.getName(), dataRow);
                if ((field.getType() != Boolean.class) && (field.getType() != String.class)) {
                    if (valueByFieldName instanceof List) {
                        columnDataForSingleKey.addAll((List<Double>) valueByFieldName);
                    } else if (valueByFieldName instanceof Double) {
                        columnDataForSingleKey.add((double) valueByFieldName);
                    }
                }

                allColumnDataSortedByColumnNames.put(field.getName(), columnDataForSingleKey);
            }
        }
        return allColumnDataSortedByColumnNames;
    }

    public int getRowsCount() {
        return dataRowList.size();
    }

    public String[] getAllFieldNames() {
        List<String> allFieldNames = new LinkedList<>();
        for (Field field : DataRow.class.getDeclaredFields()) {
            allFieldNames.add(field.getName());
        }
        return allFieldNames.toArray(new String[0]);
    }

    public String[] getAllFieldNamesExceptBooleanAndStringFields() {
        List<String> allFieldNames = new LinkedList<>();
        for (Field field : DataRow.class.getDeclaredFields()) {
            if ((field.getType() != Boolean.class) && (field.getType() != String.class)) {
                allFieldNames.add(field.getName());
            }
        }
        return allFieldNames.toArray(new String[0]);
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
        if (value == null) {
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
            if (o != null) {
                columnData.add(o);
            }
        }
    }
}
