/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
       //Optimized - Tc is O(1)
        node.val = node.next.val;
        node.next = node.next.next;

        // ListNode current = node;
        // ListNode nextNode = node.next;
        
        // while(nextNode.next!=null){
        //    current.val = nextNode.val;
        //    current = nextNode;
        //    nextNode = nextNode.next;
        // }

        // current.val = nextNode.val ;
        // current.next = null;        
    }
}