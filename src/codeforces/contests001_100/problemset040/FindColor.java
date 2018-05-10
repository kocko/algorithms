package codeforces.contests001_100.problemset040;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class FindColor implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int x = in.ni(), y = in.ni();
        if (x == 0 || y == 0) {
            out.println("black");
        } else {
            int quadrant = x * y > 0 ? 1 : 2;
            double dist = sqrt(x * x + y * y);
            int circle = (int) ceil(dist);
            int color = 1;
            if (circle != (int) floor(dist)) {
                if (circle % 2 == 0) {
                    color = 0;
                }
                if (quadrant == 2) {
                    color ^= 1;
                }
            }
            out.println(color == 0 ? "white" : "black");
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
        try (FindColor instance = new FindColor()) {
            instance.solve();
        }
    }
}
