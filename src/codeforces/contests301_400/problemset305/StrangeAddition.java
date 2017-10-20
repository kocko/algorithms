package codeforces.contests301_400.problemset305;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StrangeAddition implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        List<Integer> result = new ArrayList<>();
        boolean[] has = new boolean[2];
        int backup = -1;
        for (int i = 0; i < n; i++) {
            int next = in.ni();
            if (next == 0) result.add(0);
            else if (next == 100) result.add(100);
            else {
                if (next >= 1 && next <= 9) {
                    if (!has[0]) {
                        result.add(next);
                        has[0] = true;
                    }
                } else {
                    if (next % 10 == 0) {
                        if (!has[1]) {
                            result.add(next);
                            has[1] = true;
                        }
                    } else {
                        backup = next;
                    }
                }
            }
        }
        if (!has[0] && !has[1] && backup != -1) {
            result.add(backup);
        }
        out.println(result.size());
        for (int value : result) {
            out.print(value);
            out.print(' ');
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
        try (StrangeAddition instance = new StrangeAddition()) {
            instance.solve();
        }
    }
}
