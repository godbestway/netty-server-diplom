package test.traceload;

import zconnacmove.MoveProcessControl;

/**
 * @Author: Chenglin Ding
 * @Date: 01.02.2021 22:26
 * @Description:
 */
public class TestTraceLoad {
    public static void main(String[] args) {
        MoveProcessControl moveProcessControl = new MoveProcessControl();
        moveProcessControl.executeStep(0);
    }
}
