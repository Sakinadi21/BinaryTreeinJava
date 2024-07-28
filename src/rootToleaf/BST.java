package rootToleaf;
import java.util.ArrayList;
import java.util.List;
public class BST {
    // Nested static class for defining a Node in the BST
        static class Node {
            int data;   // Value of the node
            Node left;  // Left child
            Node right; // Right child

            // Constructor to create a new Node with given data
            Node(int data) {
                this.data = data;
            }
        }

        // Method to insert a value into the BST
        public static Node insert(Node root, int val) {
            if (root == null) {  // If the tree is empty, create a new node as the root
                root = new Node(val);
                return root;
            }
            if (root.data > val) {  // If the value is less than the root's data, insert it into the left subtree
                root.left = insert(root.left, val);
            } else {  // If the value is greater than or equal to the root's data, insert it into the right subtree
                root.right = insert(root.right, val);
            }
            return root;  // Return the root of the subtree
        }

        // Method to perform an inorder traversal of the BST
        public static void inorder(Node root) {
            if (root == null)  // Base case: if the node is null, return
                return;
            inorder(root.left);  // Recursively traverse the left subtree
            System.out.print(root.data + " ");  // Visit the root node
            inorder(root.right);  // Recursively traverse the right subtree
        }

        // Method to print all root-to-leaf paths
        public static void printRootToLeafPaths(Node root) {
            List<Integer> path = new ArrayList<>();  // Create a list to store the current path
            printPaths(root, path);  // Call the helper method to print paths
        }

        // Helper method to print root-to-leaf paths
        private static void printPaths(Node root, List<Integer> path) {
            if (root == null) {  // If the node is null, return
                return;
            }

            path.add(root.data);  // Add the current node's data to the path list

            if (root.left == null && root.right == null) {  // If the current node is a leaf
                System.out.println(path);  // Print the current path
            } else {
                // Recursively print paths for the left and right subtrees
                printPaths(root.left, new ArrayList<>(path));  // Copy path to avoid shared reference
                printPaths(root.right, new ArrayList<>(path));  // Copy path to avoid shared reference
            }

            path.remove(path.size() - 1);  // Remove the current node's data from the path list (backtrack)
        }

        // Main method to test the BST implementation
        public static void main(String[] args) {
            int values[] = {5, 1, 3, 4, 2, 7};  // Array of values to be inserted into the BST
            Node root = null;  // Initialize the root of the BST to null

            for (int i = 0; i < values.length; i++) {  // Loop through each value in the array
                root = insert(root, values[i]);  // Insert the value into the BST
            }

            inorder(root);  // Perform an inorder traversal of the BST and print the values
            System.out.println();  // Print a newline for better readability

            printRootToLeafPaths(root);  // Print all root-to-leaf paths in the BST
        }
    }


