package linkedList.mediumLL;

import linkedList.OneDLL.LinkedList;
import linkedList.OneDLL.LinkedList.ListNode;


import static linkedList.OneDLL.LinkedList.show;

public class SwapNodeInPairs {

   public static ListNode swapPairs(ListNode head) {

      if(head == null || head.next == null) return head;

      ListNode temp = head; ListNode kthNode; ListNode prevNode = null; ListNode nextNode;

      while(temp != null){
         kthNode = getKthNode(temp);

         if(kthNode == null){
            prevNode.next = temp;
            break;
         }

         nextNode = kthNode.next;
         kthNode.next = null;
         reverse(temp);
         if(temp == head){
            head = kthNode;
         } else{
            prevNode.next = kthNode;
         }
         prevNode = temp;
         temp = nextNode;
      }
      return head;
   }

   private static ListNode getKthNode(ListNode node){
      return node.next;
   }

   private static ListNode reverse(ListNode root){
      if(root == null || root.next == null ) return root;
      ListNode past = null;
      ListNode present = root;
      ListNode future = present.next;
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
      list.insertLast(4);
      ListNode h1 = list.getHead();
      System.out.println("normal");
      show(h1);
      show(swapPairs(h1));
      System.out.println();

      System.out.println("only two elements.");
      LinkedList list1 = new LinkedList();
      list1.insertLast(1);
      list1.insertLast(2);
      list1.insertLast(3);
      ListNode h2 = list1.getHead();
      show(swapPairs(h2));
      System.out.println();

      System.out.println("null");
      LinkedList list2 = new LinkedList();
      ListNode h3 = list2.getHead();
      show(swapPairs(h3));
   }
}
