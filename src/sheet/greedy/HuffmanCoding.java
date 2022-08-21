package sheet.greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCoding {
    static class HuffmanNode {
        int data;
        char c;
        HuffmanNode left, right;
        public HuffmanNode(int data, char c) {
            this.data = data;
            this.c = c;
            left = right = null;
        }
    }

    static class SortByData implements Comparator<HuffmanNode> {
        @Override
        public int compare(HuffmanNode o1, HuffmanNode o2) {
            return o1.data - o2.data;
        }
    }

    private static void countChars(String str, HashMap<Character, Integer> map) {
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
    }

    private static void getHuffmanCodes(HuffmanNode root, String s, HashMap<Character, String> map) {
        if(root.left == null && root.right == null) {
            System.out.println(root.c + " -> " + s);
            map.put(root.c, s);
            return;
        }
        getHuffmanCodes(root.left, s + "0", map);
        getHuffmanCodes(root.right, s + "1", map);
    }

    private static String codeMessage(String str, HashMap<Character, String> map) {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            res.append(map.get(str.charAt(i)));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "bcabcbddaeccbbaeddcc";
        HashMap<Character, Integer> map = new HashMap<>();
        countChars(str, map);
        //make node of each element in map
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new SortByData());
        for (Map.Entry<Character, Integer> mapElement : map.entrySet()) {
            char key = mapElement.getKey();
            int value = mapElement.getValue();
            pq.add(new HuffmanNode(value, key));
        }
        //pick two nodes at a time and generate Huffman Tree
        HuffmanNode root = null;
        while(pq.size() > 1) {
            HuffmanNode one = pq.poll(); //O(log(n))
            HuffmanNode two = pq.poll();
            root = new HuffmanNode((one.data + two.data), '-');
            root.left = one;
            root.right = two;
            pq.add(root);
        }
        HashMap<Character, String> codeMap = new HashMap<>();
        getHuffmanCodes(root, "", codeMap);
        System.out.println(codeMessage(str, codeMap));
    } //O(n * log(n))
}
