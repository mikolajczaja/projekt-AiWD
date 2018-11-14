package aiwd.executor.correlation;

import aiwd.data.DataRowHolder;
import aiwd.util.TypeManager;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

import java.util.List;

public class DeterminePearsonsCorrelation {

    public DeterminePearsonsCorrelation() {
    }

    public Double execute(String attribute1, String attribute2) {
        List<Object> objectsOfFirstAttribute = DataRowHolder.getInstance().getColumnData(attribute1);
        List<Object> objectsOfSecondAttribute = DataRowHolder.getInstance().getColumnData(attribute2);
        PearsonsCorrelation pearsonsCorrelation = new PearsonsCorrelation();

        double[] valuesOfFirstAttribute = TypeManager.objectListToDoubleArray(objectsOfFirstAttribute);
        double[] valuesOfSecondAttribute = TypeManager.objectListToDoubleArray(objectsOfSecondAttribute);

        int length = (valuesOfFirstAttribute.length < valuesOfSecondAttribute.length) ?
                valuesOfFirstAttribute.length : valuesOfSecondAttribute.length;

        double[] unifiedArrayOfFirstAttribute = new double[length];
        double[] unifiedArrayOfSecondAttribute = new double[length];

        for (int i = 0; i < length; i++) {
            unifiedArrayOfFirstAttribute[i] = valuesOfFirstAttribute[i];
            unifiedArrayOfSecondAttribute[i] = valuesOfSecondAttribute[i];
        }

        return pearsonsCorrelation.correlation(unifiedArrayOfFirstAttribute, unifiedArrayOfSecondAttribute);
    }

}
