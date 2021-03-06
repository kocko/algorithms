package codeforces.contests701_800.problemset749;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Voting implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int n = in.ni();
        char[] x = in.next().toCharArray();
        ArrayDeque<Integer> dem = new ArrayDeque<>();
        ArrayDeque<Integer> rep = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (x[i] == 'D') {
                dem.add(i);
            } else {
                rep.add(i);
            }
        }
        while (dem.size() > 0 && rep.size() > 0) {
            int d = dem.poll();
            int r = rep.poll();
            if (d < r) {
                dem.offer(d + n);
            } else {
                rep.offer(r + n);
            }
        }
        if (dem.size() == 0) {
            out.println("R");
        } else {
            out.println("D");
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
        try (Voting instance = new Voting()) {
            instance.solve();
        }
    }
}
