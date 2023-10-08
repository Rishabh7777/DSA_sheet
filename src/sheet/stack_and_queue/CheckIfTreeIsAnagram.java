package sheet.stack_and_queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CheckIfTreeIsAnagram {
    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static boolean areAnagrams(Node node1, Node node2) {
        if(node1 == null && node2 == null) {
            return true;
        }
        if(node1 == null || node2 == null) {
            return false;
        }

        Queue<Node> q1 = new LinkedList<>(); // for level-order traversal on first tree
        q1.add(node1);
        Queue<Node> q2 = new LinkedList<>(); // for level-order traversal on second tree
        q2.add(node2);

        Map<Integer, Integer> map = new HashMap<>(); // to store numbers at each level with frequency

        while(!q1.isEmpty() && !q2.isEmpty()) {
            int n1 = q1.size();
            int n2 = q2.size();

            if(n1 != n2) {
                return false;
            }

            // traverse the first queue and insert its data with frequency of occurence
            // n1 will make sure that map only contains data of one level at a time
            while(n1 > 0) {
                Node front = q1.remove();
                map.put(front.data, map.getOrDefault(front.data, 0) + 1);
                n1--;
                if(front.left != null) {
                    q1.add(front.left);
                }
                if(front.right != null) {
                    q1.add(front.right);
                }
            }

            // traverse the second queue and check if its each element matches the data
            // present in the map
            while(n2 > 0) {
                Node front = q2.remove();
                if(!map.containsKey(front.data)) {
                    return false;
                }
                map.put(front.data, map.get(front.data) - 1);
                if(map.get(front.data) == 0) {
                    map.remove(front.data);
                }
                n2--;
                if(front.left != null) {
                    q2.add(front.left);
                }
                if(front.right != null) {
                    q2.add(front.right);
                }
            }

            // if nodes at one level are anagrams then map should become empty
            if(!map.isEmpty()) {
                return false;
            }
        }

        return q1.isEmpty() && q2.isEmpty();
    }
}
