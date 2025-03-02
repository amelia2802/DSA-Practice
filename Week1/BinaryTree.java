/**
 *  Basic Operations Of Tree Data Structure Dynamically created Binary Tree:
    Create – create a tree in the data structure.
    Insert − Inserts data in a tree.
    Search − Searches specific data in a tree to check whether it is present or not.
    Traversal:
    Depth-First-Search Traversal
    Breadth-First-Search Traversal
 */

import java.util.*;

class Node{
    int data;
    Node left,right;

    public Node(int data){
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinaryTree {
    static Node root;
    public static Node insert(Node root, int data){
        if(root==null){
            return new Node(data);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter L for left or R for right of "+root.data);
        char ch = sc.next().charAt(0);

        if(ch=='L' || ch=='l'){
            root.left = insert(root.left,data);
        }
        else{
            root.right = insert(root.right,data);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" -> ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter the total number of nodes:");
            int n = sc.nextInt();    
    
            System.out.println("Enter the root node value:");
            int value = sc.nextInt();
            root = new Node(value);
    
            for(int i = 1; i < n; i++) {
                System.out.println("Enter value for node " + (i + 1) + " :");
                int data = sc.nextInt();
                insert(root, data);
            }
    
            System.out.println("Inorder Traversal:");
            inorder(root);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
        } finally {
            sc.close();
        }
    }
}
