package postorder; // Package declaration

public class BinaryTreesYT { // Main class

    // Define the Node class representing each node in the binary tree
    static class Node {
        int data;   // Data stored in the node
        Node left;  // Reference to the left child node
        Node right; // Reference to the right child node

        // Constructor to initialize the node's data and child references
        Node(int data) {
            this.data = data;   // Assign the provided data to the node
            this.left = null;   // Initialize the left child as null
            this.right = null;  // Initialize the right child as null
        }
    }

    // Define the BinaryTree class containing methods to build and manipulate the tree
    static class BinaryTree {
        static int idx = -1; // Static variable to keep track of the current index in the nodes array

        // Method to build the binary tree from an array of node values
        public static Node buildTree(int nodes[]) {
            idx++; // Increment the index to process the next value in the array

            // Base case: if the current value is -1, return null (indicating no node here)
            if (nodes[idx] == -1) {
                return null;
            }

            // Create a new node with the current value
            Node newNode = new Node(nodes[idx]);

            // Recursively build the left and right subtrees
            newNode.left = buildTree(nodes);  // Build the left subtree
            newNode.right = buildTree(nodes); // Build the right subtree

            // Return the constructed node
            return newNode;
        }
    }

    // Method to perform post-order traversal of the binary tree
    public static void postorder(Node root) {
        if (root == null) { // Base case: if the node is null, return
            return;
        }

        // Recursively traverse the left subtree
        postorder(root.left);

        // Recursively traverse the right subtree
        postorder(root.right);

        // Print the data of the node
        System.out.print(root.data + " ");
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Array representing the nodes of the binary tree in pre-order traversal
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        // Create a new instance of the BinaryTree class
        BinaryTree tree = new BinaryTree();

        // Build the tree using the provided array and get the root node
        Node root = tree.buildTree(nodes);

        // Perform post-order traversal and print the nodes
        postorder(root);
    }
}
