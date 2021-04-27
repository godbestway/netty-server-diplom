package MemoryAlgo;

import java.util.Scanner;

/**
 * @Author: Chenglin Ding
 * @Date: 10.04.2021 14:28
 * @Description: 计算最少耗时，准备可以一起准备，但是执行只能单个执行
 * 准备时间 执行时间
 * 2个任务
 * 5 1
 * 3 4
 * 1 1
 * 计算结果应该为8
 * 从小到大把准备时间排序，最小的准备加执行小于上一个准备时间，一加一小于3，算3个时间
 * 3加4大于5，则为是7,7再加上1，就是8
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num > 5*10000){
            System.exit(-1);
        }
        int [] ready = new int[num];
        int [] run = new int[num];
        for(int i = 0; i < num;i++){
            ready [i] = sc.nextInt();
            run[i] = sc.nextInt();
        }

        int total = 0;
        for(int i = 0; i < num ; i++){
            int minIndex = findSmallNumber(ready);
            System.out.println("minIndex"+minIndex);
            int minNum = ready[minIndex];
            if(minNum == Integer.MAX_VALUE){
                System.exit(-1);
            }
            System.out.println("minNum"+minNum);
            ready[minIndex] = Integer.MAX_VALUE;
            if(total > minNum){
                //System.out.println(findSmallNumber(ready));
                //System.out.println(run[minIndex]);
                total = total + run[minIndex]  ;
                System.out.println("total" + total);

            }
            else{
                //System.out.println(run[minIndex]);
                total = minNum + run[minIndex];
                System.out.println("total" + total);
            }
        }

        System.out.println(total);


    }
    public static int findSmallNumber(int [] nums){
        int min = nums[0];
        int minIndex = 0;
        for(int i = 1; i < nums.length; i++){
            if(min > nums[i]){
                min = nums[i];
                minIndex = i;
            }
        }
        return minIndex;

    }


}
