package codeforces.contests001_100.problemset005;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class LongestRegularBracketSequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int n = x.length;
        Stack<Integer> stack = new Stack<>();
        int max = 0, count = 1;
        int[] match = new int[n];
        for (int i = 0; i < n; i++) {
            if (x[i] == '(') {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                match[i] = match[stack.pop()] = 1;
            }
        }
        int current = 0;
        for (int i = 0; i < n; i++) {
            if (match[i] == 0) {
                if (current > max) {
                    max = current;
                    count = 1;
                } else if (current == max && current > 0) {
                    count++;
                }
                current = 0;
            } else {
                current++;
            }
        }
        if (current > max) {
            max = current;
            count = 1;
        } else if (current == max && current > 0) {
            count++;
        }
        out.printf("%d %d\n", max, count);
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
        try (LongestRegularBracketSequence instance = new LongestRegularBracketSequence()) {
            instance.solve();
        }
    }
}
