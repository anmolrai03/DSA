package linkedList.Leetcode;

import java.util.List;

class ListNode {
    int val;
   ListNode next;
   ListNode() {}
    ListNode(int val) { this.val = val; }
   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class RemoveElement {
   public static void display(ListNode head){
      ListNode temp = head;
      while(temp != null){
         System.out.print(temp.val+"->");
      }
      System.out.println("End");
   }
   public ListNode removeElements(ListNode head, int val) {
      if(head == null) return null;
      if(head.next == null && head.val == val) return null;
      if(head.next == null) return head;
      ListNode temp = head;
      while(temp != null){
         if(temp.val == val && temp.next != null){

            temp.val = temp.next.val;
            temp.next = temp.next.next;
         }
         if(temp.val == val && temp.next == null){
            temp = null;
         }
         temp = temp.next;
      }
      return head;
   }
}
