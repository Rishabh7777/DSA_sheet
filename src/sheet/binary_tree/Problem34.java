package sheet.binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem34 {
    private static List<Node> resList;
    private static HashMap<String, Integer> map;

    private static String helper(Node root) {
        //if left or right node is null, it is still a sub-tree
        if(root == null) {
            return "$";
        }
        String left = helper(root.left);
        String right = helper(root.right);
        String str = left + root.data + right;
        //if current sub-tree is first duplicate found
        if(map.containsKey(str) && map.get(str) == 1) {
            resList.add(root);
        }
        //add current str to map
        map.put(str, map.getOrDefault(str, 0) + 1);
        return str;
    }

    public List<Node> printAllDuplicates(Node root) {
        resList = new ArrayList<>();
        map = new HashMap<>();
        helper(root);
        return resList;
    }
}
