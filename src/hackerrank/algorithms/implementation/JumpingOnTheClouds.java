package hackerrank.algorithms.implementation;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JumpingOnTheClouds implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    private int n;
    private int[] clouds;
    private int result = 1000;
    
    public void solve() {
        n = in.ni();
        clouds = new int[n + 2];
        for (int i = 0; i < n; i++) {
            clouds[i] = in.ni();
        }
        clouds[n] = 1;
        clouds[n + 1] = 1;
        recurse(0, 0);
        out.println(result);
    }
    
    private void recurse(int current, int count) {
        if (current == n - 1) {
            result = Math.min(count, result);
        } else if (current < n - 1){
            if (clouds[current + 1] == 0) {
                recurse(current + 1, count + 1);
            }
            if (clouds[current + 2] == 0) {
                recurse(current + 2, count + 1);
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

    public static void main(String[] args) throws IOException {
        try (JumpingOnTheClouds instance = new JumpingOnTheClouds()) {
            instance.solve();
        }
    }
}
