package basic.method.string;

import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 16.04.2021 23:15
 * @Description:
 */
public class ReverseStringWithoutPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        String [] strings = s.split(" ");
        StringBuilder sb  = new StringBuilder();
        for(int i = strings.length -1 ; i >= 0; i--){
            sb.append(strings[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
