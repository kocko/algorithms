package hackerrank.contests.weekofcode37;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class TheAverageRatingOfTopEmployees implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        double total = 0, count = 0;
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            if (next >= 90) {
                total += next;
                count++;
            }
        }
        double average = total / count;
        double roundOff = (double) Math.round(average * 100) / 100;
        DecimalFormat df = new DecimalFormat("##.00");
        out.println(df.format(roundOff));
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
        try (TheAverageRatingOfTopEmployees instance = new TheAverageRatingOfTopEmployees()) {
            instance.solve();
        }
    }
}
