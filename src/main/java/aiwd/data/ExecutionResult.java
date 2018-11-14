package aiwd.data;

import aiwd.model.DescriptiveStatisticOfAttribute;

import java.util.LinkedList;
import java.util.List;

public class ExecutionResult {

    private static ExecutionResult instance;
    List<DescriptiveStatisticOfAttribute> descriptiveStatisticOfAttributes;

    private ExecutionResult() {
    }

    public static ExecutionResult getInstance() {
        if (instance == null) {
            instance = new ExecutionResult();
        }
        return instance;
    }

    public List<DescriptiveStatisticOfAttribute> getDescriptiveStatisticOfAttributes() {
        return descriptiveStatisticOfAttributes;
    }

    public void setDescriptiveStatisticOfAttributes(List<DescriptiveStatisticOfAttribute> descriptiveStatisticOfAttributes) {
        this.descriptiveStatisticOfAttributes = descriptiveStatisticOfAttributes;
    }

    public void addDescriptiveStatisticOfAttributes(DescriptiveStatisticOfAttribute singledescriptiveStatisticOfAttribute) {
        if (descriptiveStatisticOfAttributes == null) {
            descriptiveStatisticOfAttributes = new LinkedList<>();
        }
        descriptiveStatisticOfAttributes.add(singledescriptiveStatisticOfAttribute);
    }


}
