package codeforces.contests701_800.problemset758;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BlownGarland implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] x = in.next().toCharArray();
        int r = 0, b = 0, y = 0, g = 0, n = x.length;
        int[] result = new int[4];
        for (int i = 0; i < n; i++) {
            int idx = i % 4;
            if (x[i] == '!') {
                result[idx]++;
            } else {
                if (x[i] == 'R') r = idx;
                if (x[i] == 'B') b = idx;
                if (x[i] == 'Y') y = idx;
                if (x[i] == 'G') g = idx;
            }
        }
        out.println(result[r] + " " + result[b] + " " + result[y] + " " + result[g]);
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
        try (BlownGarland instance = new BlownGarland()) {
            instance.solve();
        }
    }
}
