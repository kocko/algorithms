package codeforces.contests901_1000.problemset940;

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

public class PhoneNumbers implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), k = in.ni();
        char[] x = in.next().toCharArray();
        boolean[] set = new boolean[26];
        for (int i = 0; i < n; i++) {
            set[x[i] - 'a'] = true;
        }
        List<Character> letters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (set[i]) {
                letters.add((char) ('a' + i));
            }
        }
        int count = letters.size();
        char[] result = new char[k];
        if (k > n) {
            for (int i = 0; i < k; i++) {
                if (i < n) {
                    out.print(x[i]);
                } else {
                    out.print(letters.get(0));
                }
            }
        } else {
            int idx = -1;
            char worst = letters.get(count - 1);
            for (int i = min(n - 1, k - 1); i >= 0; i--) {
                if (x[i] < worst) {
                    idx = i;
                    break;
                }
            }
            char replace = '?';
            for (char c : letters) {
                if (c > x[idx]) {
                    replace = c;
                    break;
                }
            }
            result[idx] = replace;
            for (int i = 0; i < idx; i++) {
                result[i] = x[i];
            }
            for (int i = idx + 1; i < k; i++) {
                result[i] = letters.get(0);
            }
            for (char c : result) {
                out.print(c);
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
        try (PhoneNumbers instance = new PhoneNumbers()) {
            instance.solve();
        }
    }
}
