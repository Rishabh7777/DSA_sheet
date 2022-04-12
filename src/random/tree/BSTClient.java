package random.tree;

public class BSTClient {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(20);
        bst.insert(11);
        bst.insert(28);
        bst.insert(5);
        bst.insert(1);
        bst.insert(8);
        bst.insert(18);
        bst.insert(14);
        bst.insert(12);
        bst.insert(13);
        bst.insert(16);
        bst.insert(25);
        bst.insert(30);
        bst.inOrderDisplay();

        bst.delete(11);
    }
}
