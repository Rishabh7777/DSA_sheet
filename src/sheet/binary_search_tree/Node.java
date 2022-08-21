package sheet.binary_search_tree;

public class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String toString() {
        return "data = " + this.data;
    }
}
