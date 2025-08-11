package linkedList.Training.LinkedListQues;

import linkedList.OneDLL.LinkedList;
import linkedList.OneDLL.LinkedList.*;

import static linkedList.OneDLL.LinkedList.show;

public class RemoveEven {
   static ListNode removeEven(ListNode head){
      if(head == null ) return null;
      if(head.next == null && head.val %2 == 0) return null;

      ListNode stay = head;
      while(  stay != null &&  stay.val % 2 == 0){
          stay =  stay.next;
      }

      ListNode ans =  stay;
      ListNode move =  stay;

      while( move != null ){
         // if move.val is odd and stay != move connect stay.next to move and stay to move, then
         // move = move.next;
         if( move.val % 2 != 0 &&  stay != move){
             stay.next = move;
             stay= move;
         }
         move = move.next;

      }
      if(stay != null) stay.next = move;
      return ans;
   }

   public static void main(String[] args) {
      LinkedList ll = new LinkedList();
      ll.insertLast(2);
      ll.insertLast(4);
      ll.insertLast(5);
      ll.insertLast(4);
      ll.insertLast(6);
      ll.insertLast(3);
//      ll.insertLast(2);
      ll.insertLast(0);
//      System.out.println("Original list");
      ll.display();

      ListNode ans = removeEven(ll.getHead());
//      System.out.println("Ans: ");
      show(ans);
   }
}
