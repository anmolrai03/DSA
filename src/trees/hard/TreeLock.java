package trees.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeLock {

   class Node{
      String name;
      Node parent;
      List<Node> children;
      String lockedBy;
      int lockedDesendentCount;

      Node(String name){
         this.name = name;
         this.children = new ArrayList<>();
         this.lockedBy = null;
         this.lockedDesendentCount = 0;
      }
   }

   private Map<String , Node> mapNode;

   //initialising mapNode structure.
   public TreeLock(){
      this.mapNode = new HashMap<>();
   }

   //addNode
   public void addNode(String name , String parentName){
      //convert to lower case for standardisation.
//      if(parentName != null) {parentName = parentName.toLowerCase();}
//
//      if(name != null){
//         name = name.toLowerCase();
//      }


      Node node = new Node(name);
      mapNode.put(name , node);

      if(parentName != null){
         //get the details of parentNode via the hashmap.
         Node parent = mapNode.get(parentName);

         //put the parent Node found in the above as the parent of the current node.
         node.parent = parent;

         //add this node as a children to the parent node.
         parent.children.add(node);
      }
   }


   //lock node.
   public boolean lock(String name , String uid){

      //get the node.
      //if node is given then no need for this.
      Node node = mapNode.get(name);

//      check 1: if node do not exist return false it cannot be locked
      if(node == null) return false;

//      check 2: if the node is already locked return false it cannot be unlocked
      if(node.lockedBy != null) return false;

//      check 3: if any parent is locked return false , it cannot be locked.
      if(hasLockedAncestors(node)) return false;

      // check 4: if any desendent is locked , return false it cannot be locked.
      if(hasLockedDescendents(node)) return false;

      //all above fails , now lock it.
      node.lockedBy = uid;

      //update the lockedDescendentCount for all parent nodes.
      updateLockedDescendents(node , 1);

      return true;
   }

   public boolean unlock(String name , String uid){

      Node node = mapNode.get(name);

      //Check 1: if node is null , return false , cannot update
      if(node == null) return false;

      //Check 2: if node is already unlock, return false,
      if(node.lockedBy == null) return false;

      //Check 3: the uid is of the user who locked it
      if(!node.lockedBy.equals(uid)) return false;

      //unlock the node.
      node.lockedBy = null;

      //update the lockedDescendent count by -1.
      updateLockedDescendents(node , -1);

      return true;
   }


   //helper functions here.
   private boolean hasLockedAncestors(Node node) {
      Node current = node.parent;
      //keep traversing all the parent nodes and check
      while(current != null){
         //is the current node locked.
         if(current.lockedBy != null) return true;
         current = current.parent;
      }
      return false;
   }

   private boolean hasLockedDescendents(Node node) {
      return node.lockedDesendentCount > 0;
   }

   private void updateLockedDescendents(Node node, int i) {
      Node curr = node.parent;
      while(curr != null){
         curr.lockedDesendentCount += i;
         curr = curr.parent;
      }
   }

   public static void main(String[] args) {
      TreeLock tree = new TreeLock();

      tree.addNode("Global" , null);
      tree.addNode("Asia" , "Global");
      tree.addNode("Russia" , "Global");
      tree.addNode("India" , "Asia");

      System.out.println(tree.lock("Asia" , "user112"));
      System.out.println(tree.unlock("Asia" , "user112"));
   }
}
