package codeforces.contests901_1000.problemset978;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class AlmostArithmeticProgression implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        if (n <= 2) {
            out.println(0);
            return;
        }
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        int result = Integer.MAX_VALUE;
        for (int i : new int[]{-1, 0, 1}) {
            for (int j : new int[]{-1, 0, 1}) {
                int score = 0;
                int[] perm = new int[n];
                perm[0] = x[0] + i;
                perm[1] = x[1] + j;
                if (i != 0) score++;
                if (j != 0) score++;
                int diff = perm[1] - perm[0];
                boolean possible = true;
                for (int k = 2; k < n; k++) {
                    int target = perm[k - 1] + diff;
                    if (target == x[k]) {
                        perm[k] = target;
                    } else if (abs(target - x[k]) == 1) {
                        perm[k] = target;
                        score++;
                    } else {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    result = Math.min(result, score);
                }
            }
        }
        out.println(result != Integer.MAX_VALUE ? result : -1);
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
        try (AlmostArithmeticProgression instance = new AlmostArithmeticProgression()) {
            instance.solve();
        }
    }
}
