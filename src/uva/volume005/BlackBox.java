package uva.volume005;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;

public class BlackBox implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int t = in.ni();
        while (t-- > 0) {
            int n = in.ni(), m = in.ni();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.ni();
            }
            int[] u = new int[m];
            for (int i = 0; i < m; i++) {
                u[i] = in.ni();
            }
            int idx = 0, next = 0;
            MyTree tree = new MyTree();
            while (idx < m) {
                while (u[idx] > tree.size()) {
                    tree.add(a[next], next++);
                }
                out.println(tree.get());
                idx++;
            }
            if (t > 0) out.println();
        }
    }

    private class Entry implements Comparable<Entry> {
        private int value, idx;

        private Entry(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Entry o) {
            int x = Integer.compare(this.value, o.value);
            return x != 0 ? x : Integer.compare(this.idx, o.idx);
        }
    }

    private class MyTree {
        private int i;
        private TreeSet<Entry> left = new TreeSet<>();
        private TreeSet<Entry> right = new TreeSet<>();

        public void add(Integer value, int idx) {
            Entry entry = new Entry(value, idx);
            if (left.size() == 0) {
                left.add(entry);
            } else if (left.last().value <= value) {
                right.add(entry);
            } else {
                Entry current = left.last();
                left.remove(current);
                right.add(current);
                left.add(entry);
            }
            while (left.size() <= i) {
                if (right.size() > 0) {
                    Entry e = right.first();
                    right.remove(e);
                    left.add(e);
                }
            }
        }
        
        public int get() {
            i++;
            int result = left.last().value;
            if (right.size() > 0) {
                Entry next = right.first();
                right.remove(next);
                left.add(next);
            }
            return result;
        }

        private int size() {
            return left.size() + right.size();
        }
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

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (BlackBox instance = new BlackBox()) {
            instance.solve();
        }
    }
}
