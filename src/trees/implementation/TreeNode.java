package trees.implementation;

public class TreeNode {

   public int val;
   public TreeNode left;
   public TreeNode right;
   public TreeNode() {}
   public TreeNode(int val) { this.val = val; }

   public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
   }


   /*
   public int val;
   public TreeNode left;
   public TreeNode right;

   public TreeNode(){
      this.val = 0;
      this.right = this.left = null;
   }

   public TreeNode(int data){
      this.val = data;
      this.left = this.right = null;
   }

   public TreeNode(int data , TreeNode left , TreeNode right){
      this.val = data;
      this.left = left;
      this.right = right;
   }

    */
}
