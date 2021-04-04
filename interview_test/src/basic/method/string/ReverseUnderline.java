package basic.method.string;


import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 31.03.2021 14:53
 * @Description:
 */
public class ReverseUnderline {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();
        StringBuilder strBuild = new StringBuilder(str);
        str = strBuild.reverse().toString();
        System.out.println(str);
        if(n >= str.length()){
            System.out.println(str+"-");
        }else{
            System.out.println(str.substring(0,n)+"-"+str.substring(n,str.length()));
        }
    }
}
