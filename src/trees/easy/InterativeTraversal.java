package trees.easy;

import trees.implementation.TreeNode;

import java.util.*;

public class InterativeTraversal {
   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(7);

      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);

      root.left.right.left = new TreeNode(5);
      root.left.right.right = new TreeNode(6);

      System.out.println(preorder(root));
      System.out.println(inorder(root));
      System.out.println(lvlOrder(root));


   }

   static List<Integer> preorder(TreeNode root){
      List<Integer> pre = new ArrayList<>();

      if( root == null ) return pre;

      Stack<TreeNode> st = new Stack<>();
      st.add(root);

      while( !st.isEmpty()){
         root = st.pop();
         pre.add(root.val);

         if( root.right != null ){
            st.push(root.right);
         }

         if( root.left != null ){
            st.push(root.left);
         }
      }

      return pre;
   }

   static List<Integer> postorder(TreeNode root){
      List<Integer> post = new ArrayList<>();

      

      return post;
   }


   static List<Integer> lvlOrder(TreeNode root){
      if( root == null ){
         return new ArrayList<>();
      }

      Queue<TreeNode> q = new LinkedList<>();
      List<Integer> res = new ArrayList<>();
      q.add(root);

      while( !q.isEmpty()){
         TreeNode temp = q.remove();
         res.add(temp.val);

         if( temp.left != null ){
            q.add(temp.left);
         }

         if( temp.right != null ){
            q.add(temp.right);
         }
      }

      return res;
   }

   static List<Integer> inorder(TreeNode root){
      List<Integer> in = new ArrayList<>();

      Stack<TreeNode> st = new Stack<>();
      TreeNode node = root;

      while(true){
         if(node != null ){
            st.push(node);
            node = node.left;
         } else {
            if(st.isEmpty()){
               break;
            }
            node = st.pop();
            in.add(node.val);
            node = node.right;
         }
      }
      return in;
   }
}
