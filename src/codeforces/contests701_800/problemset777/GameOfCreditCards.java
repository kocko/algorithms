package codeforces.contests701_800.problemset777;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GameOfCreditCards implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] s = in.next().toCharArray();
        char[] m = in.next().toCharArray();
        int[] c1 = new int[10];
        int[] c2 = new int[10];
        for (int i = 0; i < n; i++) {
            c1[m[i] - '0']++;
            c2[m[i] - '0']++;
        }
        int get = 0;
        for (int i = 0; i < n; i++) {
            int digit = s[i] - '0';
            if (digit == 9) {
                if (c1[9] > 0) {
                    c1[9]--;
                } else {
                    get++;
                    for (int j = 0; j <= 9; j++) {
                        if (c1[j] > 0) {
                            c1[j]--;
                            break;
                        }
                    }
                }
            } else {
                boolean can = false;
                for (int j = digit; j <= 9; j++) {
                    if (c1[j] > 0) {
                        c1[j]--;
                        can = true;
                        break;
                    }
                }
                if (!can) {
                    get++;
                    for (int j = 0; j <= 9; j++) {
                        if (c1[j] > 0) {
                            c1[j]--;
                            break;
                        }
                    }
                }
            }
        }
        int give = 0;
        for (int i = 0; i < n; i++) {
            int digit = s[i] - '0';
            if (digit == 9) {
                for (int j = 0; j <= 9; j++) {
                    if (c2[j] > 0) {
                        c2[j]--;
                        break;
                    }
                }
            } else {
                boolean can = false;
                for (int j = digit + 1; j <= 9; j++) {
                    if (c2[j] > 0) {
                        c2[j]--;
                        give++;
                        can = true;
                        break;
                    }
                }
                if (!can) {
                    for (int j = 0; j <= 9; j++) {
                        if (c2[j] > 0) {
                            c2[j]--;
                            break;
                        }
                    }
                }
            }
        }
        out.println(get);
        out.println(give);
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
        try (GameOfCreditCards instance = new GameOfCreditCards()) {
            instance.solve();
        }
    }
}
