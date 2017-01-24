package hackerrank.datastructures.stacks;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class AndXorOr implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                result = Math.max(a(x[i], top) ^ b(x[i], top), result);
                if (x[i] < top) {
                    stack.pop();
                } else break;
            }
            stack.push(x[i]);
        }
        out.println(result);
    }
    
    private int a(int m, int n) {
        return m & n;
    }
    
    private int b(int m, int n) {
        return m | n;
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
        try (AndXorOr instance = new AndXorOr()) {
            instance.solve();
        }
    }
}
