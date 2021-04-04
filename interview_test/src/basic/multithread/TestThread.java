package basic.multithread;

/**
 * @Author: Chenglin Ding
 * @Date: 13.03.2021 23:48
 * @Description:
 */
public class TestThread implements Runnable {
    @Override
    public void run() {

            if(MultiThreadTest1.number != 10){
                MultiThreadTest1.number++;
            }

    }
}
