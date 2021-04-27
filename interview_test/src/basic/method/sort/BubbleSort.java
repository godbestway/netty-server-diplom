package basic.method.sort;

/**
 * @Author: Chenglin Ding
 * @Date: 22.04.2021 10:24
 * @Description:
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] nums = {1,4,2,5,3};
        sort(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }

    public static void sort(int [] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 1; j < nums.length ;j++){
                if(nums[j] < nums[j-1] ){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;

                }
            }
        }
    }
}
