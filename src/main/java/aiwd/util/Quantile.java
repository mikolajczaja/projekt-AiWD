package aiwd.util;

import java.util.Comparator;
import java.util.List;

public class Quantile {

    double row;

    public Quantile(double row) {
        this.row = row;
    }

    public double evaluate(List<Double> data) {
        data.sort(Double::compareTo);
        double result = 0.0;
        int index = (int) (data.size() * row);
        if ((data.size() % 2) == 0) {
            int nextIndex = index + 1;
            if(index < data.size() - 1)
            result = (data.get(index) + data.get(nextIndex)) / 2;
        } else {
            result = data.get(index);
        }
        return result;
    }
}
