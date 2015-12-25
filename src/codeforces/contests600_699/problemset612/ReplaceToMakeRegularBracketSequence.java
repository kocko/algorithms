package codeforces.contests600_699.problemset612;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ReplaceToMakeRegularBracketSequence {

    static Map<Character, Character> match = new HashMap<Character, Character>() {{
        put('(', ')');
        put(')', '(');
        put('<', '>');
        put('>', '<');
        put('{', '}');
        put('}', '{');
        put(']', '[');
        put('[', ']');
    }};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] x = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (char c : x) {
            boolean isOpening = isOpening(c);
            if (stack.isEmpty()) {
                if (isOpening) {
                    stack.push(c);
                } else {
                    System.out.println("Impossible");
                    return;
                }
            } else {
                char matching = match.get(c);
                char last = stack.peek();
                if (!isOpening) {
                    if (last != matching) {
                        result++;
                    }
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println(result);
        } else {
            System.out.println("Impossible");
        }
        sc.close();
    }

    static boolean isOpening(char c) {
        return c == '(' || c == '<' || c == '{' || c == '[';
    }
}
