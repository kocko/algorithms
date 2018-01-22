package codeforces.contests901_1000.problemset914;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ConanAndAgasaPlayACardGame implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), MAX = (int) 1e5 + 1;
        int[] cnt = new int[MAX];
        for (int i = 0; i < n; i++) {
            cnt[in.ni()]++;
        }
        boolean can = false;
        for (int i = 1; i < MAX; i++) {
            can |= cnt[i] % 2 == 1;
        }
        out.println(can ? "Conan" : "Agasa");
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
        try (ConanAndAgasaPlayACardGame instance = new ConanAndAgasaPlayACardGame()) {
            instance.solve();
        }
    }
}
