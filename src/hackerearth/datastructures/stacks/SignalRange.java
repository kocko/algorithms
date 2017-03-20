package hackerearth.datastructures.stacks;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class SignalRange implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Tower {
        private int height, idx;
        
        private Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public void solve() {
        int tests = in.ni();
        while (tests-- > 0) {
            int n = in.ni();
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                x[i] = in.ni();
            }
            int[] result = new int[n];
            result[0] = 1;
            Stack<Tower> maximum = new Stack<>();
            maximum.add(new Tower(x[0], 0));
            for (int i = 1; i < n; i++) {
                int current = x[i];
                int idx = -1;
                while (!maximum.isEmpty()) {
                    Tower top = maximum.peek();
                    if (top.height <= current) {
                        maximum.pop();
                    } else {
                        idx = top.idx;
                        break;
                    }
                }
                result[i] = i - idx;
                maximum.add(new Tower(current, i));
            }
            for (int i : result) {
                out.print(i);
                out.print(' ');
            }
            out.println();
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
        try (SignalRange instance = new SignalRange()) {
            instance.solve();
        }
    }
}
