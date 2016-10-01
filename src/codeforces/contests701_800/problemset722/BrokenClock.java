package codeforces.contests701_800.problemset722;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BrokenClock implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int format = in.ni();
        String[] hour = in.next().split(":");
        if (format == 24) {
            if (hour[0].charAt(0) == '2') {
                if (hour[0].charAt(1) >= '4') {
                    hour[0] = "20";
                }
            } else if (hour[0].charAt(0) > '2') {
                hour[0] = "0" + hour[0].charAt(1);
            }
        } else {
            if ("00".equals(hour[0])) {
                hour[0] = "01";
            } else if (hour[0].charAt(0) > '1') {
                if (hour[0].charAt(1) != '0') {
                    hour[0] = "0" + hour[0].charAt(1);
                } else {
                    hour[0] = "10";
                }
            } else if (hour[0].charAt(0) == '1') {
                if (hour[0].charAt(1) >= '3') {
                    hour[0] = "0" + hour[0].charAt(1);
                }
            }
        }
        if (hour[1].charAt(0) >= '6') {
            hour[1] = "0" + hour[1].charAt(1);
        }
        out.println(hour[0] + ":" + hour[1]);
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
        try (BrokenClock instance = new BrokenClock()) {
            instance.solve();
        }
    }
}
