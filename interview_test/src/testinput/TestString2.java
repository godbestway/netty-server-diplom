package testinput;

/**
 * @Author: Chenglin Ding
 * @Date: 01.03.2021 20:53
 * @Description:
 */
public class TestString2 {

    //删除字符串中的所有空格
    public static void main(String[] args) {
        String s="  ab  cdf dfd   dfsf  dsfdsfe   dsfdsfsfg  ";
        s=s.trim();
        //匹配多个空格
        String[] eachs=s.split("\\s+");
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<eachs.length;i++){
            builder.append(eachs[i]);
        }
        s=builder.toString();
        System.out.println(s);

        String str="abc123def456ghi789jkl";
        /*
         * 将当前字符串中的数字部分替换为"#NUMBER"
         * 匹配数字
         * */
        str=str.replaceAll("\\d","#NUMBER");
        System.out.println(str);

        str="abc123def456ghi789jkl";

        /**
         * 将英文部分替换为#CHAR#
         * 匹配所有字母
         * */
        str=str.replaceAll("[a-zA-Z]+","#CHAR#");
        System.out.println(str);

        str=str.replaceAll("\\d+","#NUMBER");
        System.out.println(str);

        str="abc123def456ghi789jkl";
        //按照数字部分拆分字符串
        String[] result=str.split("\\d+");//最大匹配
        System.out.println(result.length);//4
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }



    //这种方法简单
    public void test01(){
              String s="  ab  cdf dfd   dfsf  dsfdsfe   dsfdsfsfg  ";
              s=s.replaceAll("\\s+","");
              System.out.println(s);
    }

}
