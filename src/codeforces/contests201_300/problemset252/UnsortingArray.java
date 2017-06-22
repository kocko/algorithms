package codeforces.contests201_300.problemset252;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class UnsortingArray implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private class Pair {
        private int left, right;

        private Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    
    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = in.ni();
        if (n <= 2 || allAreSame(x)) {
            out.println(-1);
            return;
        }
        List<Pair> pairs = new ArrayList<>();
        out: for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (x[i] != x[j]) {
                    pairs.add(new Pair(i, j));
                    if (pairs.size() == 3) break out;
                }
            }
        }
        for (Pair pair : pairs) {
            int t = x[pair.left];
            x[pair.left] = x[pair.right];
            x[pair.right] = t;
            if (!sorted(x)) {
                out.println((pair.left + 1) + " " + (pair.right + 1));
                return;
            }
            t = x[pair.left];
            x[pair.left] = x[pair.right];
            x[pair.right] = t;
        }
        out.println(-1);
    }
    
    private boolean sorted(int[] x) {
        boolean inc = true, dec = true;
        for (int i = 1; i < x.length; i++) {
            inc &= (x[i] >= x[i - 1]);
        }
        for (int i = 1; i < x.length; i++) {
            dec &= (x[i] <= x[i - 1]);
        }
        return inc || dec;
    }
    
    private boolean allAreSame(int[] x) {
        Set<Integer> set = new HashSet<>();
        for (int i : x) set.add(i);
        return set.size() == 1;
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
        try (UnsortingArray instance = new UnsortingArray()) {
            instance.solve();
        }
    }
}
