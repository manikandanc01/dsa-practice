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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1=l1;
        ListNode ptr2=l2;

        ListNode result = new ListNode(-1);
        ListNode tail = result;
        int carry = 0; 

        //One Traversal Solution

        while(ptr1 != null || ptr2!=null || carry == 1){
            int sum = 0;

            if(ptr1 != null){
                sum += ptr1.val;
                ptr1 = ptr1.next;
            }

            if(ptr2 != null){
                sum += ptr2.val;
                ptr2 = ptr2.next;
            }

            sum += carry;
            carry = sum/10;

            tail.next = new ListNode(sum%10);
            tail = tail.next;

        }

        return result.next;

       /* while(ptr1 != null && ptr2 != null){
            int sum = (ptr1.val + ptr2.val + carry)%10;
            carry = (ptr1.val + ptr2.val + carry)/10; 

            tail.next = new ListNode(sum);
            tail = tail.next;

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while(ptr1 != null){
           int sum = (ptr1.val + carry)%10;
           carry = (ptr1.val + carry)/10;

           tail.next = new ListNode(sum);
           tail = tail.next;

           ptr1 = ptr1.next;
        }

        while(ptr2!=null){
            int sum = (ptr2.val + carry)%10;
            carry = (ptr2.val + carry)/10;

            tail.next = new ListNode(sum);
            tail = tail.next;

            ptr2 = ptr2.next;
        }

        if(carry != 0){
            tail.next = new ListNode(carry);
            tail = tail.next;
        }

        return result.next;*/
    }
}