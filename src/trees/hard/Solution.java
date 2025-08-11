package trees.hard;

public class Solution {
   static class Node{
      int data;
      Node left;
      Node right;

      //in-order successor => left's rightmost
      Node leftThread;

      // in order-predecessor => right's leftmost
      Node rightThread;

      Node(int val){
         data = val;
         this.left = this.right = this.leftThread = this.rightThread = null;
      }
   }

   static Node fistInorder(Node root){
      if( root == null ) return null;
      Node temp = root;
      while(temp.left != null){
         temp = temp.left;
      }
      while(temp.right != null){
         temp = temp.right;
      }

      return temp;
   }

   static Node lastInorder(Node root){
      if( root == null ) return null;
      Node temp = root;
      while(temp.right != null){
         temp = temp.right;
      }
      while(temp.left != null){
         temp = temp.left;
      }

      return temp;
   }

   static void modifyTree(Node root){
      if( root == null) return;

      Node firstInorder = fistInorder(root);
      Node lastInorder = lastInorder(root);

      root.leftThread = firstInorder;
      root.rightThread = lastInorder;

      modifyTree(root.left);
      modifyTree(root.right);

   }

   //find in-order sucessor
}
