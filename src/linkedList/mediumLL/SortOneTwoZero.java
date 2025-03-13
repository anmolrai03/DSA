package linkedList.mediumLL;


import linkedList.OneDLL.LinkedList;
import linkedList.OneDLL.LinkedList.ListNode;

import static linkedList.OneDLL.LinkedList.show;

public class SortOneTwoZero {

   public static ListNode segregate(ListNode head) {
      // add your code here
      int[] arr = {0,0,0};

      //filling frequency array.
      ListNode temp = head;
      while(temp != null){
         arr[temp.val] += 1;
         temp = temp.next;
      }
      //sort the lindedlist.
      temp = head;
      for(int i = 0 ; i < 3 ; i++){
         while(arr[i] != 0){
            temp.val = i;
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
      ListNode ans = segregate(list.getHead());
      show(ans);
   }

}
