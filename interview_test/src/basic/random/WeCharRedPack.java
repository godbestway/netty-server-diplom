package basic.random;

import javax.xml.transform.Source;

/**
 * @Author: Chenglin Ding
 * @Date: 30.03.2021 12:39
 * @Description:
 */
public class WeCharRedPack {
    public static void main(String[] args) {

        double [] moneys = moneyNumber(50,5);
        for(double money: moneys){
            System.out.println(money);
        }
    }

    public static double [] moneyNumber(double value, int  num){
        double [] nums = new double[num];
        int persons = num;
        for(int i = 0; i < num -1 ; i++){
            double max = value/persons * 2;
            System.out.println("max"+max);
            double money = Math.random()*(max);
            nums[i] = money;
            value = value-money;
            System.out.println("value"+value);
            persons--;
        }
        nums[num-1] = value;


        return nums;
    }
}
