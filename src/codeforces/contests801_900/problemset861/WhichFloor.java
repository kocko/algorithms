package codeforces.contests801_900.problemset861;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WhichFloor implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[] floor = new int[101];
        for (int i = 0; i < m; i++) {
            floor[in.ni()] = in.ni();
        }
        int result = -1;
        for (int i = 1; i <= 100; i++) {
            int[] guess = new int[101];
            int number = 1;
            for (int j = 1; j <= 100; j += i) {
                for (int k = 0; k < i && j + k <= 100; k++) {
                    guess[j + k] = number;
                }
                number++;
            }
            if (ok(floor, guess)) {
                if (result == -1) {
                    result = guess[n];
                } else {
                    if (guess[n] != result) {
                        result = -1;
                        break;
                    }
                }
            }
        }
        out.println(result);
    }

    private boolean ok(int[] floor, int[] guess) {
        boolean ok = true;
        for (int i = 1; i <= 100; i++) {
            if (floor[i] != 0) {
                ok &= floor[i] == guess[i];
            }
        }    
        return ok;
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
        try (WhichFloor instance = new WhichFloor()) {
            instance.solve();
        }
    }
}
