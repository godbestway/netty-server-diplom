package basic.method.sort;

import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 13.03.2021 18:23
 * @Description: https://www.runoob.com/w3cnote/sort-algorithm-summary.html
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [] nums = new int[num];
        for(int i = 0; i < num; i++){
            nums[i] = sc.nextInt();
        }

        sort(nums,0, num -1);
        for(int k = 0; k< nums.length; k++){
            System.out.println(nums[k]);
        }
    }

    //精华在于选择一个key后，i从小往大数，比key大的放后面，j从大往小数，比key小的放前面
    public  static  void sort(int [] nums, int first, int last){
        if(first > last){
            return;
        }

        int i = first;
        int j = last;
        int key = nums[i];
        while(i < j){
            //如果i >= j 说明没找到，也停止遍历
            while(i <j && nums[j] > key )
                j--;
            //如果找到了，此时i是小于j的，如果没找到i是大于j的，就不用换了
            //这个if主要是判断前面有没有找到相关的点
            if(i<j){
                nums[i] = nums[j];
                i++;
            }

            while(i<j && nums[i]<key)//从左向右找第一个大于key的值
                i++;

            if(i<j){
                nums[j] = nums[i];
                j--;
            }

        }
        //i 此时等于 j
        nums[i] = key;
        sort(nums, first, i-1);//递归调用
        sort(nums, i+1, last);//递归调用
    }
}
