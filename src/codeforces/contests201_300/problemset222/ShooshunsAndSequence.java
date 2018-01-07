package codeforces.contests201_300.problemset222;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ShooshunsAndSequence implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
        }
        if (k == 1) {
            boolean allAreSame = true;
            for (int i = 1; i < n; i++) {
                allAreSame &= a[i] == a[0];
            }
            if (allAreSame) out.println(0);
            else out.println(-1);
        } else if (k == n) {
            int idx = k - 2;
            for (int i = idx; i >= 0; i--) {
                if (a[idx] != a[k - 1]) break;
                else idx--;
            }
            out.println(idx + 1);
        } else {
            boolean allAreSame = true;
            for (int i = k; i < n; i++) {
                allAreSame &= a[i] == a[k - 1];
            }
            if (allAreSame) {
                int idx = k - 2;
                for (int i = idx; i >= 0; i--) {
                    if (a[idx] != a[k - 1]) break;
                    else idx--;
                }
                out.println(idx + 1);
            } else {
                out.println(-1);
            }
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
        try (ShooshunsAndSequence instance = new ShooshunsAndSequence()) {
            instance.solve();
        }
    }
}
