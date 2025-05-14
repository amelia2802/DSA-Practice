/**
 * A unival tree (which stands for "universal value") is a tree where all nodes under it have the same value.
 * Given the root to a binary tree, count the number of unival subtrees.
 * For example, the following tree has 5 unival subtrees:
 *  0
  / \
 1   0
    / \
   1   0
  / \
 1   1

 @author Google

 T.C:O(n)
 S.C:O(h): The space complexity is determined by the recursion stack, which depends on the height h of the tree. In the worst case (skewed tree), h = n. In the best case (balanced tree), h = log(n).

 Topic:Binary Trees, Recursion
 */

class CountUnivalSub {

    // Definition for a binary tree node
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // Main function to count unival subtrees
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1]; // Use an array to store the count (mutable in recursion)
        isUnival(root, count);
        return count[0];
    }

    // Helper function to check if a subtree is unival
    private boolean isUnival(TreeNode node, int[] count) {
        if (node == null) {
            return true; // A null node is unival
        }

        // Recursively check left and right subtrees
        boolean leftUnival = isUnival(node.left, count);
        boolean rightUnival = isUnival(node.right, count);

        // Check if the current node is unival
        if (leftUnival && rightUnival) {
            if (node.left != null && node.left.val != node.val) {
                return false;
            }
            if (node.right != null && node.right.val != node.val) {
                return false;
            }
            // Current node is unival
            count[0]++;
            return true;
        }

        return false; // Not unival
    }

    public static void main(String[] args) {
        CountUnivalSub solution = new CountUnivalSub();

        // Example tree:
        //      0
        //     / \
        //    1   0
        //       / \
        //      1   0
        //     / \
        //    1   1
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);

        System.out.println("Number of unival subtrees: " + solution.countUnivalSubtrees(root)); // Output: 5
    }
}
