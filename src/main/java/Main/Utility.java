package Main;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


class Utility {
    private static String url = "jdbc:sqlite:C:/sqlite3/Test.db";
    private static String badDataFilePath = "C:/OptimalFolderCSV/timestamp.csv";


    private Connection connect() {
        checkingExistingDb();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    } //method for providing connection

    private void checkingExistingDb() {
        File dbFile = new File("C:/sqlite3/Test.db");
        if (!dbFile.exists()) {
            try {
                Connection conn = DriverManager.getConnection(url);
                if (conn != null) {
                    DatabaseMetaData meta = conn.getMetaData();
                    System.out.println("Was created new DB in drive C, folder `sqlite3` and it's name is Test.db");
                    String sqlCreateTable = "CREATE TABLE IF NOT EXISTS X (\n" +
                            "  `A` TEXT NULL,\n" +
                            "  `B` TEXT NULL,\n" +
                            "  `C` TEXT NULL,\n" +
                            "  `D` TEXT NULL,\n" +
                            "  `E` TEXT NULL,\n" +
                            "  `F` TEXT NULL,\n" +
                            "  `G` TEXT NULL,\n" +
                            "  `H` TEXT NULL,\n" +
                            "  `I` TEXT NULL,\n" +
                            "  `J` TEXT NULL);\n";
                    Statement stmt = conn.createStatement();
                    stmt.execute(sqlCreateTable);
                    System.out.println("Was created Table X");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    } //method for checking if db already exists

    void insert(String value, String value1, String value2, String value3, String value4,
                String value5, String value6, String value7, String value8, String value9) {
        String sqlInsert = "INSERT INTO `X`(a,b,c,d,e,f,g,h,i,j) VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = this.connect();
             PreparedStatement pstm = conn.prepareStatement(sqlInsert)) {
            pstm.setString(1, value);
            pstm.setString(2, value1);
            pstm.setString(3, value2);
            pstm.setString(4, value3);
            pstm.setString(5, value4);
            pstm.setString(6, value5);
            pstm.setString(7, value6);
            pstm.setString(8, value7);
            pstm.setString(9, value8);
            pstm.setString(10, value9);

            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    } //method for inserting needed information

    static void getExtraColumnInformation(String[] allValues) throws IOException {

        File fileForBadData = new File(badDataFilePath);
        int extraColumnLength = allValues.length;
        int extraValuesCount = 1;
        List<String> badData = new ArrayList<>();
        while (extraColumnLength > 10) {
            badData.add(allValues[9 + extraValuesCount]);
            extraValuesCount++;
            extraColumnLength = extraColumnLength - 1;
            //region Writing in CSV File
            if (extraColumnLength == 10) {
                String[] badDataToBeWritten = badData.toArray(new String[0]);
                FileWriter outputfile = new FileWriter(fileForBadData, true);
                CSVWriter writer = new CSVWriter(outputfile);
                writer.writeNext(badDataToBeWritten);
                writer.close();
            }
        }
    } //method for getting information, which is located in out of needed range

}
