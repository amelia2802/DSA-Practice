/*
 * Print the nodes in a binary tree level-wise.
 * For example, the following should print 1, 2, 3, 4, 5.
            1
            / \
            2   3
            / \
            4   5

    @author Microsoft

    T.C:O(n)
    S.C:O(n)

    ```Topic: Tree, BFS```
 */
import java.util.*;
class Node{
        int data;
        Node left,right;

        Node(int data){
                this.data = data;
                left = null;
                right = null;
        }
}

public class LevelOrderTraverse{
        Node root;

        static void levelOrder(Node root){
                List<List<Integer>> result = new ArrayList<>();

                Queue<Node> q = new LinkedList<>();
                q.add(root);

                while(!q.isEmpty()){
                        List<Integer> level = new ArrayList<>();
                        for(int i=q.size();i>0;i--){
                                Node node = q.poll();
                                if(node!=null){
                                        level.add(node.data);
                                        q.add(node.left);
                                        q.add(node.right);
                                }
                        }

                        if(level.size()>0){
                                result.add(level);
                        }
                }

                System.out.println(result);

        }
        public static void main(String[] args) {
                LevelOrderTraverse tree = new LevelOrderTraverse();

                tree.root = new Node(1);
                tree.root.left = new Node(2);
                tree.root.right = new Node(3);
                tree.root.left.left = new Node(4);
                tree.root.left.right = new Node(5);

                levelOrder(tree.root);
        }
}