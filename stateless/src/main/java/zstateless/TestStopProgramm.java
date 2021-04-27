package zstateless;

import commands.StopProgramm;

public class TestStopProgramm {
    public static void main(String[] args) {
        String ip = "192.168.0.2";
        StopProgramm stopProgramm = new StopProgramm(ip);
        stopProgramm.stopTrace();
    }
}
