package linkedList.hardLL;

import linkedList.OneDLL.LinkedList;
import linkedList.OneDLL.LinkedList.ListNode;

import static linkedList.OneDLL.LinkedList.show;

public class RotateLL {
   public static ListNode rotateRight(ListNode head, int k) {
      int size = getSize(head);
      int toRotate = k % size;
      while(toRotate-- > 0){
         ListNode slN = getSecondLastNode(head);
         head = insertFirst(slN.next.val , head);
         slN.next = null;
      }
      return head;
   }

   private static ListNode insertFirst(int val , ListNode head) {
      ListNode newNode = new ListNode(val);
      if(head == null){
         head = newNode;
      }
      newNode.next = head;
      head = newNode;
      return head;
   }

   private static ListNode getSecondLastNode(ListNode head) {
      if(head == null) return null;
      if(head.next == null) return head;
      ListNode temp = head;
      while(temp.next != null){
         if(temp.next.next == null){
            break;
         }
         temp = temp.next;
      }
      return temp;
   }

   private static int getSize(ListNode head) {
      ListNode temp = head;
      int size = 0;
      while(temp != null){
         size++;
         temp = temp.next;
      }
      return size;
   }

   public static void main(String[] args) {
      LinkedList list = new LinkedList();
      list.insertLast(1);
      list.insertLast(2);
      list.insertLast(3);
      list.insertLast(4);
      list.insertLast(5);
      ListNode head = list.getHead();
      show(head);
      ListNode rotateHead = rotateRight(head , 2);
      show(rotateHead);
   }


}
