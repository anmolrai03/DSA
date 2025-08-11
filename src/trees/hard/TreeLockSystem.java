package trees.hard;

import java.util.*;

class TreeLockSystem {
   class Node {
      String name;
      Node parent;
      List<Node> children;
      String lockedBy;
      int lockedDescendantCount; // Count of locked descendants

      Node(String name) {
         this.name = name;
         this.children = new ArrayList<>();
         this.lockedBy = null;
         this.lockedDescendantCount = 0;
      }
   }

   private Map<String, Node> nodeMap;

   public TreeLockSystem() {
      this.nodeMap = new HashMap<>();
   }

   // Build the tree structure (assuming this is called to set up the tree)
   public void addNode(String name, String parentName) {
      Node node = new Node(name);
      nodeMap.put(name, node);

      if (parentName != null) {
         Node parent = nodeMap.get(parentName);
         node.parent = parent;
         parent.children.add(node);
      }
   }

   // Lock operation
   public boolean lock(String name, String uid) {
      Node node = nodeMap.get(name);
      if (node == null) return false;

      // Check if node is already locked
      if (node.lockedBy != null) return false;

      // Check if any ancestor is locked
      if (hasLockedAncestor(node)) return false;

      // Check if any descendant is locked
      if (node.lockedDescendantCount > 0) return false;

      // Lock the node
      node.lockedBy = uid;

      // Update locked descendant count for all ancestors
      updateAncestorsLockedCount(node, 1);

      return true;
   }

   // Unlock operation
   public boolean unlock(String name, String uid) {
      Node node = nodeMap.get(name);
      if (node == null) return false;

      // Check if node is locked by the same user
      if (!uid.equals(node.lockedBy)) return false;

      // Unlock the node
      node.lockedBy = null;

      // Update locked descendant count for all ancestors
      updateAncestorsLockedCount(node, -1);

      return true;
   }

   // Upgrade lock operation
   public boolean upgradeLock(String name, String uid) {
      Node node = nodeMap.get(name);
      if (node == null) return false;

      // Check if node is already locked
      if (node.lockedBy != null) return false;

      // Check if there are any locked descendants
      if (node.lockedDescendantCount == 0) return false;

      // Check if all locked descendants are locked by this user
      if (!checkAllDescendantsLockedByUser(node, uid)) return false;

      // Unlock all descendants locked by this user
      unlockAllDescendants(node, uid);

      // Now lock this node
      node.lockedBy = uid;

      // Since we've unlocked all descendants, we need to adjust counts
      // The lockedDescendantCount for this node is now 0
      // But we need to update ancestors' counts
      int delta = 1 - node.lockedDescendantCount;
      updateAncestorsLockedCount(node, delta);

      return true;
   }

   // Helper methods
   private boolean hasLockedAncestor(Node node) {
      Node current = node.parent;
      while (current != null) {
         if (current.lockedBy != null) return true;
         current = current.parent;
      }
      return false;
   }

   private void updateAncestorsLockedCount(Node node, int delta) {
      Node current = node.parent;
      while (current != null) {
         current.lockedDescendantCount += delta;
         current = current.parent;
      }
   }

   private boolean checkAllDescendantsLockedByUser(Node node, String uid) {
      for (Node child : node.children) {
         if (child.lockedBy != null && !child.lockedBy.equals(uid)) {
            return false;
         }
         if (!checkAllDescendantsLockedByUser(child, uid)) {
            return false;
         }
      }
      return true;
   }

   private void unlockAllDescendants(Node node, String uid) {
      for (Node child : node.children) {
         if (child.lockedBy != null && child.lockedBy.equals(uid)) {
            child.lockedBy = null;
            child.lockedDescendantCount = 0; // Since we're unlocking all descendants
         }
         unlockAllDescendants(child, uid);
      }
   }

   public static void main(String[] args) {
      TreeLockSystem tree = new TreeLockSystem();

      // Build the tree
      tree.addNode("Global", null); // Root
      tree.addNode("Europe", "Global");
      tree.addNode("Asia", "Global");
      tree.addNode("France", "Europe");
      tree.addNode("Germany", "Europe");
      tree.addNode("India", "Asia");
      tree.addNode("China", "Asia");

      // Test operations
      System.out.println(tree.lock("France", "user1")); // true
      System.out.println(tree.lock("Europe", "user2")); // false (France is locked)
      System.out.println(tree.upgradeLock("Europe", "user1")); // true
      System.out.println(tree.unlock("Europe", "user1")); // true
   }
}