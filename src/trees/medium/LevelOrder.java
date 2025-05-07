package trees.medium;

import com.sun.source.tree.Tree;
import trees.implementation.TreeNode;
import static trees.implementation.Trees.lvlOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
   public static List<List<Integer>> levelOrder(TreeNode root) {

      if(root == null){
         List<List<Integer>> list = new ArrayList<>();
         return list;
      }

      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      q.add(null);

      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> in = new ArrayList<>();

      while(!q.isEmpty()){
         TreeNode temp = q.remove();
         if(temp != null){
            in.add(temp.val);
            if(temp.left != null){
               q.add(temp.left);
            }
            if(temp.right != null){
               q.add(temp.right);
            }
         } else{
//            System.out.println("Initial");
//            System.out.println(in);
//            System.out.println(ans);
            ans.add(new ArrayList<>(in));
//            System.out.println("After...");
//            System.out.println(ans);
            in.clear();
//            System.out.println("clear"+in);
            if(!q.isEmpty()){
               q.add(null);
            }
         }
      }
      return ans;
   }

   public static void main(String[] args) {
      TreeNode r = new TreeNode(3);
      r.left = new TreeNode(9);
      r.right = new TreeNode(20);

      r.right.left = new TreeNode(15);
      r.right.right = new TreeNode(7);
//      System.out.println(r);
//      System.out.println(lvlOrder(r));
      System.out.println(levelOrder(r));

   }
}
