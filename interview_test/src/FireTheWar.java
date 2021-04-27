import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 18.04.2021 04:27
 * @Description:
 * 3 4 3
 * 3 1
 * 3 4
 * 6 2
 * 2 4
 * 3 1
 * 1 5
 * 4 2
 * output:
 * 12 13
 * B
 * 1 <= n, m <= 1000, 1 <= k <= 1000, 1 <= x, y <= 1e9
 */
public class FireTheWar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] ss = sc.nextLine().split(" ");
        for(int i = 0; i< ss.length; i++){
            if(Integer.parseInt(ss[i]) > 1000 || Integer.parseInt(ss[i]) < 1){
                return;
            }
        }

        HashMap<Integer,Integer> mapa = new HashMap<>();
        HashMap<Integer,Integer> mapb = new HashMap<>();
        for(int i = 0; i < Integer.parseInt(ss[0]); i++){
            String [] as = sc.nextLine().split(" ");
            if(Integer.parseInt(as[1]) >= Integer.parseInt(ss[2])){
                mapa.put(Integer.parseInt(as[1]),Integer.parseInt(as[0]));
            }
        }
        int suma = 0;
        for(Integer key: mapa.keySet()){
            suma += key*mapa.get(key);
        }
        for(int i = 0; i < Integer.parseInt(ss[1]);i++){
            String [] bs = sc.nextLine().split(" ");
            if(Integer.parseInt(bs[1]) >= Integer.parseInt(ss[2])) {
                mapb.put(Integer.parseInt(bs[1]), Integer.parseInt(bs[0]));
            }
        }
        int sumb = 0;
        for(Integer key: mapb.keySet()){
            sumb += key*mapb.get(key);
        }
        System.out.println(suma + " "+sumb);
        if(suma > sumb){
            System.out.println("A");
        }else{
            System.out.println("B");
        }
    }
}
