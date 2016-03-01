package codeforces.contests101_200.problemset108;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Datatypes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int[] types = new int[n];
        for (int i = 0; i < n; i++) {
            types[i] = in.ni();
        }
        Arrays.sort(types);
        boolean ok = true;
        for (int i = 0; i < n - 1; i++) {
            int left = i + 1, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (types[i] < types[mid] && types[i] * 2 > types[mid]) {
                    ok = false;
                    break;
                } else {
                    right = mid - 1;
                }
            }
            if (!ok) break;
        }
        out.println(ok ? "NO" : "YES");
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

    public static void main(String[] args) {
        new Datatypes().solve();
    }
}
