package basic.method.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Chenglin Ding
 * @Date: 30.03.2021 21:38
 * @Description:
 */
public class FindRepeated {
    public static void main(String[] args) {
        String str = "adadd";
        HashMap<String, Integer> map = new HashMap<>();
        List<String> dupstr = new ArrayList<>();
        int length = str.length();
        for(int i = length ; i > 0 ;i--){
            for(int s = 0; s<i; s++){
                String sourceStr = str.substring(s,i);
                //System.out.println(sourceStr);
                String replaceAll = str.replaceAll(sourceStr,"");
                int summe = replaceAll.length()+sourceStr.length();
                if(summe == length){
                    continue;
                }
                else{
                    map.put(sourceStr,(length-summe)/sourceStr.length() +1);
                    dupstr.add(sourceStr);
                }
            }
        }
        //System.out.println(str.substring(0,5));
    }
}
