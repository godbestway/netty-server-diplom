package version2.interfaces.stepControl;

/**
 * @Author: Chenglin Ding
 * @Date: 12.01.2021 21:16
 * @Description:
 */
public class NextStepTask implements Runnable {
    int step;
    ProcessControl processControl;

    public NextStepTask(int step, ProcessControl processControl) {
        this.step = step;
        this.processControl = processControl;
    }

    public void run() {
        this.processControl.executeStep(step);
    }
}
