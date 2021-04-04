package basic.method.string;

import javax.xml.transform.Source;
import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 01.03.2021 10:36
 * @Description:
 */
public class ReverseWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int n = sc.nextInt();
        String ss = sc.nextLine();

        //System.out.println(ss);

        int [] indexs = new int[ss.length()];
        int n = 0;
        for(int i = 0; i< ss.length();i++){
            if(ss.charAt(i) == 'a' || ss.charAt(i) == 'A' || ss.charAt(i) == 'e' || ss.charAt(i) == 'E' || ss.charAt(i) == 'i' ||
                    ss.charAt(i) == 'I' || ss.charAt(i) == 'o' || ss.charAt(i) == 'O' || ss.charAt(i) == 'u' || ss.charAt(i) == 'U'){
                indexs[n] = i+1;
                n++;
            }
        }

        //for(int m = 0; m < ss.length();m++){
        //    System.out.println(indexs[m]);
        //}
        int num = 0;
        int [] new_index = new int[num];
        for(int m = 0; m < ss.length(); m++){
            if(indexs[m] != 0){
                num ++;
            }
        }
        System.out.println("num"+num);
        if(num <= 1){
            System.out.println(ss);
        }else {
            StringBuilder ss_build = new StringBuilder(ss);

                for (int j = 0; j < num / 2; j++) {
                    //System.out.println(indexs[j]);
                    char tmp = ss.charAt(indexs[j]-1);
                    System.out.println(tmp);
                    System.out.println(indexs[num-j-1]);
                    System.out.println(ss.charAt(indexs[num-j-1]-1));
                    ss_build.setCharAt(indexs[j]-1,ss.charAt(indexs[num-j-1]-1));
                    ss_build.setCharAt(indexs[num-j-1]-1, tmp);
                }

            ss = ss_build.toString();
            System.out.println(ss);
        }

    }
}
