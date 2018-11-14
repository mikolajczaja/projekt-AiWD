package aiwd.executor.correlation;

import aiwd.data.DataRowHolder;
import aiwd.util.TypeManager;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.regression.RegressionResults;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.util.List;

public class SimpleLinearRegression {

    private RegressionResults regressionResults;

    public SimpleLinearRegression() {
    }

    public double[] execute(String attribute1, String attribute2) {
        List<Object> objectsOfFirstAttribute = DataRowHolder.getInstance().getColumnData(attribute1);
        List<Object> objectsOfSecondAttribute = DataRowHolder.getInstance().getColumnData(attribute2);
        double[] valuesOfFirstAttribute = TypeManager.objectListToDoubleArray(objectsOfFirstAttribute);
        double[] valuesOfSecondAttribute = TypeManager.objectListToDoubleArray(objectsOfSecondAttribute);
        SimpleRegression simpleRegression = new SimpleRegression();
        double[][] regressionData = mergeToRectangularArray(valuesOfFirstAttribute, valuesOfSecondAttribute);
        simpleRegression.addData(regressionData);
        this.regressionResults = simpleRegression.regress();
        return regressionResults.getParameterEstimates();
    }

    private double[][] mergeToRectangularArray(double[] valuesOfFirstAttribute, double[] valuesOfSecondAttribute) {
        int length = (valuesOfFirstAttribute.length < valuesOfSecondAttribute.length) ?
                valuesOfFirstAttribute.length : valuesOfSecondAttribute.length;
        double[][] regressionData = new double[length][2];
        for(int i = 0; i < length; i++){
            regressionData[i][0] = valuesOfFirstAttribute[i];
            regressionData[i][1] = valuesOfSecondAttribute[i];
        }
        return regressionData;
    }

    public RegressionResults getRegressionResults() {
        return regressionResults;
    }
}
