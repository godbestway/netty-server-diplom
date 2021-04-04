package basic.method.sort;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 13.03.2021 16:47
 * @Description:
 */
public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [] nums = new int[num];
        for(int i = 0; i < num; i++){
            nums[i] = sc.nextInt();
        }

        sort(nums, 0, nums.length-1);
        for(int k = 0; k< nums.length; k++){
            System.out.println(nums[k]);
        }

    }

    public static void sort(int [] nums, int first, int last){
        if(first >= last)
            return;
        int middle = (first + last)/2;
        sort(nums, first, middle);
        sort(nums, middle+1, last);
        mergeArray(nums, first, last, middle);

    }

    //精华在于这个合并算法，两个数组，逐个比较放进原来的数组
    //更长或者更大数多的那个数组剩下的数，再放进去
    public static void mergeArray(int [] nums, int first, int last, int middle){
        int [] temp = Arrays.copyOf(nums,nums.length);
        int p = first;
        int i = first;
        int m = middle;
        int n = middle+1;
        int k = last;
        while(i <= m && n <= k){
            if(temp[i] < temp[n]){
                nums[p++] =  temp[i++];
            }else{
                nums[p++] = temp[n++];
            }
        }

        while(i <= m){
            nums[p++] = temp[i++];
        }

        while(n <= k){
            nums[p++] = temp[n++];
        }

    }

}
