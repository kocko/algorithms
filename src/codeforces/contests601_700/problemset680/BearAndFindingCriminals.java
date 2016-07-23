package codeforces.contests601_700.problemset680;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BearAndFindingCriminals implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni(), a = in.ni();
        int[] list = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = in.ni();
        }
        int result = 0;
        for (int i = 0; i <= 99; i++) {
            int need = 0, have = 0;
            if (a - i >= 1) {
                need++;
                if (list[a - i] == 1) {
                    have++;
                }
            }
            if (a + i <= n && i != 0) {
                need++;
                if (list[a + i] == 1) {
                    have++;
                }
            }
            if (need == have) result += have;
        }
        out.println(result);
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
        new BearAndFindingCriminals().solve();
    }
}
