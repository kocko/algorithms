package codeforces.contests701_800.problemset798;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MikeAndStrings implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private final long INF = (long) 1e9;
    
    public void solve() {
        int n = in.ni();
        String[] x = new String[n];
        for (int i = 0; i < n; i++) x[i] = in.next();
        
        long min = INF;
        for (int i = 0; i < n; i++) {
            long local = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    local += f(x[i], x[j]);
                }
            }
            min = Math.min(min, local);
        }
        if (min >= INF) {
            out.println(-1);
        } else {
            out.println(min);
        }
    }
    
    private long f(String x, String y) {
        int index = (y + y).indexOf(x);
        return (index < 0) ? INF : index;
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
        try (MikeAndStrings instance = new MikeAndStrings()) {
            instance.solve();
        }
    }
}
