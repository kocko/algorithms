package codeforces.contests901_1000.problemset990;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BracketSequencesConcatenationProblem implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        final int MAX = (int) 3e5;
        long[] pos = new long[MAX + 3], neg = new long[MAX + 3];
        long zeroes = 0;
        for (int i = 0; i < n; i++) {
            char[] x = in.next().toCharArray();
            int open = 0;
            boolean negative = false;
            for (char ch : x) {
                open = (ch == '(') ? open + 1 : open - 1;
                if (open < 0) negative = true;
            }
            boolean ok = true;
            if (open < 0) {
                int cur = -open;
                for (char ch : x) {
                    if (ch == '(') cur++;
                    else {
                        cur--;
                        if (cur < 0) {
                            ok = false;
                            break;
                        }
                    }
                }
            } else {
                ok = !negative;
            }
            if (ok) {
                if (open > 0) {
                    pos[open]++;
                } else if (open < 0) {
                    neg[-open]++;
                } else {
                    zeroes++;
                }
            }
        }
        
        long result = zeroes * zeroes;
        for (int i = 1; i <= MAX; i++) {
            result += pos[i] * neg[i];
        }
        out.println(result);
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
        try (BracketSequencesConcatenationProblem instance = new BracketSequencesConcatenationProblem()) {
            instance.solve();
        }
    }
}
