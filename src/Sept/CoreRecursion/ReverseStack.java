package Sept.CoreRecursion;

import java.util.Stack;

public class ReverseStack {

   public static void reverseStackOne(Stack<Integer> st , Stack<Integer> rev){
      // base case
      if(st.isEmpty()) return;

      // recursive case
      int temp = st.pop();
      rev.push(temp);
      reverseStackOne(st, rev);

      st.push(temp);
   }

   public static void reverseStackTwo(Stack<Integer> st){
      // base case
      if(st.isEmpty()) return;

      // recursive case
      int temp = st.pop();
      reverseStackTwo(st);
      insertAtBottomOfStack(st, temp);

   }

   private static void insertAtBottomOfStack(Stack<Integer> st, int ele){
      //base case
      if(st.isEmpty()){
         st.push(ele);
         return;
      }

      // recursive case
      int temp = st.pop();
      insertAtBottomOfStack(st, ele);
      st.push(temp);
   }

   public static void main(String[] args) {
      Stack<Integer> st = new Stack<>();
      st.push(1);
      st.push(2);
      st.push(3);
      st.push(4);
      st.push(5);

      System.out.println("using two stack");
      System.out.println(st);

      Stack<Integer> rev = new Stack<>();
      reverseStackOne(st , rev);
      System.out.println(rev);

      System.out.println("using one stack");
      System.out.println(st);

      reverseStackTwo(st);
      System.out.println(st);

//      insertAtBottomOfStack(st , 8);
//      System.out.println(st);
   }
}
