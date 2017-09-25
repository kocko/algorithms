package codeforces.contests801_900.problemset864;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FairGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] cnt = new int[101];
        for (int i = 0; i < n; i++) {
            cnt[in.ni()]++;
        }
        int other = 0;
        int[] result = new int[2];
        int idx = 0;
        for (int i = 1; i < 101; i++) {
            if (cnt[i] == n / 2) {
                if (idx == 2) {
                    out.println("NO");
                    return;
                }
                result[idx++] = i;
            }
            else if (cnt[i] > 0) other++;
        }
        if (other != 0) {
            out.println("NO");
        } else {
            out.println("YES");
            out.println(result[0] + " " + result[1]);
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
        try (FairGame instance = new FairGame()) {
            instance.solve();
        }
    }
}
