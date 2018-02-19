package codeforces.contests801_900.problemset841;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Collections.reverseOrder;
import static java.util.Collections.sort;
import static java.util.Comparator.naturalOrder;

public class LehaAndFunction implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Entry implements Comparable<Entry> {
        private int idx, value;

        private Entry(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Entry o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public void solve() {
        int n = in.ni();
        List<Entry> a = new ArrayList<>(), b = new ArrayList<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            a.add(new Entry(i, in.ni()));
        }
        for (int i = 0; i < n; i++) {
            b.add(new Entry(i, in.ni()));
        }
        a.sort(reverseOrder());
        b.sort(naturalOrder());
        int idx = 0;
        for (Entry entry : b) {
            result[entry.idx] = a.get(idx++).value;
        }
        for (int i = 0; i < n; i++) {
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
        try (LehaAndFunction instance = new LehaAndFunction()) {
            instance.solve();
        }
    }
}
