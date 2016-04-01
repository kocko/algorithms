package codeforces.contests600_699.problemset651;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BeautifulPaintings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = in.ni();
        }
        Arrays.sort(b);
        int[] result = new int[n];
        boolean[] used = new boolean[n];
        result[0] = b[0];
        used[0] = true;
        for (int i = 1; i < n; i++) {
            int candidate = -1;
            for (int j = 1; j < n; j++) {
                if (b[j] > result[i - 1] && !used[j]) {
                    candidate = b[j];
                    used[j] = true;
                    break;
                }
            }
            if (candidate == -1) {
                for (int j = 1; j < n; j++) {
                    if (b[j] < result[i - 1] && !used[j]) {
                        candidate = b[j];
                        used[j] = true;
                        break;
                    }
                }
            }
            if (candidate != -1) {
                result[i] = candidate;
            } else {
                result[i] = result[i - 1];
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans += (result[i] > result[i - 1]) ? 1 : 0;
        }
        out.println(ans);
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
        new BeautifulPaintings().solve();
    }
}
