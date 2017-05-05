package codeforces.contests501_600.problemset584;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MarinaAndVasya implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), t = in.ni();
        char[] x = in.next().toCharArray(), y = in.next().toCharArray();
        int diff = diff(x, y);
        if (diff <= t) {
            char[] result = new char[n];
            int temp = 0;
            for (int i = 0; i < n; i++) {
                if (x[i] != y[i]) {
                    result[i] = getDifferentThan(x[i], y[i]);
                    temp++;
                }
            }
            for (int i = 0; i < n; i++) {
                if (x[i] == y[i]) {
                    if (temp < t) {
                        result[i] = getDifferentThan(x[i], x[i]);
                        temp++;
                    } else {
                        result[i] = x[i];
                    }
                }
            }
            print(result);
        } else {
            int k = 2 * t - diff;
            if (k < 0) {
                out.println(-1);
            } else {
                char[] result = new char[n];
                for (int i = 0; i < n; i++) {
                    if (k == 0) break;
                    if (x[i] != y[i]) {
                        result[i] = getDifferentThan(x[i], y[i]);
                        k--;
                    }
                }
                boolean fromX = true;
                for (int i = 0; i < n; i++) {
                    if (x[i] != y[i] && result[i] == 0x0000) {
                        if (fromX) {
                            result[i] = x[i];
                        } else {
                            result[i] = y[i];
                        }
                        fromX = !fromX;
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (result[i] == 0x0000) {
                        result[i] = x[i];
                    }
                }
                print(result);
            }
        }
    }
    
    private void print(char[] x) {
        for (char c : x) out.print(c);
    }
    
    private int diff(char[] x, char[] y) {
        int result = 0;
        for (int i = 0; i < x.length; i++) if (x[i] != y[i]) result++;
        return result;
    }
    
    private char getDifferentThan(char a, char b) {
        for (char x = 'a'; x <= 'z'; x++) if (x != a && x != b) return x;
        return 0x0000;
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
        try (MarinaAndVasya instance = new MarinaAndVasya()) {
            instance.solve();
        }
    }
}
