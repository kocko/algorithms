package codeforces.contests101_200.problemset149;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class MartianClock implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String[] split = in.next().split(":");
        int radix = Math.max(findRadix(split[0]), findRadix(split[1]));
        Set<Integer> result = new TreeSet<>();
        result.add(radix);
        int lastHour = convert(split[0], radix), lastMinute = convert(split[1], radix);
        if (lastHour >= 25 || lastMinute >= 60) {
            out.println(0);
            return;
        }
        for (int i = radix + 1; ; i++) {
            int hour = convert(split[0], i), minute = convert(split[1], i);
            if (hour == lastHour && minute == lastMinute) {
                out.println(-1);
                return;
            } else if (hour < 24 && minute < 60) {
                lastHour = hour;
                lastMinute = minute;
                result.add(i);
            } else break;
        }
        if (result.size() == 0) {
            out.println(0);
        } else {
            for (int r : result) {
                out.print(r);
                out.print(' ');
            }
        }
    }

    private int findRadix(String a) {
        int result = 1;
        for (char c : a.toCharArray()) {
            int base;
            if (c >= '0' && c <= '9') {
                base = c - '0' + 1;
            } else {
                base = c - 'A' + 11;
            }
            result = Math.max(base, result);
        }
        return result;
    }

    private int convert(String value, int radix) {
        int result = 0;
        int base = 1;
        for (int i = value.length() - 1; i >= 0; i--) {
            int multiplier;
            char ch = value.charAt(i);
            if (ch >= '0' && ch <= '9') {
                multiplier = ch - '0';
            } else {
                multiplier = ch - 'A' + 10;
            }
            result += multiplier * base;
            base *= radix;
        }
        return result;
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
        try (MartianClock instance = new MartianClock()) {
            instance.solve();
        }
    }
}
