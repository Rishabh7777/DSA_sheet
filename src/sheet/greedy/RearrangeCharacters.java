package sheet.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class RearrangeCharacters {
    private static class Pair {
        char c;
        int count;
        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    private static class CompareByCount implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o2.count - o1.count;
        }
    }

    public static String rearrangeCharacters(String str) {
        // count the number of total occurrences of each char
        int[] charCount = new int[26];
        for(int i=0; i<str.length(); i++) {
            charCount[str.charAt(i) - 97]++;
        }

        // insert each char with count into PQ, such that char with the highest count is on top
        PriorityQueue<Pair> pq = new PriorityQueue<>(new CompareByCount());
        for(int i=0; i<26; i++) {
            if(charCount[i] != 0) {
                Pair pair = new Pair((char) (i + 97), charCount[i]);
                pq.add(pair);
            }
        }

        StringBuilder sb = new StringBuilder();
        Pair temp = null;
        // pick front from pq (has the highest count), add that char to sb and remove it from pq temporarily
        while(!pq.isEmpty()) {
            Pair top = pq.poll();
            sb.append(top.c);
            top.count--;
            if(temp != null) {
                pq.add(temp);
                temp = null;
            }
            if(top.count > 0) {
                temp = top;
            }
        }

        if(temp != null) {
            return "-1";
        }
        return sb.toString();
    } // O(n * log(n))

    public static void main(String[] args) {
        String str = "bbbb";
        System.out.println(rearrangeCharacters(str));

        str = "geeksforgeeks";
        System.out.println(rearrangeCharacters(str));
    }
}
