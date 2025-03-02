package linkedList.mediumLL;

import linkedList.OneDLL.LinkedList;
import linkedList.OneDLL.LinkedList.Node;
import static linkedList.OneDLL.LinkedList.show;

public class SegregateOddEven {

   public static Node segregate(Node head){
      if(head == null || head.next == null || head.next.next == null){
         return head;
      }

      //find length
      int lnt = 0;
      Node tempNode = head;
      while(tempNode != null){
         lnt++;
         tempNode = tempNode.next;
      }
      System.out.println(lnt);

      Node curr = head;
      Node nex = head.next;
      int idx = 1;
      Node temp = null;
      while(curr != null){

         if(idx == 2){
            temp = curr;
         }

         if(lnt % 2 == 0){
            if(nex == null || nex.next == null){
               curr.next = temp;
//            curr = nex;
               break;
            }
         } else {
            if(nex == null){
               curr.next = temp;
//            curr = nex;
               break;
            }
         }
         curr.next = nex.next;
         curr = nex;
         nex = nex.next;
         idx++;
      }
      return  head;
   }


   public static void main(String[] args) {
      LinkedList list = new LinkedList();
      list.insertLast(1);
      list.insertLast(2);
      list.insertLast(3);
      list.insertLast(4);
      list.insertLast(5);
//      list.insertLast(6);
//      list.insertLast(7);
//      list.insertLast(8);
//      list.display();
      Node head = list.getHead();
      show(head);
      Node ans = segregate(head);
      show(ans);
   }
}
