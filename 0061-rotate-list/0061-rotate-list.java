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
    public ListNode rotateRight(ListNode head, int k) {
        int size = 1;

        if(head == null) return null;

        ListNode curr = head;

       

        while(curr.next != null){
            size++;
            curr = curr.next;

        }

        curr.next = head;

        k = k % size;

        int len = size - k;  

        for(int i = 1; i <= len; i++){
            curr = curr.next;
        } 
        ListNode ans = curr.next;
        curr.next = null;


        return ans;

        

        

        
    }
}