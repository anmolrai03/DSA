package trees.implementation;

import static trees.implementation.Trees.preorder;
import static trees.implementation.Trees.postorder;
import static trees.implementation.Trees.inorder;

public class Main {
   public static void main(String[] args) {

      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      root.right.left = new TreeNode(6);
      root.right.right = new TreeNode(7);

      inorder(root);
      System.out.println();
      preorder(root);
      System.out.println();
      postorder(root);
      System.out.println();

      /*
      List<Integer> in = new ArrayList<>();
      List<Integer> pre = new ArrayList<>();
      List<Integer> post = new ArrayList<>();

      in.add(1);
      in.add(2);

      pre.add(3);
      pre.add(4);

      post.add(5);
      post.add(6);

      List<List<Integer>> list = new ArrayList<>();

      list.add(in);
      list.add(pre);
      list.add(post);
      System.out.println(list);

      in.addAll(pre);
      System.out.println(in);

       */


   }
}
