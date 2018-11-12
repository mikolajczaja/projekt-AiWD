package aiwd;

import aiwd.executor.*;
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
        List<ExecutorOfDescriptiveStatistic> executors = new ArrayList<>();
        executors.add(new DetermineMinimumAndMaximumValue());
        executors.add(new DetermineStandardDeviationAndAverageValue());
        executors.add(new DetermineMedianVale());
        executors.add(new DetermineInterquartileRangeVale());
        for(ExecutorOfDescriptiveStatistic e: executors){
            e.provideData(descriptiveStatisticOfAttributes,dataRows);
            e.execute();
        }
    }

}
