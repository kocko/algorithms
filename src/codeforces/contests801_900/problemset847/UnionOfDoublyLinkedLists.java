package codeforces.contests801_900.problemset847;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UnionOfDoublyLinkedLists implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] next = new int[n + 1];
        int[] prev = new int[n + 1];
        List<Integer> start = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int left = in.ni(), right = in.ni();
            if (left == 0) start.add(i);
            next[i] = right;
            prev[i] = left;
        }
        int lastTail = -1;
        for (int head : start) {
            if (lastTail != -1) {
                next[lastTail] = head;
                prev[head] = lastTail;
            }
            while (next[head] != 0) {
                head = next[head];
            }
            lastTail = head;
        }
        for (int i = 1; i <= n; i++) {
            out.println(prev[i] + " " + next[i]);
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
        try (UnionOfDoublyLinkedLists instance = new UnionOfDoublyLinkedLists()) {
            instance.solve();
        }
    }
}
