package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Chenglin Ding
 * @Date: 02.02.2021 16:19
 * @Description:
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder= new StringBuilder();
        List<Integer> srcList = new ArrayList<Integer>();
        srcList.add(12);
        srcList.add(24);
        srcList.add(56);
        for(int i = 0; i< srcList.size();i++){
            //System.out.println(srcList.get(i));
            stringBuilder.append(srcList.get(i));
        }
        System.out.println(stringBuilder);
    }
}
