package codeforces.contests600_699.problemset629;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FarRelativesProblem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        int[][] days = new int[367][2];
        for (int i = 0; i < n; i++) {
            String gender = in.next();
            int a = in.ni(), b = in.ni();
            int mf = "M".equals(gender) ? 0 : 1;
            for (int j = a; j <= b; j++) {
                days[j][mf]++;
            }
        }
        long result = 0;
        for (int i = 1; i <= 366; i++) {
            if (days[i][0] > 0 && days[i][1] > 0) {
                result = Math.max(2 * Math.min(days[i][0], days[i][1]), result);
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

    public static void main(String[] args) {
        new FarRelativesProblem().solve();
    }
}
