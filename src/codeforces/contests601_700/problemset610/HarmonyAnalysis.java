package codeforces.contests601_700.problemset610;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class HarmonyAnalysis implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n == 0) {
            out.println("+");
        } else {
            int[][] s = new int[1 << n][1 << n];
            s[0][0] = 1;
            recurse(s, 1);
            for (int[] row : s) {
                for (int v : row) {
                    if (v == 1) {
                        out.print('+');
                    } else {
                        out.print('*');
                    }
                }
                out.println();
            }
        }
    }
    
    private void recurse(int[][] s, int c) {
        int k = 1 << c;
        if (k <= s.length) {
            int half = k / 2;
            for (int i = 0; i < half; i++) {
                for (int j = half; j < k; j++) {
                    s[i][j] = s[i][j - half];
                }
            }
            for (int i = half; i < k; i++) {
                for (int j = 0; j < half; j++) {
                    s[i][j] = s[i - half][j];
                }
            }
            for (int i = half; i < k; i++) {
                for (int j = half; j < k; j++) {
                    s[i][j] = (-1) * s[i - half][j - half];
                }
            }
            recurse(s, c + 1);
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
        try (HarmonyAnalysis instance = new HarmonyAnalysis()) {
            instance.solve();
        }
    }
}
