package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {


    public static String getCurrentDateTime(){
        DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        return customFormat.format(currentDate);
    }

    public static String read_Json_File(String jsonPath) throws IOException {

        //read json file content into a String
        String jsonString = new String(Files.readAllBytes(Paths.get(jsonPath)));
        return jsonString;
    }

}
