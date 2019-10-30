package Main;

import java.io.*;

public class Application {
    private static String filePathForInitialFile = "C:/OptimalFolderCSV/Interview-task.csv";
    private static int recordsReceived = 0;
    private static int recordsProceeded = 0;
    private static int recordsFailed = 0;

    public static void main(String[] args) throws Exception {
        Utility utility = new Utility();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePathForInitialFile));
            String line;
            while ((line = reader.readLine()) != null) {
                recordsReceived++;
                String[] values = line.split(",(?!iVB)");
                Utility.getExtraColumnInformation(values);
                utility.insert(values[0], values[1], values[2], values[3], values[4], values[5], values[6], values[7], values[8], values[9]);
            }
            System.out.println("Your CSV File was proceeded successfully! Congratulations!");
            System.out.println("Records received = " + recordsReceived);
        } catch (IOException ex) {
            throw new Exception("File was not found in specified folder or it's name is not 'interview-task'", ex);
        }
    }
}
