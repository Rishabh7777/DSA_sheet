package sheet.binary_tree;

import java.util.HashMap;

public class Problem29 {
    private static HashMap<Node, Integer> map;

    private static int getSumOfGrandChildren(Node root) {
        int sum = 0;
        if(root.left != null) {
            sum += getMaxSum(root.left.left) + getMaxSum(root.left.right);
        }
        if(root.right != null) {
            sum += getMaxSum(root.right.left) + getMaxSum(root.right.right);
        }
        return sum;
    }

    public static int getMaxSum(Node root) {
        if(root == null) {
            return 0;
        }
        if(map.containsKey(root)) {
            return map.get(root);
        }
        //if current node is included in overall sum
        int inc = root.data + getSumOfGrandChildren(root);
        //on excluding the current node from overall sum
        int exc = getMaxSum(root.left) + getMaxSum(root.right);
        //update map
        map.put(root, Math.max(inc, exc));
        return map.get(root);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left = new Node(1);
        map = new HashMap<>();
        System.out.println(getMaxSum(root));

        root= new Node(10);
        root.left= new Node(1);
        root.left.left= new Node(2);
        root.left.left.left= new Node(1);
        root.left.right= new Node(3);
        root.left.right.left= new Node(4);
        root.left.right.right= new Node(5);
        map = new HashMap<>();
        System.out.println(getMaxSum(root));
    }
}
