package codeforces.contests401_500.problemset496;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Math.*;

public class SecretCombination implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        String key = in.next();
        String[] shift = new String[10];
        shift[0] = key;
        for (int i = 1; i < 10; i++) {
            shift[i] = shift(shift[i - 1]);
        }
        for (int i = 0; i < 10; i++) {
            shift[i] = shift[i] + shift[i];
        }
        TreeSet<String> set = new TreeSet<>();
        for (String s : shift) {
            for (int i = 0; i <= s.length() - n; i++) {
                set.add(s.substring(i, i + n));
            }
        }
        out.println(set.first());
    }
    
    private String shift(String x) {
        int n = x.length();
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            char c = x.charAt(i);
            if (c == '9') c = '0';
            else c++;
            result[i] = c;
        }
        return new String(result);
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
        try (SecretCombination instance = new SecretCombination()) {
            instance.solve();
        }
    }
}
