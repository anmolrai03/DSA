package linkedList.mediumLL;

import linkedList.OneDLL.LinkedList;
import linkedList.OneDLL.LinkedList.ListNode;

import static linkedList.OneDLL.LinkedList.show;

public class AddOne {

   public static ListNode reverseList(ListNode head){
      if(head == null || head.next == null){
         return head;
      }

      ListNode prev = null;
      ListNode pres = head;
      ListNode fut = head.next;
      while(pres != null){
         pres.next = prev;
         prev = pres;
         pres = fut;
         if(fut != null){
            fut = fut.next;
         }
      }
      return prev;
   }

   public static ListNode addOne(ListNode head){

      //reverse the head.
      ListNode newHead = reverseList(head);

      //addition of one to it.
      int carry = 1;
      ListNode temp = newHead;

      while(temp != null){
         int sum = (temp.val + carry) % 10;
         carry = (temp.val + carry) / 10;

         temp.val = sum;
         if(carry == 0) {
            break;
         }
         temp = temp.next;
      }

      //re-reverse the list. again to get the original list back.
      reverseList(newHead);
      //if there is still a carry left , i.e, carry != 0. then add a new node with 1 and make it
      // head.
      if(carry != 0){
         ListNode carryNode = new ListNode(1);
         carryNode.next = head;
         head = carryNode;
      }
      return head;
   }

   public static void main(String[] args) {
      LinkedList list = new LinkedList();
      list.insertLast(9);
      list.insertLast(9);
      list.insertLast(9);
//      list.display();

      ListNode head = list.getHead();
//      Node newHead = reverseList(head);
//      System.out.println("Before");
      show(head);
//      show(newHead);
//      reverseList(newHead);
//      show(head);
      ListNode ans = addOne(head);
      System.out.println("+ 1 = ");
      show(ans);

   }
}
