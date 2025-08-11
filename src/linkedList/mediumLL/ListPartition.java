package linkedList.mediumLL;

import linkedList.OneDLL.LinkedList;
import linkedList.OneDLL.LinkedList.ListNode;
import static linkedList.OneDLL.LinkedList.show;

public class ListPartition {
   public static ListNode partition(ListNode head, int x) {

      if(head == null || head.next == null) return head;

      ListNode smallerThanXList = null;
      ListNode stxTail = null;
      ListNode greaterThanXList = null;
      ListNode gtxTail = null;

      ListNode temp= head;
      while(temp != null){
         if(temp.val < x){
            if(smallerThanXList == null){
               smallerThanXList = new ListNode(temp.val);
               stxTail = smallerThanXList;
            } else{
               stxTail.next = new ListNode(temp.val);
               stxTail = stxTail.next;
            }
         }

         else{
            if(greaterThanXList == null){
               greaterThanXList = new ListNode(temp.val);
               gtxTail = greaterThanXList;
            } else{
               gtxTail.next = new ListNode(temp.val);
               gtxTail = gtxTail.next;
            }
         }

         temp = temp.next;
      }
      if(stxTail != null){
         stxTail.next = greaterThanXList;
         return smallerThanXList;
      }

      return greaterThanXList;
   }

   public static void main(String[] args) {
      LinkedList list = new LinkedList();
      list.insertFirst(1);
      list.insertLast(1);
      ListNode head = list.getHead();
      show(head);

      ListNode ans = partition(head , 0);
      show(ans);
   }
}
