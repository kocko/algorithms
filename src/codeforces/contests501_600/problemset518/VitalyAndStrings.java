package codeforces.contests501_600.problemset518;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VitalyAndStrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] a = in.next().toCharArray(), b = in.next().toCharArray();
        int n = a.length;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] != 'z') {
                a[i]++;
                for (int j = i + 1; j < n; j++) {
                    a[j] = 'a';
                }
                break;
            }
        }
        if (valid(a, b)) {
            for (char c : a) out.print(c);
        } else {
            out.println("No such string");
        }
    }
    
    private boolean valid(char[] a, char[] b) {
        String x = new String(a), y = new String(b);
        return x.compareTo(y) < 0;
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
        try (VitalyAndStrings instance = new VitalyAndStrings()) {
            instance.solve();
        }
    }
}
