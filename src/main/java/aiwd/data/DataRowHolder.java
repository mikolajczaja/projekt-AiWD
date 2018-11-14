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

    public Map<String, List<Object>> getAllColumnDataSortedByColumnNames(){
        Map<String, List<Object>> allColumnDataSortedByColumnNames=new HashMap<>();

        for(Field field:DataRow.class.getDeclaredFields()){
            for(DataRow dataRow: getDataRowList()) {
                List<Object> columnDataForSingleKey = allColumnDataSortedByColumnNames.get(field.getName());
                if(columnDataForSingleKey==null){
                    columnDataForSingleKey=new LinkedList<>();
                }
                Object valueByFieldName = getValueByFieldName(field.getName(), dataRow);
                if(valueByFieldName instanceof List){
                    columnDataForSingleKey.addAll((List)valueByFieldName);
                } else {
                    columnDataForSingleKey.add(valueByFieldName);
                }

                allColumnDataSortedByColumnNames.put(field.getName(),columnDataForSingleKey);
            }
        }
        return allColumnDataSortedByColumnNames;
    }

    public String[] getAllFieldNames(){
        List<String> allFieldNames=new LinkedList<>();
        for(Field field:DataRow.class.getDeclaredFields()){
            allFieldNames.add(field.getName());
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
