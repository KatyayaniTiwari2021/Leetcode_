/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode curr1 = null;

        ListNode curr2 = list1;
        
        for(int i = 0; i < a-1; i++){
            curr2 = curr2.next;
        }

        curr1 = curr2;

        for(int i = a - 1; i < b; i++){
            curr2 = curr2.next;
        }

        curr1.next = list2;
  

        while(curr1.next != null){
            curr1 = curr1.next;
        }

        curr1.next = curr2.next;


        return list1;

       


        
    }
}