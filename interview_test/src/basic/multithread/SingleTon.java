package basic.multithread;

/**
 * @Author: Chenglin Ding
 * @Date: 13.03.2021 23:20
 * @Description:
 */
public class SingleTon {
    private static volatile SingleTon singleTon = null;

    private SingleTon(){}

    public static SingleTon getSingleTon(){
        if(singleTon == null){
            synchronized (SingleTon.class){
                if(singleTon == null){
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}
