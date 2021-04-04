package testinput;

import java.util.Arrays;

/**
 * @Author: Chenglin Ding
 * @Date: 01.03.2021 20:28
 * @Description:
 */
public class TestString {
        public static void main(String[] args){
            String string="this is a test of java";

            //(1) 统计该字符串中字母s出现的次数
            //first
            char[] c=string.toCharArray();
            int count=0;
            for (char d : c) {
                if(d=='s'){
                    count++;
                }
            }
            System.out.println("s出现的次数"+count);
            //second
            String[] strs1=string.split("s");
            int count2=0;
            count2=strs1.length-1;
            System.out.println("s出现的次数"+count2);
            //third

            // (2) 取出子字符串"test"
            // subSequence返回一个新的字符序列，它是此序列的一个子序列。
            // indexOf返回指定字符在此字符串中第一次出现处的索引, lastIndexOf 返回指定字符在此字符串中最后一次出现处的索引。
            System.out.println("截取test："+string.subSequence(string.indexOf("t",1), string.lastIndexOf("t")+1));
            // (3) 将本字符串复制到一个字符数组Char[] str中.
            char[] c2=string.toCharArray();
            // (4) 将字符串中每个单词的第一个字母变成大写， 输出到控制台。
            String[] strs2=string.split(" ");
            for(int i=0;i<=strs2.length-1;i++){
                //方法一：
                //使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。
                //strs2[i]=strs2[i].replaceFirst(String.valueOf(strs2[i].charAt(0)),String.valueOf(strs2[i].charAt(0)).toUpperCase());
                //方法二：String substring(int beginIndex)
                //返回一个新的字符串，它是此字符串的一个子字符串。
                strs2[i]=Character.toUpperCase(strs2[i].charAt(0))+strs2[i].substring(1);
            }
            System.out.println(Arrays.toString(strs2));
            //(5) 用两种方式实现该字符串的倒叙输出。(用StringBuffer和for循环方式分别实现)
            StringBuffer stringBuffer=new StringBuffer("this is a test of java");
            System.out.println(stringBuffer.reverse());
            //for
            for(int i=string.length()-1;i>=0;i--){
                System.out.print(string.charAt(i));
            }
            System.out.println();
            // (6) 将本字符串转换成一个字符串数组，要求每个数组元素都是一个有意义的英文单词,并输出到控制台
            String[] strs3=string.split(" ");
            System.out.println(Arrays.toString(strs3));

            //String trim 去除一个字符串两边的空白字符(如空格,tab)

            //使用这两个方法判断是否是图片
             String str="zhangc.jpg";
            boolean starts=str.startsWith("zh");
            boolean end=str.endsWith(".jpg");
            System.out.println(starts);
            System.out.println(end);

            str="Hellow World";
            str=str.toUpperCase();
            System.out.println(str);
            str=str.toLowerCase();
            System.out.println(str);

            int a=123;
            //valueOf()性能好一点
            str=String.valueOf(a);
            System.out.println(str);
            double d=123.123;
            String str2=String.valueOf(d);
            //方法2，也可以将一个基本数据类型的数据转成String类型的变量
            String str3=1234f+"";
            System.out.println(str3);


        }


}
