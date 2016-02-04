package codeforces.contests101_200.problemset115;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Lawnmower implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni(), m = in.ni();
        int[][] length = new int[n][2];
        for (int i = 0; i < n; i++) {
            char[] line = in.next().toCharArray();
            int min = 0, max = m;
            boolean weed = false;
            for (int j = 0; j < m; j++) {
                if (line[j] == 'W') {
                    weed = true;
                    min = Math.min(min, j);
                    max = Math.max(max, j);
                }
            }
            if (weed) {
                length[i] = new int[] { min, max };
            } else {
                length[i] = null;
            }
        }
        char dir = 'R';
        int result = length[0][1] - length[0][0];
        for (int i = 1; i < n; i++) {
//            if (i != null &&) {
//                result++;
//            } else {
//
//            }
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

    public static void main(String[] args) {
        new Lawnmower().solve();
    }
}
