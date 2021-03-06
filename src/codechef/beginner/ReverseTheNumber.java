package codechef.beginner;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ReverseTheNumber implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int n = in.ni();
        for (int i = 0; i < n; i++) {
            reverse(in.next());
        }
    }

    private void reverse(String x) {
        int n = x.length();
        char[] reverse = new char[n];
        for (int i = 0; i < n; i++) {
            reverse[i] = x.charAt(n - i - 1);
        }
        boolean startPrinted = false;
        for (int i = 0; i < n; i++) {
            if (reverse[i] != '0') {
                startPrinted = true;
                out.print(reverse[i]);
            } else if (startPrinted) {
                out.print(reverse[i]);
            }
        }
        out.println();
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

    public static void main(String[] args) {
        new ReverseTheNumber().solve();
    }
}
