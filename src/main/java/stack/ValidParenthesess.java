package stack;

import java.util.Stack;

public class ValidParenthesess {
    public static void main(String[] args) {
        System.out.println(new ValidParenthesess().isValid("{()}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else{
                if(stack.isEmpty()){
                    return false;
                }
                Character character = stack.pop();
                if (character == '(' && c != ')') {
                    return false;
                } else if (character == '[' && c != ']') {
                    return false;
                } else if (character == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
