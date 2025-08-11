package trees.medium;

import trees.implementation.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FlatenTree {

   static class CustomNode{
      TreeNode head;
      TreeNode tail;

      public CustomNode(){};
   }

   public static void flatten(TreeNode root) {
      CustomNode node = helper(root);
      root = node.head;
   }

   private static CustomNode helper(TreeNode root){
      CustomNode node = new CustomNode();

      if(isLeaf(root)){
         node.head = root;
         node.tail = root;
         return node;
      }

      CustomNode left = helper(root.left);
      CustomNode right = helper(root.right);

      root.right = left.head;
      left.tail = right.head;


      node.head = root;
      node.tail = right.tail;

      return node;
   }

   private static boolean isLeaf(TreeNode node){
      return node.left == null && node.right == null;
   }

   public static List<Integer> preOrder(TreeNode root){
      //root - left -right.
      if(root == null) return new ArrayList<>();

      List<Integer> list = new ArrayList<>();
      list.add(root.val);

      List<Integer> left = new ArrayList<>();
      List<Integer> right = new ArrayList<>();

      if(root.left != null){
         left = preOrder(root.left);
      }
      if(root.right != null){
         right = preOrder(root.right);
      }

      if(!left.isEmpty()){
         list.addAll(left);
      }
      if(!right.isEmpty()){
         list.addAll(right);
      }

      return list;

   }


   public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(5);

      root.left.left = new TreeNode(3);
      root.left.right = new TreeNode(4);

      root.right.right = new TreeNode(6);

      System.out.println(preOrder(root));
      flatten(root);
      System.out.println(preOrder(root));

   }

}
