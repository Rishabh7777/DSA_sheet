package sheet.stack_and_queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstNonRepeatingInStream {
    public String FirstNonRepeating(String A) {
        Queue<Character> q = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();

        q.add(A.charAt(0));
        map.put(A.charAt(0), 1);

        StringBuilder res = new StringBuilder();

        for(int i=1; i<A.length(); i++) {
            if(!q.isEmpty()) {
                res.append(q.peek());
            } else {
                res.append("#");
            }

            map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);
            if(map.get(A.charAt(i)) <= 1) {
                q.add(A.charAt(i));
            }

            while(!q.isEmpty() && map.get(q.peek()) > 1) {
                q.remove();
            }
        }

        // append for the last char
        if(!q.isEmpty()) {
            res.append(q.peek());
        } else {
            res.append("#");
        }

        return res.toString();
    }
}
