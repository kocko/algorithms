package codeforces.contests401_500.problemset459;

import java.io.*;
import java.util.StringTokenizer;

public class PashmakAndBuses implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni(), d = in.ni();
        int[][] result = new int[d][n];
        int temp = 1;
        boolean ok = false;
        for (int i = 0; i < d; i++) {
            temp *= k;
            if (temp >= n) {
                ok = true;
                break;
            }
        }
        if (!ok) {
            out.println(~0);
            return;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < d; j++) {
                result[j][i] = result[j][i - 1];
            }
            for (int j = d - 1; j >= 0; j--) {
                result[j][i] = (result[j][i] + 1) % k;
                if (result[j][i] > 0) break;
            }
        }
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < n; j++) {
                out.print(result[i][j] + 1);
                out.print(' ');
            }
            out.println();
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
        try (PashmakAndBuses instance = new PashmakAndBuses()) {
            instance.solve();
        }
    }
}
