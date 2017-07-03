package codeforces.contests801_900.problemset818;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PermutationGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] leaders = new int[m];
        for (int i = 0; i < m; i++) {
            leaders[i] = in.ni();
        }
        
        int[] permutation = new int[n + 1];
        for (int i = 0; i < m - 1; i++) {
            int diff = leaders[i + 1] - leaders[i];
            if (diff <= 0) {
                diff += n;
            }
            if (permutation[leaders[i]] != 0 && permutation[leaders[i]] != diff) {
                out.println(~0);
                return;
            }
            permutation[leaders[i]] = diff;
        }

        boolean[] used = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (permutation[i] != 0 && used[permutation[i]]) {
                System.out.println(-1);
                System.exit(0);
            }
            used[permutation[i]] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (permutation[i] == 0) {
                for (int j = 1; j <= n; j++) {
                    if (!used[j]) {
                        permutation[i] = j;
                        used[j] = true;
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            out.print(permutation[i]);
            out.print(' ');
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
        try (PermutationGame instance = new PermutationGame()) {
            instance.solve();
        }
    }
}
