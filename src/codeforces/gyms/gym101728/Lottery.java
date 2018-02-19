package codeforces.gyms.gym101728;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Lottery implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[] x = new int[10];
        for (int i = 0; i < 10; i++) {
            x[i] = in.ni();
        }
        int q = in.ni();
        while (q-- > 0) {
            int count = 0;
            for (int i = 0; i < 6; i++) {
                int next = in.ni();
                for (int j = 0; j < 10; j++) {
                    if (x[j] == next) {
                        count++;
                        break;
                    }
                }
            }
            out.println(count >= 3 ? "Lucky" : "Unlucky"); 
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
        try (Lottery instance = new Lottery()) {
            instance.solve();
        }
    }
}
