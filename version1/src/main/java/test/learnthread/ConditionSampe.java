package test.learnthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Chenglin Ding
 * @Date: 15.01.2021 13:24
 * @Description:
 */
public class ConditionSampe {
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        final Condition c1 = lock.newCondition();
        final Condition c2 = lock.newCondition();
        final Condition c3 = lock.newCondition();

        new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    c1.await();
                    System.out.println("当午");
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    c2.await();
                    System.out.println("日");
                    c1.signal();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                lock.lock();
                try {
                    c3.await();
                    System.out.println("禾");
                    //c2.signal();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                lock.lock();;
                try {
                    Thread.sleep(1000);
                    System.out.println("锄");
                    c3.signal();
                }
                catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
