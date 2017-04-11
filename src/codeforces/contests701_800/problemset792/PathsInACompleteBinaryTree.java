package codeforces.contests701_800.problemset792;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PathsInACompleteBinaryTree implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        long n = in.nl(), q = in.nl();
        while (q-- > 0) {
            long pos = in.nl();
            char[] path = in.next().toCharArray();
            out.println(process(n, pos, path));
        }
    }
    
    private long process(long n, long pos, char[] path) {
        long root = (n + 1) >> 1;
        for (char c : path) {
            switch (c) {
                case 'U' : {
                    if (pos != root) {
                        long level = pos & -pos;
                        long next = level << 1L;
                        if ((pos & next) != 0) {
                            pos -= level;
                        } else {
                            pos += level;
                        }
                    }
                    break;
                }
                case 'L': {
                    if ((pos & 1) == 0) {
                        long bit = (pos & -pos) >> 1;
                        pos -= bit;
                    }
                    break;
                }
                case 'R': {
                    if ((pos & 1) == 0) {
                        long bit = (pos & -pos) >> 1;
                        pos += bit;
                    }
                    break;
                }
            }
        }
        return pos;
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
        try (PathsInACompleteBinaryTree instance = new PathsInACompleteBinaryTree()) {
            instance.solve();
        }
    }
}
