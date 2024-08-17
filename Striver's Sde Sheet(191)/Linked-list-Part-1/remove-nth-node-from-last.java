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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Optimal Approach
        // Tc is O(N), Sc is O(1)
        if(head.next==null && n==1){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // int count = 0;
        for(int count = 0 ; count < n ; count++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head; 

      /*  Brute Force
          Worst case Tc is O(2 * L) , L - Length of the Linked List
          Sc is O(1)
      
      int sz=0;

        ListNode temp=head;
        while(temp!=null){
            sz++;
            temp=temp.next;
        }

        // System.out.println(sz);
        if(sz==n){
            return head.next;
        }

        temp=head;
        int index=0;

        while(index<(sz-n-1) && temp!=null){
            temp=temp.next;
            index++;
        }
        
        temp.next=temp.next.next;
        
        


        return head;
        
        */
    }
}