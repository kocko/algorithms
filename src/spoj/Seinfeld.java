package spoj;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class Seinfeld implements Closeable {

    private Scanner in = new Scanner(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int testCase = 1;
        while (in.hasNextLine()) {
            char[] line = in.nextLine().toCharArray();
            if (line[0] == '-') break;
            Stack<Character> stack = new Stack<>();
            int result = 0;
            for (char c : line) {
                if (c == '{') {
                    stack.push(c);
                } else if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    result++;
                    stack.push('{');
                }
            }
            out.print(testCase++ + ". ");
            out.println(result + stack.size() / 2);
        }
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }
    
    public static void main(String[] args) throws IOException {
        try (Seinfeld instance = new Seinfeld()) {
            instance.solve();
        }
    }
}
