package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
    Properties pro;

    public ConfigDataProvider(){
        File src = new File("./Config/config.properties");
        try{
            FileInputStream fis = new FileInputStream(src);
            pro=new Properties();
            pro.load(fis);
        }
        catch(Exception e){
            System.out.println("Not able to load Configfile "+e.getMessage());
        }
    }

    public String retrieveAddObject_InputFile(){
        return pro.getProperty("AddObject_json");
    }
}
