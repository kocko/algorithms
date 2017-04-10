package codeforces.contests401_500.problemset450;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class JzzhuAndChildren implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        class Child {
            private int idx, has, wants;
            private Child(int idx, int wants) {
                this.idx = idx;
                this.wants = wants;
            }
        }
        int n = in.ni(), m = in.ni();
        ArrayDeque<Child> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(new Child(i, in.ni()));
        }
        Child last = null;
        while (!queue.isEmpty()) {
            Child child = queue.pollFirst();
            child.has += m;
            if (child.has < child.wants) {
                queue.offer(child);
            }
            last = child;
        }
        out.println(last.idx);
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
        try (JzzhuAndChildren instance = new JzzhuAndChildren()) {
            instance.solve();
        }
    }
}
