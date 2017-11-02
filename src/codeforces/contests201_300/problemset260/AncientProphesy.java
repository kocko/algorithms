package codeforces.contests201_300.problemset260;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class AncientProphesy implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String x = in.next();
        int n = x.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= n - 10; i++) {
            String sub = x.substring(i, i + 10);
            if (sub.matches("\\d{2}-\\d{2}-\\d{4}") && valid(sub)) {
                set.add(sub);
            }
        }
        int max = 0;
        String result = "";
        for (String date : set) {
            int z = z(x, date);
            if (z > max) {
                max = z;
                result = date;
            }
        }
        out.println(result);
    }

    private boolean valid(String date) {
        final int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] split = date.split("-");
        int d = parseInt(split[0]), m = parseInt(split[1]) - 1, y = parseInt(split[2]);
        return (y >= 2013 && y <= 2015) && m >= 0 && m < 12 && d >= 1 && d <= days[m];
    }

    private int z(String text, String pattern) {
        char[] s = (pattern + "$" + text).toCharArray();
        int l = 0, r = 0, n = s.length;
        int[] z = new int[n];
        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && s[r - l] == s[r]) {
                    r++;
                }
                z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (z[k] < r - i + 1) {
                    z[i] = z[k];
                } else {
                    l = i;
                    while (r < n && s[r - l] == s[r]) {
                        r++;
                    }
                    z[i] = r - l;
                    r--;
                }
            }
        }
        int result = 0;
        for (int i = 1; i < n; i++) {
            if (z[i] == 10) result++;
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
            return parseInt(next());
        }

        public long nl() {
            return Long.parseLong(next());
        }

        public void close() throws IOException {
            reader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        try (AncientProphesy instance = new AncientProphesy()) {
            instance.solve();
        }
    }
}
