package csadademy.problemset035;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DecreasingSubarrays implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = in.ni();
        int[] result = new int[n];
        int last = x[0];
        int start = 0, end = 0;
        for (int i = 1; i < n; i++) {
            if (x[i] < last) {
                end = i;
            } else {
                int size = end - start + 1;
                for (int j = start; j <= end; j++) {
                    result[j] = size;
                }
                start = i; 
                end = i;
            }
            last = x[i];
        }
        for (int i = start; i <= end; i++) {
            result[i] = end - start + 1;
        }
        for (int i = 0; i < n; i++) {
            out.print(result[i]);
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
        try (DecreasingSubarrays instance = new DecreasingSubarrays()) {
            instance.solve();
        }
    }
}
