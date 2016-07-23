package codeforces.contests601_700.problemset622;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheTime implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        String[] time = in.next().split(":");
        int after = in.ni();
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        hour += (after / 60);
        minute += (after % 60);
        if (minute >= 60) {
            hour += minute / 60;
            minute %= 60;
        }
        if (hour >= 24) hour %= 24;
        if (hour < 10) {
            out.print(0);
        }
        out.print(hour);
        out.print(":");
        if (minute < 10) {
            out.print(0);
        }
        out.println(minute);
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
        new TheTime().solve();
    }
}
