package test.traceload;

import java.io.*;
import java.util.Properties;

/**
 * @Author: Chenglin Ding
 * @Date: 01.02.2021 20:21
 * @Description:
 */
public class ReadConfig {

    public static String getProperties_3(String filePath, String keyWord){
        Properties prop = new Properties();
        String value = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            prop.load(fileInputStream);
            value = prop.getProperty(keyWord);
        }catch (IOException e){
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {
        Properties prop = new Properties();
        String stateport = null;
        String eventport = null;
        String TraceReplaySwitchPort = null;
        String TraceReplayHost = null;
        String TraceReplayFile = null;
        String TraceReplayRate = null;
        String TraceReplayNumPkts =null;
        String OperationDelay = null;
        String StopDelay = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("D:/java/realwork/versionbetterproto/src/main/java/test/config/config.properties");
            prop.load(fileInputStream);
            stateport = prop.getProperty("stateport");
            System.out.println("stateport" + stateport);
            eventport = prop.getProperty("eventport");
            System.out.println("eventport" + eventport);
            TraceReplaySwitchPort = prop.getProperty("TraceReplaySwitchPort");
            System.out.println("TraceReplaySwitchPort" + TraceReplaySwitchPort);
            TraceReplayHost = prop.getProperty("TraceReplayHost");
            System.out.println("TraceReplayHost" + TraceReplayHost);
            TraceReplayFile = prop.getProperty("TraceReplayFile");
            System.out.println("TraceReplayFile" + TraceReplayFile);
            TraceReplayRate = prop.getProperty("TraceReplayRate");
            System.out.println("TraceReplayRate" + TraceReplayRate);
            TraceReplayNumPkts  = prop.getProperty("TraceReplayNumPkts");
            System.out.println("TraceReplayNumPkts " + TraceReplayNumPkts );
            OperationDelay= prop.getProperty("OperationDelay");
            System.out.println("OperationDelay " + OperationDelay);
            StopDelay= prop.getProperty("StopDelay");
            System.out.println("StopDelay " + StopDelay);
        }catch (IOException e){
            e.printStackTrace();
        }
        //String properties_3 = getProperties_3("D:/java/realwork/versionbetterproto/src/main/java/test/config/config.properties", "last_open_file");
        //System.out.println("last_open_file = " + properties_3);
    }

}
