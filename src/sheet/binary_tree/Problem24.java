package sheet.binary_tree;

import java.util.HashSet;

public class Problem24 {
    private static HashSet<String> set;

    private static String helper(Node root) {
        //if left or right node is null, it is still a sub-tree
        if(root == null) {
            return "$";
        }
        //for leaf nodes as they are not considered as sub-trees
        if(root.left == null && root.right == null) {
            return Integer.toString(root.data);
        }
        String left = helper(root.left);
        String right = helper(root.right);
        String str = left + root.data + right;
        //if some sub-tree is found as duplicate previously
        if(left.equals("same") || right.equals("same")) {
            return "same";
        }
        //if current sub-tree is duplicate
        if(str.length() >= 3 && set.contains(str)) {
            return "same";
        }
        set.add(str);
        return str;
    }

    public static int dupSub(Node root) {
        if(root == null) {
            return 0;
        }
        //to keep account of all sub-trees found so far
        //sub-trees will be stored as strings -> left + root + right
        set = new HashSet<>();
        String res = helper(root);
        if(res.equals("same")) {
            return 1;
        }
        return 0;
    }
}
