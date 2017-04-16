package codeforces.contests801_900.problemset801;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ViciousKeyboard implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        char[] s = in.next().toCharArray();
        int sum = 0;
        int flag = 0, n = s.length;
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == 'V' && s[i + 1] == 'K') {
                s[i] = '@';
                s[i + 1] = '@';
                sum++; i++;
            }
        }
        if (flag == 0) {
            for (int i = 0; i < n - 1; i++) {
                if (s[i] == 'V' && s[i + 1] != '@') {
                    sum++;
                    flag = 1;
                    break;
                }
            }
        }
        if (flag == 0) {
            for (int i = 1; i <= n - 1; i++) {
                if (s[i] == 'K' && s[i - 1] != '@') {
                    sum++;
                    flag = 1;
                    break;
                }
            }
        }
        out.println(sum);
    }
    
    private int count(char[] x) {
        int result = 0, n = x.length;
        for (int i = 1; i < n; i++) {
            if (x[i] == 'K' && x[i - 1] == 'V') {
                result++;
                i++;
            }
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
        try (ViciousKeyboard instance = new ViciousKeyboard()) {
            instance.solve();
        }
    }
}
