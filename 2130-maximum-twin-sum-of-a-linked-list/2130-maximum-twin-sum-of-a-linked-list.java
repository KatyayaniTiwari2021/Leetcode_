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
    public int pairSum(ListNode head) {
        if(head == null || head.next == null){
            return head.val;
        }
        ListNode mid = middleNode(head);
        ListNode headF = head;
        ListNode headS = reverseList(mid);
        int max = 0;
        while(headF != null && headS !=null){
            
            int sum = headF.val + headS.val ;
            if(sum>max){
                max = sum;
            }
            headF = headF.next;
            headS = headS.next;
        }
        return max;
        
    }
    public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while(fast !=null && fast.next!=null){
                slow=slow.next;
                fast= fast.next.next;
            }
            return slow;
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null){
            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr=Next;

        } return prev;
        
    }
}