package trees.implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Trees {
//   public static class Node{
//      int data;
//      Node left;
//      Node right;
//
//      public Node(int val){
//         this.data = val;
//         this.left = null;
//         this.right = null;
//      }
//   }

   public static void preorder(TreeNode root){
      if(root == null){
         return;
      }

      System.out.print(root.val+"->");
      preorder(root.left);
      preorder(root.right);
   }

   public static void postorder(TreeNode root){
      if(root == null){
         return;
      }

      //left - right - root.
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.val+"->");

   }

   public static void inorder(TreeNode root){
      if(root == null){
         return;
      }

      //left - root -right.
      inorder(root.left);
      System.out.print(root.val+"->");
      inorder(root.right);
   }

   public static ArrayList<Integer> lvlOrder(TreeNode root){
      if(root == null) {
         return new ArrayList<>();
      }
      Queue<TreeNode> q = new LinkedList<>();
      ArrayList<Integer> list = new ArrayList<>();
      q.add(root);

      while(!q.isEmpty()){
         TreeNode temp = q.remove();
         list.add(temp.val);
         if(temp.left != null){
            q.add(temp.left);
         }
         if(temp.right != null){
            q.add(temp.right);
         }
      }
      return list;

   }


   public Trees()
   {

   }
}
