package codeforces.contests600_699.problemset632;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheSmallestStringConcatenation implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);

    class S implements Comparable<S> {
        private String s;

        public S(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(S o) {
            return (this.s + o.s).compareTo(o.s + this.s);
        }
    }
    public void solve() {
        int n = in.ni();
        S[] list = new S[n];
        for (int i = 0; i < n; i++) {
            list[i] = new S(in.next());
        }
        Arrays.sort(list);
        for (S s : list) {
            out.print(s.s);
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
        new TheSmallestStringConcatenation().solve();
    }
}
