package sheet.binary_tree;

import static sheet.binary_tree.Problem7.preOrderRecursive;

//build a BT from a string input containing numbers and parenthesis
public class problem17 {
    private static int start = 0; //for traversing the input string

    public static Node constructTree(String s) {
        //if string is empty
        if(s.length() == 0) {
            return null;
        }
        //if traversed through whole string
        if(start >= s.length()) {
            return null;
        }
        //variable to check for negative numbers
        boolean neg = false;
        if(s.charAt(start) == '-') {
            neg = true;
            start++;
        }
        //get the next number to build new node
        int num = 0;
        while(start < s.length() && Character.isDigit(s.charAt(start))) {
            int digit = Character.getNumericValue(s.charAt(start));
            num = (num * 10) + digit;
            start++;
        }
        //if number is -ve
        if(neg) {
            num = -num;
        }
        Node node = new Node(num);
        //if left or right sub-trees are not possible
        if(start >= s.length()) {
            return node;
        }
        //check for open parenthesis and add the data to the left subtree recursively
        if(s.charAt(start) == '(') {
            start++;
            node.left = constructTree(s);
        }
        //when found closing parenthesis, return the sub-tree
        if(start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }
        //check for open parenthesis and add the data to the right subtree recursively
        if(start < s.length() && s.charAt(start) == '(') {
            start++;
            node.right = constructTree(s);
        }
        //when found closing parenthesis, return the sub-tree
        if(start < s.length() && s.charAt(start) == ')') {
            start++;
            return node;
        }
        return node;
    }

    public static void main(String[] args) {
        String str = "4(2(3)(1))(6(5))";
        Node root = constructTree(str);
        preOrderRecursive(root);
    }
}
