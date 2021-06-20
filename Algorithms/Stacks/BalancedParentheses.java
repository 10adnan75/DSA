import java.util.Stack;

public class BalancedParentheses {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        assert isBalanced("([]){()}");
        assert !isBalanced("([]){([}}}");

        String[] myArray = {"(){}[]", ")(}{]["};
        for (String s : myArray) {
            if (isBalanced(s)) System.out.println(s + " is Balanced!");
            else System.out.println(s + " is Imbalanced!");
        }
    }
}
/*
        OUTPUT:
        (){}[] is Balanced!
        )(}{][ is Imbalanced!
 */
