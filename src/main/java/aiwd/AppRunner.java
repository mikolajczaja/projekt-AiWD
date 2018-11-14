package aiwd;

import aiwd.data.DataRowHolder;
import aiwd.data.ExecutionResult;
import aiwd.executor.*;
import aiwd.gui.MainGuiWindow;
import aiwd.loader.DataLoader;
import aiwd.model.DataRow;
import aiwd.model.DescriptiveStatisticOfAttribute;
import aiwd.util.DescriptiveStatisticOfAttributesFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static aiwd.util.DataLoaderConstants.CSV_DATA_FILE_PATH;

public class AppRunner {

    public static void main(String[] args) {
        DataLoader dataLoader = new DataLoader();
        LinkedList<DataRow> dataRows = dataLoader.loadDataFromFile(CSV_DATA_FILE_PATH);
        List<DescriptiveStatisticOfAttribute> descriptiveStatisticOfAttributes
                = DescriptiveStatisticOfAttributesFactory.createDescriptiveStatisticOfAttributes();
        DataRowHolder.getInstance().setDataRowList(dataRows);

        List<ExecutorOfDescriptiveStatistic> executors = new ArrayList<>();
        executors.add(new DetermineMinimumAndMaximumValue());
        executors.add(new DetermineStandardDeviationAndAverageValue());
        executors.add(new DetermineMedianValue());
        executors.add(new DetermineInterquartileRangeValue());
        executors.add(new DetermineSpecificQuantiles());
        executors.add(new DetermineOutliers());
        for (ExecutorOfDescriptiveStatistic executor : executors) {
            executor.provideData(descriptiveStatisticOfAttributes);
            executor.execute();
        }
        ExecutionResult.getInstance().setDescriptiveStatisticOfAttributes(descriptiveStatisticOfAttributes);

        MainGuiWindow mainGuiWindow = new MainGuiWindow();
    }

}
