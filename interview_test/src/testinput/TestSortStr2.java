package testinput;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 01.03.2021 20:23
 * @Description:
 */
public class TestSortStr2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split(",");
            Arrays.sort(str);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length - 1; i++) {
                sb.append(str[i]).append(",");
            }
            System.out.println(str[str.length - 1]);
            sb.append(str[str.length - 1]);
            System.out.println(sb.toString().trim());
        }
    }
}
