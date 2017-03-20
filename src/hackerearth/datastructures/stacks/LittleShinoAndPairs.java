package hackerearth.datastructures.stacks;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.StrictMath.max;
import static java.lang.StrictMath.min;

public class LittleShinoAndPairs implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    private class Pair {
        private int a, b;
        
        private Pair(int x, int y) {
            this.a = max(x, y);
            this.b = min(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) return false;
            else {
                Pair cast = (Pair) obj;
                return this.a == cast.a && this.b == cast.b;
            }
        }
    }

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        Stack<Integer> stack = new Stack<>();
        Set<Pair> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int current = x[i];
            while (!stack.isEmpty()) {
                result.add(new Pair(current, stack.peek()));
                if (current > stack.peek()) {
                    stack.pop();
                } else break;
            }
            stack.add(current);
        }
        out.println(result.size());
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
        try (LittleShinoAndPairs instance = new LittleShinoAndPairs()) {
            instance.solve();
        }
    }
}
