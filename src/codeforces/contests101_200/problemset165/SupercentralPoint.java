package codeforces.contests101_200.problemset165;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SupercentralPoint implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n], y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
            y[i] = in.ni();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int up = 0, down = 0, left = 0, right = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (x[i] == x[j]) {
                        if (y[j] > y[i]) up++;
                        else down++;
                    } else if (y[i] == y[j]) {
                        if (x[j] > x[i]) right++;
                        else left++;
                    }
                }
            }
            if (up > 0 && down > 0 && left > 0 && right > 0) cnt++; 
        }
        out.println(cnt);
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
        try (SupercentralPoint instance = new SupercentralPoint()) {
            instance.solve();
        }
    }
}
