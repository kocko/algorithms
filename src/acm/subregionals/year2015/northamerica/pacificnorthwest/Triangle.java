package acm.subregionals.year2015.northamerica.pacificnorthwest;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Triangle implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[] a = new int[] {in.ni(), in.ni(), in.ni()};
        int[] b = new int[] {in.ni(), in.ni(), in.ni()};
        Arrays.sort(a);
        Arrays.sort(b);
        if ((a[0] == b[0] && a[1] == b[1] && a[2] == b[2]) && (a[0] * a[0] + a[1] * a[1] == a[2] * a[2])) {
            out.println("YES");
        } else {
            out.println("NO");
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
        try (Triangle instance = new Triangle()) {
            instance.solve();
        }
    }
}
