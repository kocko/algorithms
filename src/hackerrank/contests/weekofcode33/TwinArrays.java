package hackerrank.contests.weekofcode33;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TwinArrays implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Value implements Comparable<Value> {
        private int idx, value;

        private Value(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Value o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public void solve() {
        int n = in.ni();
        int[] a = new int[n];
        List<Value> list = new ArrayList<>();
        for (int i = 0; i < n; i++) a[i] = in.ni();
        for (int i = 0; i < n; i++) list.add(new Value(i, in.ni()));
        Collections.sort(list);
        int min = (int) 1e7;
        for (int i = 0; i < n; i++) {
            if (a[i] >= min) continue;
            int idx = 0;
            while (list.get(idx).idx == i) idx++;
            min = Math.min(a[i] + list.get(idx).value, min);
        }
        out.println(min);
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
        try (TwinArrays instance = new TwinArrays()) {
            instance.solve();
        }
    }
}
