package basic.method.list;

import basic.method.list.ListNode;

import java.util.Arrays;

/**
 * @Author: Chenglin Ding
 * @Date: 02.03.2021 14:32
 * @Description:
 */
public class SortLists {
    public static void main(String[] args) {
        int [] nums1 = {1,2,3};
        int [] nums2 = {4,5,6};
        ListNode l1 = createList(nums1);
        ListNode l2 = createList(nums2);
        ListNode head = sortLists(l1,l2);
        printList(head);

    }

    public static ListNode sortLists(ListNode l1, ListNode l2){
        int [] nums = new int[100];
        int i = 0;
        while(l1 != null){
            nums[i] = l1.val;
            i++;
            l1 = l1.next;
        }
        while(l2 != null){
            nums[i] = l2.val;
            i++;
            l2 = l2.next;
        }
        int [] new_nums = new int[i];
        for(int m = 0; m< i;m++){
            new_nums[m] = nums[m];
        }
        Arrays.sort(new_nums);
        ListNode head = createList(new_nums);
        return head;
    }

    public static ListNode createList(int [] nums){


        if(nums == null){
            return null;
        }
        ListNode head;
        ListNode current;
        head = new ListNode(nums[0]);
        current = head;
        for(int i =1; i< nums.length; i++){
            current.next = new ListNode(nums[i]);
            current = current.next;
        }

        return head;
    }

    public static void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.val+",");
            current = current.next;
        }


    }
}
