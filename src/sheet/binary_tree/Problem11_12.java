package sheet.binary_tree;

import java.util.*;

//top and bottom view of tree
public class Problem11_12 {
    private static class Pair {
        Node node;
        int vertLevel;
        public Pair(Node node, int vertLevel) {
            this.node = node;
            this.vertLevel = vertLevel;
        }
    }

    private static Map<Integer, List<Integer>> map;

    private static void getVerticalOrder(Node root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            Pair front = q.poll();
            Node curr = front.node;
            int vertLevel = front.vertLevel;
            List<Integer> levelList = map.getOrDefault(vertLevel, new ArrayList<>());
            levelList.add(curr.data);
            map.put(vertLevel, levelList);
            if(curr.left != null) {
                q.add(new Pair(curr.left, vertLevel-1));
            }
            if(curr.right != null) {
                q.add(new Pair(curr.right, vertLevel+1));
            }
        }
    }

    public static ArrayList<Integer> topView(Node root) {
        map = new TreeMap<>();
        getVerticalOrder(root);
        ArrayList<Integer> res = new ArrayList<>();
        for(Map.Entry el: map.entrySet()) {
            int vertLevel = (int)el.getKey();
            ArrayList<Integer> list = (ArrayList)el.getValue();
            res.add(list.get(0));
        }
        return res;
    }

    public static ArrayList<Integer> bottomView(Node root) {
        map = new TreeMap<>();
        getVerticalOrder(root);
        ArrayList<Integer> res = new ArrayList<>();
        for(Map.Entry el: map.entrySet()) {
            int vertLevel = (int)el.getKey();
            ArrayList<Integer> list = (ArrayList)el.getValue();
            res.add(list.get(list.size() - 1));
        }
        return res;
    }
}
