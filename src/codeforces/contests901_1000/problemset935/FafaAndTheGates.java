package codeforces.contests901_1000.problemset935;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class FafaAndTheGates implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), x = 0, y = 0, result = 0;
        char[] s = in.next().toCharArray();
        int[] quadrant = new int[n];
        for (int i = 0; i < n; i++) {
            char c = s[i];
            switch (c) {
                case 'R': x++; break;
                case 'L': x--; break;
                case 'U': y++; break;
                case 'D': y--; break;
            }
            if (x == y) {
                quadrant[i] = 0;
            } else if (x > y) {
                quadrant[i] = -1;
            } else {
                quadrant[i] = 1;
            }
        }
        int last = quadrant[0];
        for (int i = 1; i < n; i++) {
            if (abs(quadrant[i]) == 1 && -quadrant[i] == last) {
                result++;
                last = quadrant[i];
            }
        }
        out.println(result);
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
        try (FafaAndTheGates instance = new FafaAndTheGates()) {
            instance.solve();
        }
    }
}
