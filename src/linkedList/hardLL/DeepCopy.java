package linkedList.hardLL;

import java.util.HashMap;

public class DeepCopy {
   public static class Node {
      int val;
      Node next;
      Node random;

      public Node(int val) {
         this.val = val;
         this.next = null;
         this.random = null;
      }
   }
   public static Node copyRandomList(Node head) {
      HashMap<Integer , Node> map = new HashMap<>();
      //copying vals.
      Node temp = head;
      Node copyListHead = null;
      while(temp != null){
         copyListHead = insertLast(temp.val, copyListHead);
         map.put(temp.val , temp);

      }
      return head;
   }

   private static Node insertLast(int val, Node head ){
      Node newNode = new Node(val);
      if(head == null){
         head = newNode;
      }
      Node temp = head;
      while(temp.next != null){
         temp = temp.next;
      }
      temp.next = newNode;
      return head;
   }
}
