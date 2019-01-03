package codeforces.contests1001_1100.problemset1095;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PowersOfTwo implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        int[] cnt = new int[31];
        int powers = 0;
        for (int i = 0; i <= 30; i++) {
            int bit = 1 << i;
            if ((n & bit) != 0) {
                powers++;
                cnt[i]++;
            }
        }
        if (powers > k) {
            out.println("NO");
        } else {
            while (powers < k) {
                boolean possible = false;
                for (int i = 30; i >= 1; i--) {
                    if (cnt[i] > 0) {
                        cnt[i]--;
                        cnt[i - 1] += 2;
                        powers++;
                        possible = true;
                        break;
                    }
                }
                if (!possible) {
                    out.println("NO");
                    return;
                }
            }
            out.println("YES");
            for (int i = 0; i <= 30; i++) {
                for (int j = 0; j < cnt[i]; j++) {
                    out.print(1 << i);
                    out.print(' ');
                }
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
        try (PowersOfTwo instance = new PowersOfTwo()) {
            instance.solve();
        }
    }
}
