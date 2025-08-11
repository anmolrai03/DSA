//package trees.medium;
//
//import trees.implementation.TreeNode;
////import static trees.implementation.Trees.lvlOrder;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
////construct bst from given pre and in order.
//public class ConsturctBST {
//
//   static class MyNum{
//      int num;
//
//      MyNum(int a) {
//         num = a;
//      }
//   }
//
//   // Preorder and inorder to tree
//   public static TreeNode buildTree(int[] preorder, int[] inorder) {
//      MyNum num = new MyNum(0);
//      return helper(preorder , inorder , num);
//   }
//
//   private static TreeNode helper(int[] preorder , int[] inorder , MyNum i){
//      if(inorder.length == 0){
//         return null;
//      }
//
//      int idx = search(preorder[i.num] , inorder);
//      TreeNode root = null;
//      if(idx != -1){
//         root = new TreeNode(preorder[i.num]);
//         i.num = i.num+1;
//         root.left = helper(preorder , Arrays.copyOfRange(inorder , 0 , idx), i);
//         root.right = helper(preorder , Arrays.copyOfRange(inorder , idx+1  , inorder.length) ,
//             i);
//      }
//      return root;
//   }
//
//   private static int search(int target , int[] arr){
//      int n = arr.length;
//      for(int i = 0; i < n; i++){
//         if(target == arr[i]){
//            return i;
//         }
//      }
//      return -1;
//   }
//
//
//   //Postorder and inorder for tree.
//   public static TreeNode buildTreePost(int[] postorder, int[] inorder) {
//      MyNum num = new MyNum(postorder.length-1);
//      return helperPost(postorder , inorder , num);
//   }
//
//   private static TreeNode helperPost(int[] postorder , int[] inorder , MyNum i){
//      if(inorder.length == 0){
//         return null;
//      }
//
//      int idx = search(postorder[i.num] , inorder);
//      TreeNode root = null;
//      if(idx != -1){
//         root = new TreeNode(postorder[i.num]);
//         i.num = i.num-1;
//         System.out.println(i.num);
//         root.left = helperPost(postorder , Arrays.copyOfRange(inorder , 0 , idx), i);
//
//         root.right = helperPost(postorder , Arrays.copyOfRange(inorder , idx+1  , inorder.length) ,
//             i);
//         System.out.println(i.num);
//      }
//      return root;
//   }
//
//
//
//   public static void main(String[] args) {
////      int[] preorder = {3,9,20,15,7};
////      int[] inorder = {9,3,15,20,7};
////
////      TreeNode root = buildTree(preorder , inorder);
////      System.out.println(lvlOrder(root));
////
////
////      int[] preorder1 = {-1};
////      int[] inorder1 = {-1};
////
////      TreeNode root1 = buildTree(preorder1 , inorder1);
////      System.out.println(lvlOrder(root1));
//
//
//      int[] postorder = {9,15,7,20,3};
//      int[] inorder = {9,3,15,20,7};
//
//
//      TreeNode root = buildTreePost(postorder , inorder);
//      System.out.println(lvlOrder(root));
//      List<Integer> list = new ArrayList<>();
//   }
//}
