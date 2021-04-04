package testinput;

import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 01.03.2021 19:48
 * @Description:
 */
public class TestALine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String [] str = sc.nextLine().split(" ");
            int sum =0;
            for(int i = 0; i< str.length;i++){
                sum += Integer.parseInt(str[i]);
            }
            System.out.println(sum);
        }
    }
}
