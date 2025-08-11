package linkedList.mediumLL;

import linkedList.OneDLL.LinkedList.ListNode;
import linkedList.OneDLL.LinkedList;

import static linkedList.OneDLL.LinkedList.show;


public class Palindrom {

   private static ListNode deleteLastNode(ListNode head){

      if(head == null || head.next == null) return null;

      ListNode temp = head;
      while(temp.next.next != null){
         temp = temp.next;
      }
      temp.next = null;
      return head;
   }

   public static boolean isPalindrome(ListNode head) {

      // write your code here
      if(head == null){
         return false;
      }

      if(head.next == null){
         return true;
      }

      ListNode s = head;
      ListNode f = head;
      while(f != null && f.next != null){
         s = s.next;
         f = f.next.next;
      }
      ListNode revHead = reverseList(s);
      ListNode temp = head;
      while(temp != null && revHead != null){
         if(temp.val != revHead.val){
            return false;
         }
         temp = temp.next;
         revHead = revHead.next;
      }
      reverseList(revHead);

      return true;
   }

   public static ListNode reverseList(ListNode head){

      if(head == null || head.next == null){
         return head;
      }

      ListNode past = null;
      ListNode present = head;
      ListNode future = head.next;

      while(present != null){
         present.next = past;
         past = present;
         present = future;
         if(future != null){
            future = future.next;
         }
      }

      return past;
   }


   public static void main(String[] args) {
      LinkedList list = new LinkedList();
      list.insertLast(1);
      list.insertLast(2);
      list.insertLast(3);
      list.insertLast(2);
      list.insertLast(1);
//      list.insertLast(8);

      ListNode head = list.getHead();
      show(head);
//      Node revhead = reversedList(list.getHead());
//      show(revhead);
      System.out.println(isPalindrome(head));
   }
}
