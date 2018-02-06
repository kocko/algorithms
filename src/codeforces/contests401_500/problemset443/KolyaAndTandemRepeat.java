package codeforces.contests401_500.problemset443;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class KolyaAndTandemRepeat implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        StringBuilder sb = new StringBuilder(in.next());
        int k = in.ni();
        for (int i = 0; i < k; i++) {
            sb.append('?');
        }
        String s = sb.toString();
        int n = s.length(), max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (sub.length() > max && ok(sub)) {
                    max = sub.length();
                }
            }
        }
        out.println(max);
    }
    
    private boolean ok(String s) {
        int n = s.length();
        if (n % 2 == 0) {
            char[] x = s.toCharArray();
            boolean ok = true;
            for (int i = 0; i < n / 2; i++) {
                if (x[i] != '?' && x[n / 2 + i] != '?') {
                    ok &= x[i] == x[n / 2 + i];
                }
            }   
            return ok;
        }
        return false;
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
        try (KolyaAndTandemRepeat instance = new KolyaAndTandemRepeat()) {
            instance.solve();
        }
    }
}
