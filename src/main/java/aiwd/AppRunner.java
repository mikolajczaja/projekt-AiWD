package aiwd;

import aiwd.loader.DataLoader;

import static aiwd.util.DataLoaderConstants.CSV_DATA_FILE_PATH;

public class AppRunner {
    public static void main(String[] args) {
        DataLoader dataLoader=new DataLoader();
        dataLoader.loadDataFromFile(CSV_DATA_FILE_PATH);
    }
}
