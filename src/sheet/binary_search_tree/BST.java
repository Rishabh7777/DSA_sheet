package sheet.binary_search_tree;

public class BST {
    //for balanced BST h = log(n)
    public boolean search(Node root, int key) {
        //-ve base case -> key not found
        if(root == null) {
            return false;
        }
        //+ve base case -> key found
        if(key == root.data) {
            return true;
        }
        //search in left sub-tree
        if(key < root.data) {
            return search(root.left, key);
        }
        //search in right sub-tree
        return search(root.right, key);
    } //O(h) -> O(n) for skewed BST

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        }
        if(data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    } //O(h) -> O(n) for skewed BST

    //in-order of BST always gives sorted output i.e. all nodes will be in sorted order in result
    public static void printInOrder(Node root) {
        if(root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = insert(null, 5);
        root = insert(root, 3);
        root = insert(root, 11);
        printInOrder(root);
    }
}
