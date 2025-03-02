package linkedList.mediumLL;


import linkedList.OneDLL.LinkedList;
import linkedList.OneDLL.LinkedList.Node;

import static linkedList.OneDLL.LinkedList.show;

public class SortOneTwoZero {

   public static Node segregate(Node head) {
      // add your code here
      int[] arr = {0,0,0};

      //filling frequency array.
      Node temp = head;
      while(temp != null){
         arr[temp.data] += 1;
         temp = temp.next;
      }
      //sort the lindedlist.
      temp = head;
      for(int i = 0 ; i < 3 ; i++){
         while(arr[i] != 0){
            temp.data = i;
            temp = temp.next;
            arr[i]--;
         }
      }
      return head;
   }

   public static void main(String[] args) {
      LinkedList list = new LinkedList();
      list.insertLast(1);
      list.insertLast(2);
      list.insertLast(2);
      list.insertLast(1);
      list.insertLast(2);
      list.insertLast(0);
      list.insertLast(2);
      list.insertLast(2);
      show(list.getHead());
      Node ans = segregate(list.getHead());
      show(ans);
   }

}
