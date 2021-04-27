package basic.method.string;


import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 16.04.2021 22:31
 * @Description:
 * abcdabcab
 * output: abcd
 *
 */
public class FindRepeaterSon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char [] chars = s.toCharArray();
        if(chars.length == 0){
            System.out.println(0);
            return;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int j = 0;
        for(int i = 0; i < chars.length; i++){
            if(map.containsKey(chars[i])){
                j = Math.max(j,map.get(chars[i]));
            }
            ans = Math.max(i-j+1,ans);
            map.put(chars[i],i+1);
        }

        System.out.println(ans);




    }
}
