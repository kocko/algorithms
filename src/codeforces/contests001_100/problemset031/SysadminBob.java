package codeforces.contests001_100.problemset031;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class SysadminBob implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        String x = in.next();
        int n = x.length();
        boolean ok = x.charAt(0) != '@' && x.charAt(n - 1) != '@';
        int last = -2;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < n - 1; i++) {
            if (x.charAt(i) == '@') {
                list.add(i);
                if (i - last <= 2) {
                    ok = false;
                    break;
                } else {
                    last = i;
                }
            }
        }
        ok &= (list.size() > 0);
        if (!ok) {
            out.println("No solution");
            return;
        }
        StringJoiner joiner = new StringJoiner(",");
        int idx = 0, k = list.size();
        for (int i = 0; i < k; i++) {
            StringBuilder email = new StringBuilder();
            int j = list.get(i);
            email.append(x.substring(idx, j)).append("@");
            if (i == k - 1) {
                email.append(x.substring(j + 1));
            } else {
                email.append(x.substring(j + 1, list.get(i + 1) - 1));
                idx = list.get(i + 1) - 1;
            }
            joiner.add(email);
        }
        out.println(joiner.toString());
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
        try (SysadminBob instance = new SysadminBob()) {
            instance.solve();
        }
    }
}
