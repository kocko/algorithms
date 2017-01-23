package codeforces.contests401_500.problemset479;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class LongJumps implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), l = in.ni(), x = in.ni(), y = in.ni();
        int[] r = new int[n];
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            r[i] = in.ni();
            set.add(r[i]);
        }
        boolean a = contains(set, r, x), b = contains(set, r, y);
        if (a && b) {
            out.println(0);
        } else if (a) {
            out.println(1);
            out.println(y);
        } else if (b) {
            out.println(1);
            out.println(x);
        } else {
            for (int i = 0; i < n; i++) {
                if (set.contains(r[i] - x - y)) {
                    out.println(1);
                    out.println(r[i] - x);
                    return;
                }
                if (r[i] + x <= l && set.contains(r[i] + x - y)) {
                    out.println(1);
                    out.println(r[i] + x);
                    return;
                }
                if (r[i] - x >= 0 && set.contains(r[i] - x + y)) {
                    out.println(1);
                    out.println(r[i] - x);
                    return;
                }
            }
            out.println(2);
            out.println(x + " " + y);
        }
    }
    
    private boolean contains(Set<Integer> set, int[] r, int x) {
        for (int k : r) {
            if (set.contains(k - x)) return true;
        }
        return false;
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
        try (LongJumps instance = new LongJumps()) {
            instance.solve();
        }
    }
    
}
