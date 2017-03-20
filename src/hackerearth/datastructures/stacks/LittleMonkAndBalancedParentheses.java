package hackerearth.datastructures.stacks;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class LittleMonkAndBalancedParentheses implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        Stack<Integer> stack = new Stack<>();
        int max = 0, previous = 0, local = 0;
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            if (stack.isEmpty()) {
                int total = local + previous;
                max = Math.max(total, max);
                previous = total;
                local = 0; 
                if (next < 0) {
                    previous = 0;
                    continue;
                }
            }
            if (next > 0) {
                stack.add(next);
            } else {
                if (next + stack.peek() == 0) {
                    local += 2;
                    stack.pop();
                } else {
                    stack.clear();
                }
            }
        }
        if (stack.isEmpty()) {
            out.println(Math.max(local + previous, max));
        } else {
            out.println(Math.max(local, max));
        }
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
        try (LittleMonkAndBalancedParentheses instance = new LittleMonkAndBalancedParentheses()) {
            instance.solve();
        }
    }
}
