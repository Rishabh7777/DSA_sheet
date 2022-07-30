package sheet.binary_search_tree;

public class Problem3 {
    //the leftmost node in a BST is the minimum node
    public static int minValue(Node node) {
        if(node == null) {
            return -1;
        }
        Node curr = node;
        while(curr.left != null) {
            curr = curr.left;
        }
        return curr.data;
    }
}
