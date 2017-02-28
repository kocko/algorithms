package codeforces.contests501_600.problemset567;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BerlandNationalLibrary implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        int max = 0, current = 0;
        boolean[] inside = new boolean[1000001];
        while (n-- > 0) {
            char op = in.next().charAt(0);
            int number = in.ni();
            if (op == '+') {
                inside[number] = true;
                current++;
                max = Math.max(current, max);
            } else {
                if (!inside[number]) {
                    max++; 
                } else {
                    inside[number] = false;
                    current--;
                }
            }
        }
        out.println(max);
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
        try (BerlandNationalLibrary instance = new BerlandNationalLibrary()) {
            instance.solve();
        }
    }
}
