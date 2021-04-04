package basic.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Chenglin Ding
 * @Date: 30.03.2021 21:22
 * @Description:
 */
public class Poker {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i< 52 ; i++){
            l.add(i);
        }
        Collections.shuffle(l);
        String [] flowers = {"hong","fang","hua","hei"};
        String [] numbers = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        for(Integer num: l){
            System.out.println(flowers[l.get(num)%4]+numbers[l.get(num)%13]+" ");
        }
    }
}
