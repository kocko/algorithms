package codeforces.contests601_700.problemset689;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MikeAndCellphone implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        in.ni();
        String x = in.next();
        boolean[] mark = new boolean[10];
        for (char c : x.toCharArray()) {
            mark[c - '0'] = true;
        }
        boolean flag1 = false, flag2 = false;
        if ((mark[1] || mark[2] || mark[3]) && (mark[7] || mark[9]))
            flag1 = true;
        if ((mark[1] || mark[4] || mark[7]) && (mark[3] || mark[6] || mark[9]))
            flag2 = true;
        if ((mark[1] || mark[2] || mark[3]) && mark[0]) {
            out.println("YES");
            return;
        }
        if (flag1 && flag2) {
            out.println("YES");
            return;
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
        try (MikeAndCellphone instance = new MikeAndCellphone()) {
            instance.solve();
        }
    }
}
