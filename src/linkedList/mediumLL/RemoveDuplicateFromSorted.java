package linkedList.mediumLL;

import linkedList.OneDLL.LinkedList;
import linkedList.OneDLL.LinkedList.ListNode;

import static linkedList.OneDLL.LinkedList.show;

public class RemoveDuplicateFromSorted {
   public static ListNode deleteDuplicates(ListNode head) {
      if(head == null || head.next == null) return head;
      ListNode stay = head;
      ListNode move = head;
      while(move != null){
         if(stay.val == move.val){
            move = move.next;
         }
         else{
            stay.next = move;
            stay = move;
         }
      }
      stay.next = move;
      return head;
   }

   public static void main(String[] args) {
      LinkedList list = new LinkedList();
//      list.insertLast(1);
//      list.insertLast(1);
//      list.insertLast(1);
//      list.insertLast(2);
//      list.insertLast(3);

      LinkedList list1 = new LinkedList();
      list1.insertLast(1);
      list1.insertLast(2);
      list1.insertLast(3);
      list1.insertLast(3);
      list1.insertLast(4);
      list1.insertLast(4);
      list1.insertLast(5);

      ListNode head = list.getHead();

      show(head);
      ListNode temp = deleteDuplicates(head);
      show(temp);

      show(list1.getHead());
      show(deleteDuplicates(list1.getHead()));
   }
}
