package codeforces.contests301_400.problemset357;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class GroupOfStudents implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int m = in.ni();
        int[] c = new int[m], prefix = new int[m + 1];
        for (int i = 0; i < m; i++) {
            c[i] = in.ni();
            prefix[i + 1] = prefix[i] + c[i];
        }
        int x = in.ni(), y = in.ni();
        for (int i = 1; i <= m; i++) {
            int beginner = prefix[i], advance = prefix[m] - prefix[i];
            if (beginner >= x && beginner <= y && advance >= x && advance <= y) {
                out.println(i + 1);
                return;
            }
        }
        out.println(0);
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
        try (GroupOfStudents instance = new GroupOfStudents()) {
            instance.solve();
        }
    }
}
