package linkedList.mediumDLL;

import linkedList.DoublyLL.DoublyLinedList;
import linkedList.DoublyLL.DoublyLinedList.Node;

import static  linkedList.DoublyLL.DoublyLinedList.showList;

public class DeleteAllOccurencesOfKey {

   public static void main(String[] args) {
      DoublyLinedList dll = new DoublyLinedList();
//      dll.insertLast(2);
//      dll.insertLast(2);
//      dll.insertLast(10);
//      dll.insertLast(8);
//      dll.insertLast(4);
//      dll.insertLast(2);
//      dll.insertLast(5);
//      dll.insertLast(2);
      showList(dll.getHead());

      Node ans = deleteOccurences(dll.getHead() , 21);
      showList(ans);

   }

   public static Node deleteOccurences(Node head , int key){
      if(head == null || (head.next == null && head.data == key)){
         return null;
      }

      if(head.next == null && head.data != key){
         return head;
      }

      //now for others
      Node temp = head;
      while(temp != null){
         if(temp.data == key){

            //Case 1: it is head;
            if(temp.prev == null){
               head = head.next;
               head.prev = null;
            }

            //Case 2: it is tail.
            else if(temp.next == null){
               temp = temp.prev;
               temp.next = null;
            }

            //Case 3: anywhere in between.
            else{
               temp = temp.prev;
               temp.next = temp.next.next;
               temp.next.prev = temp;
            }
         }
         temp = temp.next;
      }

      return head;
   }
}
