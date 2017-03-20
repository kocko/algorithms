package hackerearth.datastructures.stacks;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class MonkAndPrisonerOfAzkaban implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Value {
        private long value;
        private int idx;
        private Value(long value, int idx) { 
            this.value = value;
            this.idx = idx;
        }
    }

    public void solve() {
        int n = in.ni();
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nl();
        }
        int[] result = new int[n + 1];
        Stack<Value> left = new Stack<>();
        for (int i = 1; i <= n; i++) {
            long current = a[i];
            if (left.isEmpty()) {
                left.add(new Value(current, i));
                result[i] += -1;
            } else if (left.peek().value > current) {
                result[i] += left.peek().idx;
                left.add(new Value(current, i));
            } else {
                while (!left.isEmpty() && left.peek().value <= current) {
                    left.pop();
                }
                if (left.isEmpty()) {
                    result[i] += -1;
                } else {
                    result[i] += left.peek().idx;
                }
                left.add(new Value(current, i));
            }
        }

        Stack<Value> right = new Stack<>();
        for (int i = n; i > 0; i--) {
            long current = a[i];
            if (right.isEmpty()) {
                right.add(new Value(current, i));
                result[i] += -1;
            } else if (right.peek().value > current) {
                result[i] += right.peek().idx;
                right.add(new Value(current, i));
            } else {
                while (!right.isEmpty() && right.peek().value <= current) {
                    right.pop();
                }
                if (right.isEmpty()) {
                    result[i] += -1;
                } else {
                    result[i] += right.peek().idx;
                }
                right.add(new Value(current, i));
            }
        }
        for (int i = 1; i <= n; i++) {
            out.print(result[i]);
            out.print(' ');
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
        try (MonkAndPrisonerOfAzkaban instance = new MonkAndPrisonerOfAzkaban()) {
            instance.solve();
        }
    }
}
