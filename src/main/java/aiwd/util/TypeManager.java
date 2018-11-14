package aiwd.util;

import aiwd.exception.WrongTypeException;

import java.util.ArrayList;
import java.util.List;

public class TypeManager {

    public static double[] doubleListToDoubleArray(List<Double> doubleList) {
        double[] doubleArray = new double[doubleList.size()];
        for (int i = 0; i < doubleList.size(); i++) {
            doubleArray[i] = doubleList.get(i);
        }
        return doubleArray;
    }

    public static List<Double> objectListToDoubleList(List<Object> numbers) {
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

    public static double[] objectListToDoubleArray(List<Object> numbers) {
        double[] doubleArray = new double[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            try {
                doubleArray[i] = tryParseToDouble(numbers.get(i));
            } catch (WrongTypeException e) {
                e.printStackTrace();
            }
        }
        return doubleArray;
    }

    public static Double tryParseToDouble(Object o) throws WrongTypeException {
        if (o instanceof Integer) {
            return ((Integer) o).doubleValue();
        }
        if (o instanceof Double) {
            return (Double) o;
        }
        throw new WrongTypeException();
    }
}
