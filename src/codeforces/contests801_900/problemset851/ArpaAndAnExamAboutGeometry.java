package codeforces.contests801_900.problemset851;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ArpaAndAnExamAboutGeometry implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long ax = in.nl(), ay = in.nl(),
             bx = in.nl(), by = in.nl(),
             cx = in.nl(), cy = in.nl();
        boolean ok = (ax - bx) * (ax - bx) + (ay - by) * (ay - by) == (bx - cx) * (bx - cx) + (by - cy) * (by - cy);
        ok &= (by - ay) * (cx - bx) != (cy - by) * (bx - ax);
        out.println(ok ? "Yes" : "No");
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
        try (ArpaAndAnExamAboutGeometry instance = new ArpaAndAnExamAboutGeometry()) {
            instance.solve();
        }
    }
}
