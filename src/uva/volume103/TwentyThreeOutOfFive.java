package uva.volume103;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TwentyThreeOutOfFive implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        while ((a[0] = in.ni()) != 0 && (a[1] = in.ni()) != 0 && (a[2] = in.ni()) != 0 && (a[3] = in.ni()) != 0 && (a[4] = in.ni()) != 0) {
            boolean possible = false;
            for (int i = 0; i < 5; i++) {
                used[i] = true;
                possible |= recurse(1, a[i]);
                used[i] = false;
            }
            out.println(possible ? "Possible" : "Impossible");
        }
    }
    
    private int[] a = new int[5];
    private boolean[] used = new boolean[5];
    
    private boolean recurse(int idx, int current) {
        if (idx == 5) {
            return (current == 23);
        }
        boolean result = false;
        for (int i = 0; i < 5; i++) {
            if (!used[i]) {
                used[i] = true;
                result |= recurse(idx + 1, current * a[i]);
                result |= recurse(idx + 1, current + a[i]);
                result |= recurse(idx + 1, current - a[i]);
                used[i] = false;
            }
        }
        return result;
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
        try (TwentyThreeOutOfFive instance = new TwentyThreeOutOfFive()) {
            instance.solve();
        }
    }
}
