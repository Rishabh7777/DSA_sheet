package sheet.string;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class NoTwoAdjacentChars {
    private static String brute(String s) {
        char[] arr = s.toCharArray();
        for(int i=1; i<arr.length; i++) {
            if(arr[i] == arr[i-1]) {
                for(int j=i+1; j<arr.length; j++) {
                    if(arr[j] != arr[i-1]) {
                        //swap chars at i and j
                        char temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                        break;
                    }
                }
                if(arr[i] == arr[i-1]) {
                    return "Not possible";
                }
            }
        }
        return String.valueOf(arr);
    } //O(n^2)

    private static String sol(String s) {
        Stack<Character> st = new Stack<>();
        PriorityQueue<Character> pq = new PriorityQueue<>();
        for(int i=0; i<s.length(); i++) {
            if(st.isEmpty()) {
                st.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == st.peek()) {
                pq.add(s.charAt(i));
                continue;
            }
            st.push(s.charAt(i));
            while(!pq.isEmpty() && st.peek() != pq.peek()) {
                st.push(pq.poll());
            }
        }
        if(!pq.isEmpty()) {
            return "Not possible";
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) {
            res.insert(0, st.pop());
        }
        return res.toString();
    } //O(n)

    //optimised solution in terms of time and space complexity
    private static class Key {
        char c;
        int freq;
        Key(int freq, char c) {
            this.c = c;
            this.freq = freq;
        }
    }

    static class KeyComparator implements Comparator<Key> {
        public int compare(Key k1, Key k2) {
            if (k1.freq < k2.freq)
                return 1;
            else if (k1.freq > k2.freq)
                return -1;
            return 0;
        }
    }

    private static String rearrangeString(String str) {
        int MAX_CHAR = 26;
        int n = str.length();

        // Store frequencies of all characters in string
        int[] count = new int[MAX_CHAR];
        for (int i=0; i<n; i++) {
            count[str.charAt(i) - 'a']++;
        }

        // Insert all characters with their frequencies into a priority_queue
        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
        for (char c='a'; c<='z'; c++) {
            int val = c - 'a';
            if (count[val] > 0) {
                pq.add(new Key(count[val], c));
            }
        }

        // 'str' that will store resultant value
        str = "";

        // work as the previous visited element
        // initial previous element be. ( '#' and it's frequency '-1' )
        Key prev = new Key(-1, '#');

        // traverse queue
        StringBuilder strBuilder = new StringBuilder(str);
        while (pq.size() != 0) {
            // pop top element from queue and add it to string.
            Key k = pq.poll();
            strBuilder.append(k.c);

            // If frequency of previous character is less than zero that means it is useless,
            // we do not need to push it
            if (prev.freq > 0) {
                pq.add(prev);
            }

            // make current character as the previous 'char' and decrease frequency by 'one'
            (k.freq)--;
            prev = k;
        }
        str = strBuilder.toString();

        // If length of the resultant string and original string is not same then string is not valid
        return n == str.length() ? str : "Not possible";
    } //O(n)

    public static void main(String[] args) {
        String s = "aavv";
        System.out.println(rearrangeString(s));
    }
}
