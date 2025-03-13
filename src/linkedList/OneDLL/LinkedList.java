package linkedList.OneDLL;

public class LinkedList {

   public ListNode head;
   public ListNode tail;

   public int size;

   public static class ListNode {
      public int val;
      public ListNode next;

      public ListNode(int data , ListNode next){
         this.val = data;
         this.next = next;
      }

      public ListNode(int data){
         this.val = data;
         this.next = null;
      }
   }

   public LinkedList(){
      this.size = 0 ;
   }

//   Insertion into the linked list
   public void insertFirst(int val){
      ListNode newNode = new ListNode(val);

      if(head == null){
         head = newNode;
         tail = newNode;
         this.size += 1;
         return;
      }
      newNode.next = head;
      head = newNode;
      this.size += 1;
   }

   public void insertLast(int val){
      ListNode newNode = new ListNode(val);
      if(tail == null){
         head = newNode;
         tail = newNode;
         this.size += 1;
         return;
      }
      tail.next = newNode;
      tail = newNode;
      this.size += 1;
   }

   public void insertAt(int val , int index){
      if(index > this.size -1){
         System.out.println("Index do not exist.");
         return;
      }
      else if(index == 0){
         this.insertFirst(val);
      }
      else if(index == this.size -1){
         this.insertLast(val);
      }
      else{
         int cnt = 1;
         ListNode temp = this.head;
         while(temp.next != null && cnt != index){
            cnt +=1;
            temp = temp.next;
         }
         ListNode newNode = new ListNode(val);
         newNode.next = temp.next;
         temp.next = newNode;
         this.size +=1;
      }
   }

//   Deletion from the linked list
   public void deleteFirst(){
      if(this.tail == null){
         System.out.println("List is empty.");
         return;
      }
      this.head = head.next;
      this.size -=1;
   }

   public void deleteLast(){
      if(this.tail == null){
         System.out.println("List is empty.");
         return;
      }
      ListNode temp = this.head;
//      while(temp.next != null && temp.next.next != null){
//         temp = temp.next;
//      }
//      temp.next = null;
//      this.tail = temp;
      while(temp.next != this.tail){
         temp = temp.next;
      }
      temp.next = null;
      this.tail = temp;
      this.size -=1;
   }

   public void deleteAt(int index){
      if(index > this.size -1){
         System.out.println("Index do not exist.");
      }
      else if(index == 0){
         this.deleteFirst();
      }
      else if(index == this.size -1){
         this.deleteLast();
      }
      else{
         int cnt = 1;
         ListNode temp = this.head;
         while(temp.next != null && cnt != index){
            cnt +=1;
            temp = temp.next;
         }

//         temp.next.next = null;
         ListNode toDelete = temp.next;
         temp.next = temp.next.next;
         //deleting the deleted node's next in order to remove its reference to the next item in
         // the linked list allowing it to be removed via the garbage collection.
         toDelete.next = null;

         this.size -=1;
      }
   }

//   length the linked list
   public int getSize() {
      return this.size;
   }

//   display the linked list
   public void display(){
      if(tail == null){
         System.out.println("Empty List");
         return;
      }
      ListNode temp = head;
      while (temp != null){
         System.out.print(temp.val + "-> ");
         temp = temp.next;
      }
      System.out.println("End");
   }

   public static void show(ListNode listNode){

      if(listNode == null){
         System.out.println("List is empty.");
      }

      ListNode temp = listNode;
      while (temp != null){
         System.out.print(temp.val + "-> ");
         temp = temp.next;
      }
      System.out.println("End");
   }

   public ListNode getHead(){
      return this.head;
   }

   public static void main(String[] args) {
      int[] arr = {1, 2, 3, 4, 5};
//      Node node = new Node(arr[1]);
//      System.out.println(node.data);f
//      Node node1 = new Node(arr[2]);
//      node.next = node1;
//      System.out.println(node1.data);
//      System.out.println(node1);
//      System.out.println(node.next);
      LinkedList list = new LinkedList();
      list.insertFirst(1);
      list.insertFirst(5);
      list.insertFirst(16);
      list.insertFirst(35);
      list.insertLast(45);
      list.insertLast(15);
      list.insertLast(99);
      list.display();
      System.out.println(list.getSize());
      list.deleteFirst();
      list.display();
      System.out.println(list.getSize());
      list.deleteLast();
      list.display();
      System.out.println(list.getSize());

      list.insertAt(13 , 0);
      list.insertAt(13 , list.getSize()-1);
      list.display();
      list.insertAt(58 , 3);
      list.display();
      System.out.println(list.getSize());
      System.out.println("Delete from at an index.");
      list.deleteAt(2);
      System.out.println(list.getSize());
      list.display();
      list.deleteAt(0);
      list.display();
      System.out.println(list.getSize());

      System.out.println(list.getHead());
      show(list.getHead());

   }
}
