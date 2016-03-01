package codeforces.contests101_200.problemset108;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PalindromicTimes implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        String[] time = in.next().split(":");
        int hour = Integer.parseInt(time[0]), minute = Integer.parseInt(time[1]);
        if (minute >= Integer.parseInt(new StringBuilder(time[0]).reverse().toString())) {
            hour++;
        }
        while (hour % 10 > 5) hour++;
        if (hour >= 24) hour -= 24;
        if (hour < 10) {
            out.print("0");
        }
        out.println(hour + ":" + (hour % 10) + "" + (hour / 10));
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
        new PalindromicTimes().solve();
    }
}
