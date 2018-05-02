package codeforces.contests901_1000.problemset976;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class NestedSegments implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Segment> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Segment(i + 1, in.ni(), in.ni()));
        }
        list.sort(Comparator.naturalOrder());
        int x = -1, y = -1;
        for (int i = 1; i < n; i++) {
            Segment previous = list.get(i - 1), current = list.get(i);
            if (current.within(previous)) {
                x = current.idx;
                y = previous.idx;
                break;
            }
        }
        out.printf("%d %d\n", x, y);
    }
    
    private class Segment implements Comparable<Segment> {
        private int idx, left, right;

        private Segment(int idx, int left, int right) {
            this.idx = idx;
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public int getSize() {
            return right - left;
        }
        
        private boolean within(Segment other) {
            return this.left >= other.left && this.right <= other.right;
        }

        @Override
        public String toString() {
            return left + " " + right;
        }

        @Override
        public int compareTo(Segment o) {
            int x = Integer.compare(this.getLeft(), o.getLeft()), y = -Integer.compare(this.getSize(), o.getSize());
            return x != 0 ? x : y;
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
        try (NestedSegments instance = new NestedSegments()) {
            instance.solve();
        }
    }
}
