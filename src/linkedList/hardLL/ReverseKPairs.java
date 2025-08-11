package linkedList.hardLL;
import linkedList.OneDLL.LinkedList;
import linkedList.OneDLL.LinkedList.*;

import java.util.Stack;

import static linkedList.OneDLL.LinkedList.show;

public class ReverseKPairs {

   //Time Complexity : O(n^2) and Space Complexity : O(n) stack.
   public static ListNode reverseKGroup(ListNode head, int k) {
      if(head == null || head.next == null){
         return head;
      }
      if(k <= 1){
         return head;
      }

      Stack<Integer> st = new Stack<>();
      int lnt = 0;
      ListNode temp = head;
      while(temp != null){
         ListNode togoBack = null;
         if(lnt == 0){
            togoBack = temp;
         }
         while(temp != null && lnt != k){
            st.push(temp.val);
            lnt++;
            temp = temp.next;
         }

         if(lnt == k){
            while(togoBack != temp){
               togoBack.val = st.peek();
               st.pop();
               lnt--;
               togoBack = togoBack.next;
            }
         }

      }
      return  head;
   }

   public static void main(String[] args) {
      LinkedList list = new LinkedList();
//      list.insertLast(1);
//      list.insertLast(2);
//      list.insertLast(3);
//      list.insertLast(4);
//      list.insertLast(5);
      ListNode head = list.getHead();
      show(head);
//      Node ans = reverseKGroup(head , 3);
      ListNode ans = reverseKGroup(head , 1);
      show(ans);
   }
}
