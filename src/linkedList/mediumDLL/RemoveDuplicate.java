package linkedList.mediumDLL;

import linkedList.DoublyLL.DoublyLinedList;
import linkedList.DoublyLL.DoublyLinedList.ListNode;
import static  linkedList.DoublyLL.DoublyLinedList.showList;

public class RemoveDuplicate {
   public static void main(String[] args) {
      DoublyLinedList dll = new DoublyLinedList();
//      dll.insertLast(1);
//      dll.insertLast(1);
//      dll.insertLast(1);
//      dll.insertLast(2);
//      dll.insertLast(2);
//      dll.insertLast(3);
//      dll.insertLast(3);
//      dll.insertLast(4);
      dll.insertLast(4);
//      dll.insertLast(5);
//      dll.insertLast(2);
      ListNode head = dll.getHead();
      showList(head);

//      Node ans = deleteOccurences(dll.getHead() , 21);
//      showList(ans);
      ListNode ans = removeDuplicates(head);
      showList(ans);

   }

   static ListNode removeDuplicates(ListNode head){
      // Code Here.
      //for null and size 1;
      if(head == null || head.next == null){
         return head;
      }
      //for size 2.
//      if(head.next.next == null && head.data == head.next.data){
//         head.next = null;
//         return head;
//      }
      //for other lengths.
      ListNode temp = head;
      while(temp != null){
         if(temp.prev != null && temp.val == temp.prev.val){
            temp = temp.prev;
            temp.next = temp.next.next;
            if(temp.next != null){
               temp.next.prev = temp;
            } else{
               break;
            }

         }
         temp = temp.next;
      }
      return head;
   }
}
