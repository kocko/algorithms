package codeforces.contests501_600.problemset544;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class SetOfStrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int k = in.ni();
        String s = in.next();
        int n = s.length();
        if (k == 1) {
            out.println("YES");
            out.println(s);
        } else {
            boolean[] used = new boolean[26];
            used[s.charAt(0) - 'a'] = true;
            List<String> result = new ArrayList<>();
            int start = 0, i;
            for (i = 1; i < n; i++) {
                if (k == 0) break;
                if (!used[s.charAt(i) - 'a']) {
                    if (k > 1) {
                        result.add(s.substring(start, i));
                    } else {
                        result.add(s.substring(start));
                    }
                    start = i;
                    k--;
                    used[s.charAt(i) - 'a'] = true;
                }
            }
            if (k == 1) {
                k = 0;
                result.add(s.substring(start));
            }
            if (k == 0) {
                out.println("YES");
                result.forEach(out::println);
            } else {
                out.println("NO");
            }
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
        try (SetOfStrings instance = new SetOfStrings()) {
            instance.solve();
        }
    }
}
