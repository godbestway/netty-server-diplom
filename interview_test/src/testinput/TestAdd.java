package testinput;

import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 01.03.2021 19:09
 * @Description:
 */
public class TestAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int arrayNum = sc.nextInt();
        while(sc.hasNextInt()){
            //for(int m = 0; m < arrayNum; m++){
                int num = sc.nextInt();
                //if(num == 0){
                //    System.exit(0);
                //}
                int sum = 0;
                for(int i = 0; i< num;i++){
                    int nextNum = sc.nextInt();
                    sum = sum+ nextNum;
                    //System.out.println(sum);
                }
                System.out.println(sum);
            //}

        }

    }
}
