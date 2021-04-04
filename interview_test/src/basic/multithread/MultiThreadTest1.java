package basic.multithread;

/**
 * @Author: Chenglin Ding
 * @Date: 13.03.2021 23:42
 * @Description:
 */
public class MultiThreadTest1 {
    public static volatile int number = 0;

    public static void main(String[] args) {
        TestThread testThread1 = new TestThread();
        for(int i =0; i< 10; i++){
            new Thread(testThread1).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(number);

    }



}
