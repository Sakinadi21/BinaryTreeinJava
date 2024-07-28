package inorder;

    public class BinaryTreesYT {
        // Define the Node class representing each node in the binary tree
        static class Node {
            int data;   // Data stored in the node
            Node left;  // Reference to the left child node
            Node right; // Reference to the right child node

            // Constructor to initialize the node's data and child references
            Node(int data) {
                this.data = data;
                this.left = null;
                this.right = null;
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
                newNode.left = buildTree(nodes);
                newNode.right = buildTree(nodes);

                // Return the constructed node
                return newNode;
            }
        }

        // Method to perform pre-order traversal of the binary tree
        public static void inorder(Node root) {
            if (root == null) {
                return; // Base case: if the node is null, return
            }


            // Recursively traverse the left subtree
            inorder(root.left);
// Print the data of the node
            System.out.print(root.data + " ");

            // Recursively traverse the right subtree
            inorder(root.right);
        }

        // Main method to run the program
        public static void main(String[] args) {
            // Array representing the nodes of the binary tree in pre-order traversal
            int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

            // Create a new instance of the BinaryTree class
            BinaryTree tree = new BinaryTree();

            // Build the tree using the provided array and get the root node
            Node root = tree.buildTree(nodes);

            // Perform pre-order traversal and print the nodes
            inorder(root);
        }
    }

