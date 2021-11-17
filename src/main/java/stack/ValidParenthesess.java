package stack;

public class ValidParenthesess {

    public static void main(String[] args) {
        ValidParenthesess solution = new ValidParenthesess();
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("([)]"));

    }

    public boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<>();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
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
