package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
    public Properties prop;
    public ReadConfig()
    {
        try
        {
            FileInputStream fis = new FileInputStream("/Users/rahulbhagwat/Downloads/RoverWebAutomation/src/main/resources/data.properties");
            prop=new Properties();
            prop.load(fis);

        }catch(Exception e)
        {
            System.out.println("Exception is"+ e.getMessage());
        }
    }
    public String getAppURL()
    {
        String AppURL=prop.getProperty("url");
        return AppURL;
    }
    public String getBrowser()
    {
        String browsername=prop.getProperty("browser");
        return browsername;
    }

}
