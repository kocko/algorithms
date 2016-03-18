package codeforces.contests401_500.problemset459;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PashmakAndGarden implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    public void solve() {
        int x1 = in.ni(), y1 = in.ni(), x2 = in.ni(), y2 = in.ni();
        int side;
        if (x1 == x2) {
            side = Math.abs(y2 - y1);
            out.println((x1 + side) + " " + y1 + " " + (x2 + side) + " " + y2);
        } else if (y1 == y2) {
            side = Math.abs(x2 - x1);
            out.println(x1 + " " + (y1 + side) + " " + x2 + " " + (y2 + side));
        } else {
            if (Math.abs(x1 - x2) != Math.abs(y1 - y2)) {
                out.println(-1);
            } else {
                side = Math.abs(y1 - y2);
                if (x1 < x2) {
                    if (y1 < y2) {
                        out.println((x1 + side) + " " + y1 + " " + x1 + " " + (y1 + side));
                    } else {
                        out.println((x1 + side) + " " + y1 + " " + x1 + " " + (y1 - side));
                    }
                } else {
                    if (y1 < y2) {
                        out.println((x1 - side) + " " + y1 + " " + x1 + " " + (y1 + side));
                    } else {
                        out.println((x1 - side) + " " + y1 + " " + x1 + " " + (y1 - side));
                    }
                }
            }
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

    public static void main(String[] args) {
        new PashmakAndGarden().solve();
    }
}
