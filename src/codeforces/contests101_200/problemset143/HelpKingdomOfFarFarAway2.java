package codeforces.contests101_200.problemset143;

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

public class HelpKingdomOfFarFarAway2 implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String[] x = in.next().split("\\.");
        StringBuilder result = new StringBuilder();
        boolean negative = x[0].charAt(0) == '-';
        int end = negative ? 1 : 0;
        int cnt = 0;
        for (int i = x[0].length() - 1; i >= end; i--) {
            result.append(x[0].charAt(i));
            cnt++;
            if (cnt == 3) {
                result.append(",");
                cnt = 0;
            }
        }
        result.reverse();
        if (result.charAt(0) == ',') result.deleteCharAt(0);
        result.append('.');
        if (x.length == 2) {
            for (int i = 0; i < 2; i++) {
                if (i < x[1].length()) {
                    result.append(x[1].charAt(i));
                } else {
                    result.append('0');
                }
            }
        } else {
            result.append("00");
        }
        if (negative) {
            out.printf("($%s)\n", result);
        } else {
            out.printf("$%s\n", result);
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
        try (HelpKingdomOfFarFarAway2 instance = new HelpKingdomOfFarFarAway2()) {
            instance.solve();
        }
    }
}
