package basic.method.sort;

import java.security.Key;
import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 21.04.2021 22:03
 * @Description:
 */
public class QuickSortTest {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int [] nums = {1,4,2,5,3};
            sort(nums,0, nums.length -1 );
            for(int num:nums){
                System.out.println(num);
            }

        }

        public static void sort(int []nums, int first,int last){
            if(first > last){
                return;
            }

            int i = first;
            int j = last;
            //这里只能用key，不能用别的，不能存储index赋值，因为后来nums已经变化了
            int key = nums[i];

            while(i < j){
                while(i<j && key < nums[j])
                    j--;
                if(i<j){
                    nums[i] = nums[j];
                    i++;
                }
                while(i<j && key > nums[i] )
                    i++;
                if(i < j){
                    nums[j] = nums[i];
                    j--;
                }

                nums[i] = key;
                sort(nums,first, i-1);
                sort(nums, i+1, last);

            }

        }
}












