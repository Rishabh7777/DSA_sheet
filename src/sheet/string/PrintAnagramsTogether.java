package sheet.string;

import java.util.*;

//given a list of strings
//need to group all the anagrams together and print them
//two words are anagrams if they consist of same set of characters
public class PrintAnagramsTogether {
    private List<List<String>> Anagrams(String[] stringArr) {
        Map<String, List<Integer>> map = new HashMap<>(); //to store indices of anagrams like word -> []

        //sort each word in string array and get a list of indices mapped to each sorted word
        for(int i=0; i<stringArr.length; i++) {
            String word = stringArr[i];
            //sort the word
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            word = Arrays.toString(arr);
            //dgo -> [1,3]
            List<Integer> idxList = map.getOrDefault(word, new ArrayList<>());
            idxList.add(i);
            map.put(word, idxList);
        }
        //we have an original string array as it is
        //and a map of sorted words from array pointing to a list of indices of anagrams

        //traverse the map and form the resulting list
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry element: map.entrySet()) {
            List<Integer> idxList = (List<Integer>) element.getValue();
            List<String> same = new ArrayList<>();
            for(int i: idxList) {
                same.add(stringArr[i]);
            }
            res.add(same);
        }

        return res;
    }
}
