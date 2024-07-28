package delete;

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

    // Method to search for a value in the BST
    public static boolean search(Node root, int key) {
        if (root == null) {  // If the node is null, the key is not found
            return false;
        }
        if (root.data > key) {  // If the key is less than the root's data, search in the left subtree
            return search(root.left, key);
        } else if (root.data == key) {  // If the key is equal to the root's data, the key is found
            return true;
        } else {  // If the key is greater than the root's data, search in the right subtree
            return search(root.right, key);
        }
    }

    // Method to delete a value from the BST
    public static Node delete(Node root, int val) {
        if (root == null) {  // If the node is null, return null
            return null;
        }

        if (root.data > val) {  // If the value to be deleted is less than the root's data, delete from the left subtree
            root.left = delete(root.left, val);
        } else if (root.data < val) {  // If the value to be deleted is greater than the root's data, delete from the right subtree
            root.right = delete(root.right, val);
        } else {  // If the value to be deleted is found
            // Case 1: Node has no children (it is a leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: Node has only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Node has two children
            Node IS = inorderSuccessor(root.right);  // Find the inorder successor
            root.data = IS.data;  // Replace the data of the node to be deleted with the inorder successor's data
            root.right = delete(root.right, IS.data);  // Delete the inorder successor
        }
        return root;  // Return the root of the subtree
    }

    // Method to find the inorder successor (smallest value in the right subtree)
    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {  // Keep going left until the leftmost node is found
            root = root.left;
        }
        return root;  // Return the leftmost node
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

        delete(root, 4);  // Delete the node with value 4
        inorder(root);  // Perform an inorder traversal again to show the updated tree
    }
}
