import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: Chenglin Ding
 * @Date: 18.04.2021 04:57
 * @Description:
 * 9
 * query
 * append 1 10
 * query
 * append 2 20
 * query
 * append 3 15
 * query
 * append 1 10
 * query
 * null
 * 1
 * 2 1
 * 2 3 1
 * 1 2 3
 */
public class QueryAppend {

    private static TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return -1;
                }else if(o1 < o2){
                    return 1;
                }else{
                    return 0;
                }
            }
        });



    public static void query(){
        if(map.size() == 0){
            System.out.println("null");
            return;
        }
        if(map.size() > 10){
            int num = 0;
            for (Object a : map.keySet()) {
                System.out.print(map.get(a)+" ");
                num++;
                if(num == 10)
                    break;
            }
            System.out.println();
        }
        else {
            for (Object a : map.keySet()) {
                System.out.println(a);
                System.out.print(map.get(a)+" ");
            }
            System.out.println();
        }
    }

    public static void append(int key, int value){
        if(map.get(key) != null){
            key += key;
            //System.out.println("key ");
            map.put(key, value);
        }
        map.put(key,value);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());

            for (int i = 0; i < num; i++) {
                //while(sc.hasNextLine()) {
                    String s = sc.nextLine();
                    System.out.println("s :" + s);
                    String[] ss = s.split(" ");
                    if (ss.length == 1) {
                        //System.out.println("query");
                        query();
                    } else if (ss.length == 3) {
                        //System.out.println("append");
                        //System.out.println("ss[2]" + ss[2]);
                        //System.out.println("ss[1]" + ss[1]);
                        append(Integer.parseInt(ss[2]), Integer.parseInt(ss[1]));
                    } else {
                        return;
                    }
                //}
            }


    }
}
