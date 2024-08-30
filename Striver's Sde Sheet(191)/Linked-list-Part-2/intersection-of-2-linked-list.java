/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        
        int len1 = 0;

        while(ptr1 != null){
            len1++;
            ptr1 = ptr1.next;
        }

        int len2 = 0;

        while(ptr2 != null){
            len2++;
            ptr2 = ptr2.next;
        }

        int diff = Math.abs(len1 - len2);
        
        ptr1 = headA;
        ptr2 = headB;

        if(len1 > len2){
            for(int i = 0; i < diff; i++){
                ptr1 = ptr1.next;
            }
        }else {
            for(int i = 0; i < diff; i++){
                ptr2 = ptr2.next;
            }
        }

        while(ptr1 != null && ptr2 != null){
            if(ptr1 == ptr2){
                return ptr1;
            }

            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return null;

        /*
          Tc is O(m) + O(n) + O(diff) + O(max(m,n)-1))
          Sc is O(1)
        */

        /*
          1. Brute Force, For every node in A, check if that node is present in
          B also, If present break and return the intersection node. 
          Else return null.

          Tc is O(m*n), Sc is O(1)

          2. Better, using hashset, iterate over head A, put all nodes
             inside hashSet. Iterate over headB, check for every node in B is 
             present in the hashSet, if anything present return that node.

             Tc is O(m + n), Sc is O(m) - for storing all nodes in A.
        
        

        ListNode temp = headA;
        ListNode ans = null;

        HashSet<ListNode> hash = new HashSet<>();

        while(temp!=null){
            hash.add(temp);
            temp = temp.next;
        }

        temp = headB;
         
        while(temp!=null){
            if(hash.contains(temp)){
                ans = temp;
                break;
            }
            temp = temp.next;
        }

        return ans;*/


        
    }
}