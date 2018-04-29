package codeforces.contests901_1000.problemset967;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MindTheGap implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni(), s = in.ni();
        int[] h = new int[n], m = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.ni();
            m[i] = in.ni();
        }
        
        if (h[0] * 60 + m[0] - s >= 1) {
            out.println("0 0");
            return;
        }
        for (int i = 1; i < n; i++) {
            int prev = h[i - 1] * 60 + m[i - 1] + 1;    
            int current = h[i] * 60 + m[i];
            if (current - prev >= 2 * s + 1) {
                int moment = prev + s;
                out.println((moment / 60) + " " + (moment % 60));
                return;
            }
        }
        int moment = h[n - 1] * 60 + m[n - 1] + 1 + s;
        out.println((moment / 60) + " " + (moment % 60));
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
        try (MindTheGap instance = new MindTheGap()) {
            instance.solve();
        }
    }
}
