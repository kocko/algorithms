package codeforces.contests801_900.problemset844;

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

public class SortingBySubsequences implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Pair> sorted = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int value = in.ni();
            sorted.add(new Pair(i, value));
        }
        sorted.sort(Comparator.naturalOrder());
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> next = new ArrayList<>();
        boolean[] used = new boolean[n];
        for (int idx = 0; idx < n; idx++) {
            if (!used[idx]) {
                int start = idx;
                while (true) {
                    if (used[start]) {
                        result.add(next);
                        next = new ArrayList<>();
                        break;
                    } else {
                        used[start] = true;
                        next.add(start + 1);
                        start = sorted.get(start).idx;
                    }
                }
            }
        }
        out.println(result.size());
        for (List<Integer> integers : result) {
            out.print(integers.size());
            out.print(' ');
            for (Integer value : integers) {
                out.print(value);
                out.print(' ');
            }
            out.println();
        }
    }
    
    private class Pair implements Comparable<Pair> {
        private int idx, value;

        private Pair(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.value, o.value);
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
        try (SortingBySubsequences instance = new SortingBySubsequences()) {
            instance.solve();
        }
    }
}
