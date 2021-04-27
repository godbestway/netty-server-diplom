package basic.method.string;

import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 16.04.2021 23:23
 * @Description:
 */
public class ReplaceSecondString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        for(int i = 0; i < s1.length(); i++){
            System.out.println("String value"+String.valueOf(s1.charAt(i)));
            if(!s2.contains(String.valueOf(s1.charAt(i)))){
                System.out.print(s1.charAt(i));
            }
        }
    }
}
