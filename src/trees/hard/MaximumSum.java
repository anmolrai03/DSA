package trees.hard;

import trees.implementation.TreeNode;

import static trees.implementation.Trees.inorder;
import static trees.implementation.Trees.lvlOrder;

public class MaximumSum {

   public static int maxPathSum(TreeNode root) {
      return helper(root);
   }

   private static int helper(TreeNode root){

      if(root == null) return 0;

      if(root.left == null && root.right == null){
         return root.val;
      }

      int left; int right;
      if(root.left != null){
         left = helper(root.left);
      } else{
         left = Integer.MIN_VALUE;
      }
      if(root.right != null){
         right = helper(root.right);
      } else{
         right = Integer.MIN_VALUE;
      }

//      if(left != Integer.MIN_VALUE && right != Integer.MIN_VALUE){
//         return max(Math.max(left , right) , root.val + left , root.val + right , root ,
//             root.val + left +right);
////         if(maxVal < left + right + root.val){
////            maxVal = left + right + root.val;
////         }
//      }
      if(left == Integer.MIN_VALUE){
         return Math.max(root.val + right , root.val);
      }

      if(right == Integer.MIN_VALUE){
         return Math.max(root.val+right , root.val);
      }
      return max(Math.max(left , right) , root.val + left , root.val + right , root.val ,
          root.val + left +right);
   }

   private static int max(int a , int b , int c, int d , int e){
      return Math.max(a , Math.max(b , Math.max(c , Math.max(d , e))));
   }



   public static void main(String[] args) {
      TreeNode root = new TreeNode(2);
      root.left = new TreeNode(1);
      root.right = new TreeNode(3);

//      inorder(root);
      System.out.println(lvlOrder(root));
//      System.out.println();
//      System.out.println();
      System.out.println(maxPathSum(root));

      TreeNode r = new TreeNode(-10);
      r.left = new TreeNode(9);
      r.right = new TreeNode(20);

      r.right.left = new TreeNode(15);
      r.right.right = new TreeNode(7);

//      inorder(r);
      System.out.println(lvlOrder(r));
      System.out.println(maxPathSum(r));

      TreeNode r1 = new TreeNode();
      System.out.println(r1);

      System.out.println(lvlOrder(r1));
      inorder(r1);
   }
}
