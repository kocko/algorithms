package codeforces.contests401_500.problemset471;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MUHAndSticks implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[] cnt = new int[10];
        for (int i = 0; i < 6; i++) {
            cnt[in.ni()]++;
        }
        boolean alien = true;
        for (int i = 1; i <= 9; i++) {
            if (cnt[i] >= 4) {
                alien = false;
            }
        }
        if (alien) {
            out.println("Alien");
        } else {
            for (int i = 1; i <= 9; i++) {
                if (cnt[i] == 2 || cnt[i] == 6) {
                    out.println("Elephant"); break;
                } else if (cnt[i] == 1) {
                    out.println("Bear"); break;
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
    
    public static void main(String[] args) throws IOException {
        try (MUHAndSticks instance = new MUHAndSticks()) {
            instance.solve();
        }
    }
}
