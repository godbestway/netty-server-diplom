package basic.method.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 21.04.2021 21:31
 * @Description:
 */
public class QickSort2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [] nums = new int[num];
        for(int i = 0; i < num; i++){
            nums[i] = sc.nextInt();
        }

        sort(nums);
        for(int k = 0; k< nums.length; k++){
            System.out.println(nums[k]);
        }
    }

    public static int[] sort(int [] nums){
        int [] arr = Arrays.copyOf(nums,nums.length);

        return quickSort(arr, 0, arr.length -1);

    }

    public static int[] quickSort(int [] nums, int left, int right){
        if(left < right){
            int partitionIndex = partition(nums,left,right);
            quickSort(nums, left, partitionIndex -1);
            quickSort(nums, partitionIndex+1,right);
        }
        return nums;
    }

    private static int partition(int[] arr, int left, int right ){
        int key = left;
        int index = key+1;
        for(int i = index; i < right ; i++){
            if(arr[i] < arr[key]){
                swap(arr,i,index);
                index++;
            }
        }
        swap(arr,key , index -1); //?

        return index-1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}








