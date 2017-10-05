package codeforces.contests801_900.problemset868;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class QualificationRounds implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);
    
    public void solve() {
        int n = in.ni(), k = in.ni();
        boolean[] has = new boolean[1 << k];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < k; j++) {
                sb.append(in.ni());
            }
            has[Integer.valueOf(sb.toString(), 2)] = true;
        }
        if (has[0]) {
            out.println("YES");
            return;
        }
        for (int i = 0; i < has.length; i++) {
            for (int j = 0; j < has.length; j++) {
                if (has[i] && has[j]) {
                    if ((i ^ j) == (i | j)) {
                        out.println("YES");
                        return;
                    }
                }
            }
        }
        out.println("NO");
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
        try (QualificationRounds instance = new QualificationRounds()) {
            instance.solve();
        }
    }
}
