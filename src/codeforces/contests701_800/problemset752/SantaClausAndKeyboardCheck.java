package codeforces.contests701_800.problemset752;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SantaClausAndKeyboardCheck implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] a = in.next().toCharArray();
        char[] b = in.next().toCharArray();
        int n = a.length;
        int[] x = new int[26];
        Arrays.fill(x, -1);
        for (int i = 0; i < n; i++) {
            int p = a[i] - 'a';
            int q = b[i] - 'a';
            if (x[p] != -1 && x[p] != q) {
                out.println(-1);
                return;
            }
            if (x[q] != -1 && x[q] != p) {
                out.println(-1);
                return;
            }
            x[p] = q;
            x[q] = p;
        }
        int k = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (x[i] != -1 && x[i] != i) {
                k++;
                char j = (char) (i + 'a');
                char m = (char) (x[i] + 'a');
                sb.append(j).append(" ").append(m).append('\n');
                x[x[i]] = -1;
            }
        }
        out.println(k);
        out.println(sb);
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
        try (SantaClausAndKeyboardCheck instance = new SantaClausAndKeyboardCheck()) {
            instance.solve();
        }
    }
}
