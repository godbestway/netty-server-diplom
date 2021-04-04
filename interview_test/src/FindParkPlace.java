import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 01.03.2021 11:43
 * @Description:
 */
public class FindParkPlace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [] nums = new int[num];
        for(int i = 0; i < nums.length;i++){
            nums[i] = sc.nextInt();
        }

        int parkNum = sc.nextInt();
        int findNum = 0;
        int freeNum = 0;

        int [] freeNums = new int[num];
        for(int m = 0; m < nums.length;m++){
            if(nums[m] == 0){
                freeNums[freeNum] = m;
                freeNum++;

            }
        }


        if(freeNum < parkNum){
            System.out.println("false");
        }
        else {
            for(int m = 0; m < nums.length;m++){
                if(m == 0){
                    if(nums[0] == 0 && nums[1] == 0){
                        findNum++;
                        nums[0] = 1;
                    }
                }else if(m == nums.length-1){
                    if(nums[nums.length-1] == 0 && nums[nums.length-2] == 0){
                        findNum++;
                        nums[nums.length-1] = 0;
                    }
                }else{
                    if(nums[m-1] == 0 && nums[m] == 0 && nums[m+1] == 0){
                        findNum++;
                        nums[m] =0;
                    }
                }
            }
            if(findNum < parkNum){
                System.out.println("false");
            }else{
                System.out.println("true");
            }
        }
    }
}
