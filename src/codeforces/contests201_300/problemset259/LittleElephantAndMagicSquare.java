package codeforces.contests201_300.problemset259;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LittleElephantAndMagicSquare implements Closeable {

    private InputReader in = new InputReader(System.in);
    private PrintWriter out = new PrintWriter(System.out);

    public void solve() {
        int[][] s = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s[i][j] = in.ni();
            }
        }
        int x = s[0][1] + s[0][2], y = s[1][0] + s[1][2], z = s[2][0] + s[2][1];
        final int MAX = (int) 1e5; 
        for (int i = 1; i <= MAX; i++) {
            int total = i + x;
            int b = total - y;
            int c = total - z;
            if (b >= 1 && b <= MAX && c >= 1 && c <= MAX && i + b + c == total) {
                s[0][0] = i;
                s[1][1] = b;
                s[2][2] = c;
                break;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                out.print(s[i][j] + " ");
            }
            out.println();
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
        try (LittleElephantAndMagicSquare instance = new LittleElephantAndMagicSquare()) {
            instance.solve();
        }
    }
}
