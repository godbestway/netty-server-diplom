package basic.method.sort;

import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 14.03.2021 09:36
 * @Description:
 */
public class InsertSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [] nums = new int[num];
        for(int i = 0; i< num; i++){
            nums[i] = sc.nextInt();
        }
        insertSort(nums);
        for(int k = 0; k <num;k++){
            System.out.println(nums[k]);
        }

    }

    public static void insertSort(int [] nums){
        for(int i = 0; i < nums.length -1; i++){
            for(int j = i+1; j > 0 ;j--){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }else{
                    break;
                }

            }
        }
    }
}
