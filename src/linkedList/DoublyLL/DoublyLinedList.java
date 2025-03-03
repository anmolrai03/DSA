package linkedList.DoublyLL;

public class DoublyLinedList {

   public int size;
   public Node head;
   public Node tail;

   public static class Node{
      public int data;
      public Node next;
      public Node prev;

      public Node(int data , Node next , Node prev){
         this.data = data;
         this.next = next;
         this.prev = prev;
      }

      public Node(int data) {
         this.data = data;
         this.next = null;
         this.prev = null;
      }
   }

   public DoublyLinedList(){
      this.size = 0;
   }

   //Insertion in the doubly linked list.
   public void insertFirst(int val){
      //Create a node.
      Node newNode = new Node(val);

      if(this.tail == null){
         this.head = newNode;
         this.tail = newNode;
         this.size++;
         return;
      }
      newNode.next = head;
      head.prev = newNode;
      head = newNode;
      this.size++;
   }

   public void insertLast(int val){

      Node newNode = new Node(val);

      if(this.tail == null){
         this.head = newNode;
         this.tail = newNode;
         this.size++;
         return;
      }
      this.tail.next = newNode;
      newNode.prev = this.tail;
      this.tail = newNode;
      this.size++;

   }

   public void insertAt(int val , int index){
      if(index > this.size-1){
         System.out.printf("Index %d do not exists.\n", index);
         return;
      }
      if(index == 0){
         insertFirst(val);
      }
      else if(index == this.size -1){
         insertLast(val);
      }
      else{
         int cnt = 1;
         Node newNode = new Node(val);
         Node temp = this.head;
         while(temp != null && cnt != index){
            cnt++;
            temp = temp.next;
         }
         //fill the newnode's prev and next.
         newNode.prev = temp;
         newNode.next = temp.next;

         //modify temp's next reference and temp.next's prev reference.
         temp.next.prev = newNode;
         temp.next = newNode;
         this.size++;
      }
   }

   //deletion from a doubly linkedlist.
   public void deleteFirst(){
      if(this.head == null){
         System.out.println("List empty");
         return;
      }
      this.head = this.head.next;
      this.head.prev = null;
      this.size--;
   }

   public void deleteLast(){
      if(this.head == null){
         System.out.println("List is Empty");
         return;
      }
      tail = tail.prev;
      tail.next = null;
      this.size--;
   }

   public void deleteIndex(int index){
      if(index >= this.size){
         System.out.printf("Index %d do not exist.\n", index);
         return;
      }
      if(this.head == null){
         System.out.println("List is Empty.");
         return;
      }
      if(index == 0){
         deleteFirst();
      }
      else if(index == this.size -1 ){
         deleteLast();
      }
      else{
         int cnt = 1;
         Node temp = this.head;
         while(temp != null && cnt != index){
            cnt++;
            temp = temp.next;
         }
         temp.next.next.prev = temp;
         temp.next = temp.next.next;
         this.size--;
      }
   }

   //Get the size of the linked list.
   public int size(){
      return this.size;
   }

   //get head
   public Node getHead(){
      return  this.head;
   }

   //traversal of the linkedlist.
   public void display() {
      if(this.head == null){
         System.out.println("List is Empty.");
         return;
      }
      Node temp = this.head;
      while(temp != null){
         System.out.print(temp.data + "->" );
         temp = temp.next;
      }
      System.out.println("End");
   }

   public static void showList(Node head){
      if(head == null){
         System.out.println("List Empty.");
         return;
      }
      Node temp = head;
      while(temp != null){
         System.out.print(temp.data + "->");
         temp = temp.next;
      }
      System.out.println("End");
   }


}
