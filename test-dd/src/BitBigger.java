import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 27.04.2021 13:39
 * @Description:
 */
public class BitBigger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ss = sc.nextLine();
        int num = Integer.parseInt(sc.nextLine());
        int k = num;
        int [] nums = new int[ss.length()];
        int index = Integer.MAX_VALUE;
        int tenNum = 0;
        for(int i = 0 ; i   <ss.length();i++){
            //System.out.println(ss.charAt(i));
            if(ss.charAt(i) == '1'){
                nums[i] = 1;
                k--;
                if(k == 0){
                    index = i;
                }
                tenNum += (int)Math.pow(2,ss.length() -i -1);
            }else{
                nums[i] = 0;
            }
        }
        System.out.println(tenNum);
        if(index != Integer.MAX_VALUE){
            //System.out.println(index);
            if(index != 0) {
                nums[index - 1] = 1;
            }
            for(int i = index; i < nums.length; i++){
                nums[i] = 0;
            }

        }else{
            int n = nums.length-1;
            if(nums[n] == 0){
                nums[n] = 1;
            }else {
                while (nums[n] == 1) {
                    nums[n] = 0;
                    n--;
                }
                nums[n] = 1;
            }
            k = num;
            for(int i = 0; i < nums.length;i++){
                if(nums[i] == 1){
                    k--;
                }
            }
            System.out.println("k"+k);
            for(int i = nums.length-1; i > 0; i--){
                if(k == 0){
                    break;
                }
                if(nums[i] == 0) {
                    nums[i] = 1;
                    k--;
                }
            }
        }

        StringBuilder new_ss = new StringBuilder();
        if(nums[0] == 0){
            new_ss.append(1);
        }
        for(int m = 0; m < nums.length; m++){
            new_ss.append(nums[m]);
        }
        System.out.println(new_ss.toString());


    }
}
