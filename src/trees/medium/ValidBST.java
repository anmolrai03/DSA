package trees.medium;

import trees.implementation.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidBST {

   public static boolean isValidBST(TreeNode root) {
      if(root == null) return true;
      if( (root.left != null && root.left.val < root.val)   && (root.right != null  && root.right.val > root.val)){
         return true;
      }

      return isValidBST(root.left) && isValidBST(root.right);
   }


   public static boolean isValidBST1(TreeNode root) {
      return (isSorted(inOrder(root)));
   }

   private static boolean isSorted(List<Integer> list){
      if(list.size() == 1) return true;
      for(int i =0; i < list.size()-2; i++){
         if (list.get(i) > list.get(i + 1)) {
            return false;
         }
      }
      return true;
   }

   private static List<Integer> inOrder(TreeNode root){
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

   public static void main(String[] args) {
      TreeNode root = new TreeNode(2);
      root.left = new TreeNode(1);
      root.right = new TreeNode(3);
      System.out.println(isValidBST(root));

      TreeNode r = new TreeNode(5);
      r.left = new TreeNode(1);
      r.right = new TreeNode(4);

      r.right.left = new TreeNode(3);
      r.right.right = new TreeNode(6);
      System.out.println(isValidBST(r));
   }
}
