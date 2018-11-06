package aiwd.loader;

import aiwd.model.DataRow;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class DataLoader {

    private static Log LOGGER = LogFactory.getLog(DataLoader.class);

    public LinkedList<DataRow> loadDataFromFile(String fileName) {

        BufferedReader bufferedReader;
        LinkedList<DataRow> entryList = new LinkedList<>();

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));

            String csvDataLine;
            ArrayList<String> allEntries = new ArrayList<>();

            while ((csvDataLine = bufferedReader.readLine()) != null) {
                allEntries.add(csvDataLine);
            }

            for (String singleEntry : allEntries) {
                String[] splittedCsvData = singleEntry.split(";");
                String[] optimizedSplittedCsvData = Arrays.copyOf(splittedCsvData, 78);
                entryList.add(new DataRow(optimizedSplittedCsvData));
            }

        } catch (IOException e) {
            LOGGER.error("error in DataLoader.loadDataFromFile, cause: " + e);
        }
        return entryList;
    }
}