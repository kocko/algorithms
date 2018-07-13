package codeforces.contests1001_1100.problemset1008;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;

public class ReorderTheArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] p = new int[n];
        List<Entry> x = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            p[i] = in.ni();
            values.add(p[i]);
            x.add(new Entry(i, p[i]));
        }

        x.sort(comparingInt(Entry::getValue));
        values.sort(naturalOrder());
        int idx = 0;
        int[] q = new int[n];
        for (Entry e : x) {
            if (idx == n) break;
            int left = idx, right = n - 1;
            int index = n + 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (values.get(mid) <= e.value) {
                    left = mid + 1;
                } else {
                    index = Math.min(index, mid);
                    right = mid - 1;
                }
            }
            if (index != n + 1) {
                q[e.idx] = values.get(index);
                idx = index + 1;
            } else break;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (q[i] > p[i]) result++;
        }
        out.println(result);
    }

    private class Entry {
        private int idx, value;

        private Entry(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        public int getValue() {
            return value;
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
        try (ReorderTheArray instance = new ReorderTheArray()) {
            instance.solve();
        }
    }
}
