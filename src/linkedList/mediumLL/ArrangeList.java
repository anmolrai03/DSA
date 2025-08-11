package linkedList.mediumLL;

//given a linked list with even nodes in ascending order and odd nodes in descending order sort
// them in ascending order altogether.

import linkedList.OneDLL.LinkedList;
import linkedList.OneDLL.LinkedList.ListNode;

import java.util.List;

import static linkedList.OneDLL.LinkedList.show;

public class ArrangeList {
   public static void main(String[] args) {
//      LinkedList list = new LinkedList();
//      list.insertLast(13);
//      list.insertLast(99);
//      list.insertLast(15);
//      list.insertLast(80);
//      list.insertLast(19);
//      list.insertLast(70);
//      show(list.getHead());
//      show(arrangeList(list.getHead()));

      LinkedList list1 = new LinkedList();
      list1.insertLast(4);
      list1.insertLast(8);
      list1.insertLast(6);
      list1.insertLast(5);
      list1.insertLast(3);
      list1.insertLast(1);
      ListNode head = list1.getHead();
      show(head);
      show(arrangeList(head));
   }

   public static ListNode arrangeList(ListNode head){
      if(head == null || head.next == null) return head;

      ListNode ascHead = head;
      ListNode desHead = head.next;
      ListNode toReverseDesHead = desHead;
      while(ascHead != null && desHead != null){
         ascHead.next = desHead.next;
         ascHead = ascHead.next;
         if(ascHead != null){
            desHead.next = ascHead.next;
            desHead = desHead.next;
         }
      }
      System.out.println("first half");
      show(head);
//      show(toReverseDesHead);

      ListNode reveseDesHead = reverse(toReverseDesHead);
      System.out.println("after reverse second half");
      show(reveseDesHead);
      ListNode ansHead = merge(head , reveseDesHead);
      return ansHead;
   }

   private static ListNode reverse(ListNode head){
      ListNode pas = null;
      ListNode pres = head;
      ListNode fut = head.next;
      while(pres != null){
         pres.next = pas;
         pas = pres;
         pres = fut;
         if(fut != null){
            fut = fut.next;
         }
      }
      return pas;
   }

   private static ListNode merge(ListNode list1, ListNode list2) {
      if(list1 == null) return list2;
      if(list2 == null) return list1;

      ListNode current1 = list1;
      ListNode current2 = list2;
      ListNode ansHead = new ListNode();
      ListNode prev = ansHead;
      while(current1!=null && current2!=null){
         if(current1.val==current2.val){
            prev.next = current1;
            prev = current1;
            current1 = current1.next;
         }
         else if(current1.val>current2.val){
            prev.next = current2;
            prev = current2;
            current2 = current2.next;
         }else{
            prev.next = current1;
            prev = current1;
            current1 = current1.next;
         }
      }
      if(current2!=null){
         prev.next = current2;
      }else{
         prev.next = current1;
      }
      return ansHead.next;
   }

}
