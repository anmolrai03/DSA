package linkedList.mediumLL;

import linkedList.OneDLL.LinkedList;
import linkedList.OneDLL.LinkedList.Node;

import static linkedList.OneDLL.LinkedList.show;

public class AddOne {

   public static Node reverseList(Node head){
      if(head == null || head.next == null){
         return head;
      }

      Node prev = null;
      Node pres = head;
      Node fut = head.next;
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

   public static Node addOne(Node head){

      //reverse the head.
      Node newHead = reverseList(head);

      //addition of one to it.
      int carry = 1;
      Node temp = newHead;

      while(temp != null){
         int sum = (temp.data + carry) % 10;
         carry = (temp.data + carry) / 10;

         temp.data = sum;
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
         Node carryNode = new Node(1);
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

      Node head = list.getHead();
//      Node newHead = reverseList(head);
//      System.out.println("Before");
      show(head);
//      show(newHead);
//      reverseList(newHead);
//      show(head);
      Node ans = addOne(head);
      System.out.println("+ 1 = ");
      show(ans);

   }
}
