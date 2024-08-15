import java.util.Stack;

public class StringReverse {
    public static String reverse(String str) {
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            stack.push(c);
        }

        for (int i = 0; i < str.length(); i++) {
            chars[i] = stack.pop();
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverse("ABCE"));
    }
}
