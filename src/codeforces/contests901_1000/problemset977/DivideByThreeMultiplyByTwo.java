package codeforces.contests901_1000.problemset977;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;

public class DivideByThreeMultiplyByTwo implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        n = in.ni();
        x = new long[n];
        seq = new long[n];
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nl();
        }
        for (int i = 0; i < n; i++) {
            if (ok) break;
            seq[0] = x[i];
            used[i] = true;
            recurse(1, x[i]);
            used[i] = false;
        }
    }

    private int n;
    private long[] seq, x;
    private boolean ok;
    private boolean[] used;

    private void recurse(int idx, long last) {
        if (idx == n) {
            ok = true;
            print();
            return;
        }
        boolean a = false;
        int i;
        for (i = 0; i < n; i++) {
            if (!used[i] && 3 * x[i] == last) {
                a = true;
                break;
            }
        }
        if (a) {
            used[i] = true;
            seq[idx] = x[i];
            recurse(idx + 1, x[i]);
            used[i] = false;
        }
        
        boolean b = false;
        for (i = 0; i < n; i++) {
            if (!used[i] && 2 * last == x[i]) {
                b = true;
                break;
            }
        }
        if (b) {
            used[i] = true;
            seq[idx] = x[i];
            recurse(idx + 1, x[i]);
            used[i] = false;
        }
    }

    private void print() {
        for (long i : seq) {
            out.print(i);
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
        try (DivideByThreeMultiplyByTwo instance = new DivideByThreeMultiplyByTwo()) {
            instance.solve();
        }
    }
}
