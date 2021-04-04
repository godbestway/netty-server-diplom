package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestCurl {
    private static List<String> command;



    public static void main(String[] args){
        String[] cmd={"curl","-X", "POST","-d", "{\"switch\":\"00:00:00:00:00:00:00:01\",\"name\":\"flow-mod-1\"," +
                "\"in_port\":\"1\",\"active\":\"true\", \"actions\":\"output=2\"}","http://127.0.0.1:8080/wm/staticflowpusher/json"};

        System.out.println(execCurl(cmd));
        TestCurl testCurl = new TestCurl();
        testCurl.showProcessBuilder(cmd);

    }

    public void showProcessBuilder(String... command) {
        this.command = new ArrayList<>(command.length);
        for (String arg : command) {
            this.command.add(arg);
            System.out.print(arg);
        }
    }


    public static String execCurl(String[] cmds) {
        ProcessBuilder process = new ProcessBuilder(cmds);
        Process p;
        try {
            p = process.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(System.getProperty("line.separator"));
            }
            return builder.toString();

        } catch (IOException e) {
            System.out.print("error");
            e.printStackTrace();
        }
        return null;

    }

}
