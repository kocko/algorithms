package hackerrank.datastructures.stacks;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BalancedBrackets implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        out: while (n-- > 0) {
            char[] next = in.next().toCharArray();
            Stack<Character> stack = new Stack<>();
            for (char c : next) {
                if (isOpening(c)) {
                    stack.add(c);
                } else {
                    if (stack.isEmpty()) {
                        out.println("NO");
                        continue out;
                    } else {
                        Character top = stack.pop();
                        if (!match(top, c)) {
                            out.println("NO");
                            continue out;
                        }
                    }
                }
            }
            if (stack.isEmpty()) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
    }
    
    private boolean match(char a, char b) {
        return (a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']');
    }
    
    private boolean isOpening(char c) {
        return "{[(".indexOf(c) != -1;
    }

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int ni() {
            return Integer.parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (BalancedBrackets instance = new BalancedBrackets()) {
            instance.solve();
        }
    }
}
