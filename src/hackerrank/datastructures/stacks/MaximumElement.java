package hackerrank.datastructures.stacks;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class MaximumElement implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    private Stack<Integer> stack = new Stack<>();
    private int[] heap;

    public void solve() {
        int n = in.ni();
        heap = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int command = in.ni();
            switch (command) {
                case 1:
                    push();
                    break;
                case 2:
                    pop();
                    break;
                case 3:
//                    printMaximum();
                    break;
            }
        }
    }

    private void push() {
        int n = in.ni();
        stack.push(n);

    }

    private void pop() {
        int top = stack.peek();
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

    public static void main(String[] args) {
        new MaximumElement().solve();
    }
}
