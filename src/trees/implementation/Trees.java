package trees.implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Trees {


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

   public static List<Integer> inOrder(TreeNode root){
      if(root == null){
         return new ArrayList<>();
      }
      //l -root -right.
      List<Integer> left = inOrder(root.left);
      List<Integer> list = new ArrayList<>();
      list.add(root.val);
      List<Integer> right = inOrder(root.right);
      left.addAll(list);
      left.addAll(right);
      return left;
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



   /*
   // DFS - Depth First Search
   static void postorder(TreeNode root){
      // left -> right -> root
      if( root == null) return;
      postorder(root.left);
      postorder(root.right);
      System.out.print(root.data+" ");
   }

   static void preorder(TreeNode root){
      // root -> left -> right
      if( root == null) return;
      System.out.print(root.data+" ");
      preorder(root.left);
      preorder(root.right);

   }

   static void inorder(TreeNode root){
      //left -> root -> right
      if( root == null) return;

      inorder(root.left);
      System.out.print(root.data+" ");
      inorder(root.right);
   }
    */
}
