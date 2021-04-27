import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 27.04.2021 13:11
 * @Description:
 */
public class ReverseZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int [] nums = new int[num];
        String[] ss = sc.nextLine().split(" ");

        int max = 0;
        int res = 0;
        int sum1 = 0;
        for(int i = 0; i < num; i++){
            nums[i] = Integer.parseInt(ss[i]);
            if(nums[i] == 1){
                sum1++;
            }

        }
        for(int m = 0; m < num; m++){
            res = 0;
            for(int n = m; n < num; n++) {
                //System.out.println(nums[i]);
                if (nums[n] == 1) {
                    res -= 1;
                } else {
                    res += 1;
                }
                max = Math.max(res, max);
            }
        }

        System.out.println(sum1+max);
    }
}
