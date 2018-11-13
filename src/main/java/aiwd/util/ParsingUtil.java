package aiwd.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ParsingUtil {

    public static Boolean parseBooleanIgnoringEmptyString(String string) {
        if (!StringUtils.isEmpty(string)) {
            Integer value = Integer.valueOf(string);
            switch (value){
                case 0 : return Boolean.FALSE;
                case 1 : return Boolean.TRUE;
                default: return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }

    public static Integer parseIntegerIgnoringEmptyString(String string) {
        if (!StringUtils.isEmpty(string)) {
            return Integer.parseInt(string);
        }
        return null;
    }

    public static Double parseDoubleIgnoringEmptyString(String string) {
        if (!StringUtils.isEmpty(string)) {
            string = string.replace(",", ".");
            return Double.parseDouble(string);
        }
        return null;
    }

    public static List<Double> parseDoubleListIgnoringEmptyString(String string) {
        ArrayList<Double> doubleList = new ArrayList<>();
        if (!StringUtils.isEmpty(string)) {
            string = string.replace(",", ".");

            String[] splittedString = string.split("-");
            for (String singleString : splittedString) {
                if (isDouble(singleString)) {
                    doubleList.add(Double.parseDouble(singleString));
                }
            }
        }
        return doubleList;
    }

    private static boolean isDouble(String str) {
        try {
            return !Double.isNaN(Double.parseDouble(str));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<Integer> parseIntegerListIgnoringEmptyString(String string) {
        ArrayList<Integer> integerList = new ArrayList<>();
        if (!StringUtils.isEmpty(string)) {
            string = string.replace(",", ".");

            String[] splittedString = string.split("-");
            for (String singleString : splittedString) {
                integerList.add(Integer.parseInt(singleString));
            }
        }
        return integerList;
    }
}