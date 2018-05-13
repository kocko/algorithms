package uva.volume106;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class TheJackpot implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n;
        while ((n = in.ni()) != 0) {
            int current = 0, max = 0;
            for (int i = 0; i < n; i++) {
                int next = in.ni();
                current = max(next, current + next);
                if (current > max) max = current;
            }
            if (max <= 0) {
                out.println("Losing streak.");
            } else {
                out.printf("The maximum winning streak is %d.\n", max);
            }
        }
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

    @Override
    public void close() throws IOException {
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        try (TheJackpot instance = new TheJackpot()) {
            instance.solve();
        }
    }
}
