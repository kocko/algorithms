package hackerrank.contests.hourrank16;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CandyPiles implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni();
        }
        Arrays.sort(x);
        x[0] <<= 1;
        int min = (int) 1e5 + 1;
        for (int i = 0; i < n; i++) {
            min = Math.min(x[i], min);
        }
        x[0] >>= 1;
        int ways = 0;
        for (int i = 0; i < n; i++) {
            x[i] <<= 1;
            int currentMin = (int) 1e5 + 1;
            for (int j = 0; j < n; j++) {
                currentMin = Math.min(x[j], currentMin);
            }
            if (currentMin == min) ways++;
            x[i] >>= 1;
        }
        out.println(min + " " + ways);
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
        try (CandyPiles instance = new CandyPiles()) {
            instance.solve();
        }
    }
}
